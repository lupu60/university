var nosql = require('nosql').load('./database/db.nosql');
var usage = require('usage');
var d = new Date();
var t = Math.round(d.getTime() / (1000 * 60));

function init_car() {
    var car = {
        "timestamp": {
            "minutes_70": t,
            "minutes": d.getMinutes(),
            "day": d.getDate(),
            "month": d.getMonth(),
            "year": d.getFullYear()
        },
        "sensordata": {
            "levels": {
                "fuel": Math.floor((Math.random() * 100) + 1),
                "oil": Math.floor((Math.random() * 100) + 1),
                "brake_fluid": Math.floor((Math.random() * 100) + 1),
                "windshield_washer_fluid": Math.floor((Math.random() * 100) + 1)
            },
            "engine_RPM": Math.floor((Math.random() * 100) + 1),
            "temperatures": {
                "engine": Math.floor((Math.random() * 100) + 1),
                "outside": Math.floor((Math.random() * 100) + 1)
            }
        }
    }
    return car;
}

exports.insert = function() {
    nosql.insert(init_car());
};