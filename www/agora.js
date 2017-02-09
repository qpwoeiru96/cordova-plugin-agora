//cordova.define("la.sou.plugin.agora.agora", function(require, exports, module) {
    var exec = require('cordova/exec'),
        cordova = require('cordova'),
        channel = require('cordova/channel'),
        utils = require('cordova/utils');

    var eventHandlers = {};

    channel.onCordovaReady.subscribe(function () {
        cordova.exec(function (event) {
            if(typeof event === 'object') {
                if(eventHandlers[event.event]) {
                    for(var i in eventHandlers[event.event]) {
                        eventHandlers[event.event][i](event.data);
                    }
                }
            }

        }, function () {
            console.error("CordovaAgora: Failed to listen for events.");
        }, 'Agora', 'listenEvents', []);
    });

    module.exports = {

        addEventListener: function(eventName, callback) {
            if(!eventHandlers[eventName]) {
                eventHandlers[eventName] = [];
            }

            eventHandlers[eventName].push(callback);
        },

        removeEventListener: function(eventName, callback) {
            if(eventHandlers[eventName]) {
                for(var i in eventHandlers[eventName]) {
                    if(eventHandlers[eventName] === callback) {
                        eventHandlers.splice(i, 1);
                    }
                }
            }
        },

        create: function (config, successCallback, failCallback) {

            if(typeof config !== "object")
                throw new TypeError("config must be a object.");

            if(!config.appId)
                throw new TypeError("config must have key: appId.");

            cordova.exec(successCallback, failCallback, 'Agora', 'create', [config]);
        },

        joinChannel: function (channelKey, channelName, uid, successCallback, failCallback) {

            uid = parseInt(uid);

            if(!uid || isNaN(uid) || isFinite(uid))
                uid = 0;

            cordova.exec(successCallback, failCallback, 'Agora', 'joinChannel', [channelKey, channelName, uid]);
        },

        leaveChannel: function (successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'leaveChannel', []);
        },

        enableVideo: function(successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'enableVideo', []);
        },

        disableVideo: function(successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'disableVideo', []);
        },

        enableSpeakerphone: function(successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'enableSpeakerphone', []);
        },

        disableSpeakerphone: function(successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'disableSpeakerphone', []);
        },

        getCallId: function(successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'getCallId', []);
        },

        startRecordingService: function(recordingKey, successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'startRecordingService', [recordingKey]);
        },

        stopRecordingService: function(recordingKey, successCallback, failCallback) {
            cordova.exec(successCallback, failCallback, 'Agora', 'stopRecordingService', [recordingKey]);
        }
    };

//});
