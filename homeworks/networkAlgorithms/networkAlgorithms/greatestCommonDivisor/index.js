var assert = require('assert');
var restify = require('restify');
var fs = require('fs');
var clientInfo = require('./clientInfo.js');
var server = restify.createServer({
  name: 'greatestCommonDivisor',
  version: '1.0.0'
});
var client = restify.createJsonClient({
  //radu
  url: 'http://localhost:3000',
  version: '~1.0'
});
var clientParameters = {
  "id": clientInfo.makeId(),
  "value": clientInfo.makeValue(),
  "ip": clientInfo.logIp(),
};
var partnerParameters = {};

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
server.use(restify.acceptParser(server.acceptable));
server.use(restify.queryParser());
server.use(restify.bodyParser());

server.post('/partner', function(req, res, next) {
  partnerParameters = req.body;
  console.log(partnerParameters);
  console.log("partner: " + partnerParameters.value, " me: " + clientParameters.value);
  console.log("gcd= " + gcd(partnerParameters.value, clientParameters.value));

  setTimeout(function() {
    clientParameters.value = gcd(partnerParameters.value, clientParameters.value);
  }, 1000);

  setInterval(function() {
    console.log("new post");
    if (partnerParameters.value!=clientParameters.value) {
      client.post('/partner', clientParameters, function(err, req, res, obj) {
        assert.ifError(err);
      });
    }
  }, 3000);
  return next();
});
server.listen(3000, function() {
  console.log('%s listening at %s', server.name, server.url);
});

setTimeout(function() {
  client.post('/partner', clientParameters, function(err, req, res, obj) {
    assert.ifError(err);
  });
}, 3000);
