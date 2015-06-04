
var d = new Date();
var t = d.getTime();
var time = Math.round(t/86400000);
var nosql = require('nosql').load('./database/db.nosql');

// --- WRITE 
 
nosql.description('car database.');
nosql.custom({ key: '3493893' });
 
// --- READ 
 
var description = nosql.description();
var custom = nosql.custom();
 

 
// --- OTHER 
 
// Database date created 
nosql.created;
 
if (!nosql.isReady) {
    // YOU MUST WAIT :-) 
}
 
nosql.on('load', function() {
   // I'm ready 
});
 var callback = function(err, count) {
    
};


// var x ="{'"+time+":{'levels':{'oil':10,'fuel':50},'temperatures':{'engine':50,'outside':25}}}";
// nosql.insert(x, callback);

// var oil =50;
// var x ="{"+time+":{levels:{oil:50,fuel:50},temperatures:{engine:50,outside:25}}}";
// nosql.insert(x, callback);
 nosql.insert({""+time+"":{"levels":{"oil":10,"fuel":50},"temperatures":{"engine":50,"outside":25}}}, callback);
// nosql.insert({time:{levels:{oil:50,fuel:50},temperatures:{engine:50,outside:25}}}, callback);