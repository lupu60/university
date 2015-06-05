var nosql = require('nosql').load('./database/db.nosql');
var usage = require('usage');
var d = new Date();
// --- WRITE  
// nosql.description('car_database.');
// nosql.custom({ key: '412412352345234134' });
// // --- READ 
// var description = nosql.description();
// var custom = nosql.custom();
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
// //var pid = (process.argv[2])? parseInt(process.argv[2]): process.pid;
// var pid = process.pid 
// setInterval(function() {


// usage.lookup(pid, function(err, result) {

// 		console.log(err, result);
// 		console.log(result.cpu);
// 				console.log(result.memory);
// 	});
// }, 2000);

var fuel=24.5;
var rpm=17629184;


var car={
  "timestamp":{
    "day":d.getDate(),
    "month":d.getMonth(),
    "year":d.getFullYear()
  },
  "sensordata": {
    "levels": {
      "fuel": fuel,
      "oil": 50,
      "brake_fluid":70,
      "windshield_washer_fluid":80
    },
    "engine_RPM":rpm,
    "temperatures": {
      "engine": 50,
      "outside": 25
    }
  }
}
nosql.insert(car, callback);

