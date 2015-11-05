var assert = require('assert');
var restify = require('restify');
var fs = require('fs');
var clientInfo = require('./lib/clientInfo.js');


clientInfo.makeClient();

function main() {
    /*============================
    =            Conf            =
    ============================*/
    var conf = JSON.parse(fs.readFileSync('conf.json', 'utf8'));
    /*=====  End of Conf  ======*/
    var server = restify.createServer({
        name: 'gct',
        version: '1.0.0'
    });
    server.use(restify.acceptParser(server.acceptable));
    server.use(restify.queryParser());
    server.use(restify.bodyParser());

    server.post('/', function(req, res, next) {
        res.send(conf.id);
        return next();
    });

    server.listen(conf.port, function() {
        console.log('%s listening at %s', server.name, server.url);
    });

    var client = restify.createJsonClient({
      url: 'http://'+conf.connectIp+':'+conf.connectPort+'',
      version: '~1.0'
    });

    client.post('/',{ hello: 'world' },function (err, req, res, obj) {
      assert.ifError(err);
      console.log('Server returned: %j', obj);
    });
};

setTimeout(main, 500);