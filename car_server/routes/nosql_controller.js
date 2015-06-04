var nosql = require('nosql').load('.././database/db.nosql');


exports.go = function(){
	var read = function(err, selected){
    selected.forEach(function(o) {
        console.log(o);
    });
};

nosql.all(read);
};