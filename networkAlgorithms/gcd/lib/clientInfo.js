var fs = require('fs');

function makeId() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (var i = 0; i < 5; i++) text += possible.charAt(Math.floor(Math.random() * possible.length));
    return text;
}

function makeValue() {
    return Math.floor((Math.random() * 9999) + 1);
}

function makePort() {
    var x = Math.floor((Math.random() * 99999) + 1);
    if(x<65536 && x>0){
        return x;
    }
    else makePort();
}

function logIp() {
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
}
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