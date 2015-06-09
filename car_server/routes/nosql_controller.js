var d = new Date();
var app =require('../app');


var all = function(err, selected) {
    selected.forEach(function(o) {
        exports.last = o;
    });
};

var map = function(doc) {
	if (doc["timestamp"]["day"]==d.getDate())
		 return doc;
};
app.nosql.all(map, all);

exports.read = function() {


 // nosql.all(timeStamp);
};
