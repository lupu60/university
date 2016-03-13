var assert = require('assert');
var restify = require('restify');
var fs = require('fs');
var server = restify.createServer({
    name: 'gct',
    version: '1.0.0'
});

var clientsInfo = [];

server.use(restify.acceptParser(server.acceptable));
server.use(restify.queryParser());
server.use(restify.bodyParser());

server.post('/', function(req, res, next) {
    console.log('New Client', req.body, '\n');
    if (req.body != 'last') {
        clientsInfo.push(req.body);
    } else {
        res.send(clientsInfo[1]);
    };
    console.log(clientsInfo);
    if (clientsInfo.length > 1) {
        var client = restify.createJsonClient({
            url: 'http://' + clientsInfo[clientsInfo.length - 2].ip + ':' + clientsInfo[clientsInfo.length - 2].port,
            version: '~1.0'
        });
        client.post('/', clientsInfo[clientsInfo.length - 1], function(err, req, res, obj) {
            assert.ifError(err);
            // console.log('Server returned: %j', obj);
        });
        res.send('clientsInfo[1]');
    } else {
        res.send("you are the first");
    };
    return next();
});

server.listen(3000, function() {
    console.log('%s listening at %s', server.name, server.url);
});
