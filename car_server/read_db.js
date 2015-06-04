var nosql = require('nosql').load('./database/db.nosql');
// --- WRITE 
 
nosql.description('car database.');
nosql.custom({ key: '3493893' });

// --- READ 
 
var description = nosql.description();
var custom = nosql.custom();
var callback = function(err, selected) {
    
    var users = [];
    selected.forEach(function(o) {
		// console.log(o.levels);
		   var jsonString = o;
		var jsonObj = JSON.parse(jsonString);
		console.log(jsonObj.key);

    });
 
    // how to sort? 
    // use Array.sort() function 
 
   
};
 
// var map = function(doc) {
//     if (doc.age > 24 && doc.age < 36)
//         return doc;
// };
 
nosql.all(callback);
// nosql.all(map, callback);
// nosql.one(map, function(doc) {});
// nosql.top(5, map, callback);
// nosql.each(function(doc, offset) {});
//  