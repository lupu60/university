var assert = require('assert');
var restify = require('restify');
var portastic = require('node-portastic');
var clientInfo = require('./clientInfo.js');
var myClientInfo = {
    "id": clientInfo.makeId(),
    "value": clientInfo.makeValue(),
    "ip": clientInfo.logIp(),
    "port": clientInfo.makePort()
};
console.log('My Client Info=:', myClientInfo);
exports.startClient = function() {
    var server = restify.createServer({
        name: 'gct-client',
        version: '1.0.0'
    });
    server.use(restify.acceptParser(server.acceptable));
    server.use(restify.queryParser());
    server.use(restify.bodyParser());
    server.post('/', function(req, res, next) {
        console.log('Connect TO:', req.body);
        connectOtherClient(req.body);
        res.send("ok");
        return next();
    });
    server.post('/partner', function(req, res, next) {
        console.log('Partner', req.body);
        res.send(gcd(myClientInfo.value, req.body.value).toString());
        return next();
    });
    server.listen(myClientInfo.port, function() {
        console.log('%s listening at %s', server.name, server.url);
    });

    function gcd(a, b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        if (b > a) {
            var temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            if (b == 0) return a;
            a %= b;
            if (a == 0) return b;
            b %= a;
        }
    };
};
exports.connectToServer = function() {
    var client = restify.createJsonClient({
        url: 'http://localhost:3001',
        version: '~1.0'
    });
    client.post('/', myClientInfo, function(err, req, res, obj) {
        assert.ifError(err);
    });
};

function connectOtherClient(connectClientInfo) {
    var client = restify.createJsonClient({
        url: 'http://' + connectClientInfo.ip + ':' + connectClientInfo.port,
        version: '~1.0'
    });
    client.post('/partner', myClientInfo, function(err, req, res, obj) {
        assert.ifError(err);
        console.log('gcd= ', obj);
    });
};
