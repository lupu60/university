var connectTo = require('./lib/connectTo.js');
setTimeout(function() {
    connectTo.startClient();
}, 1000);
setTimeout(function() {
    connectTo.connectToServer();
}, 2000);
