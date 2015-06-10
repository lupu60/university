var nosql = require('nosql').load('./database/db.nosql');
var d = new Date();
var t = Math.round(d.getTime() / (1000 * 60));

var all = function(err, selected) {
    selected.forEach(function(o) {
        exports.last = o;
    });
};

// var map = function(doc) {
//     if (doc["timestamp"]["minutes_70"] == t) return doc;
// };
// nosql.all(map, all);

exports.read = function() {
nosql.all(all);

};