exports.makeId = function() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (var i = 0; i < 5; i++) text += possible.charAt(Math.floor(Math.random() * possible.length));
    return text;
};
exports.makeValue = function() {
    return Math.floor((Math.random() * 9999) + 1);
};
exports.makePort = function() {
    return Math.floor(Math.random() * (8079 - 8000)) + 8000;
};
exports.logIp = function() {
    var os = require('os');
    var interfaces = os.networkInterfaces();
    var addresses = [];
    for (var k in interfaces) {
        for (var k2 in interfaces[k]) {
            var address = interfaces[k][k2];
            if (address.family === 'IPv4' && !address.internal) {
                addresses.push(address.address);
            }
        }
    }
    return addresses[0];
};
var fs = require('fs');
exports.makeClient = function() {
    var client = {
        "id": makeId(),
        "value": makeValue(),
        "ip": logIp(),
        "port": makePort(),
        "connectIp": JSON.parse(fs.readFileSync('conf.json', 'utf8')).ip,
        "connectPort": JSON.parse(fs.readFileSync('conf.json', 'utf8')).port,
    }
    fs.writeFile("conf.json", JSON.stringify(client), function(err) {
        if (err) {
            return console.log(err);
        }
        console.log("The file was saved!");
    });
}
