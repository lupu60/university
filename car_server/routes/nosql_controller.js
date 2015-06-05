var d = new Date();
var nosql = require('nosql').load('./database/db.nosql');
// --- WRITE 
// nosql.description('car_database.');
// nosql.custom({key: '412412352345234134'});

var car={};
var all = function(err, selected) {
    selected.forEach(function(o) {
        car= o;
    });
};
var timeStamp = function(err, selected) {
    selected.forEach(function(o) {
        // console.log(o["timestamp"]);
    });
};

exports.read = function() {
 nosql.all(all);
 return car;
 // nosql.all(timeStamp);
};
