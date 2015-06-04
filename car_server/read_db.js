var Datastore = require('nedb')
  , db = new Datastore({ filename: './database/car.db', autoload: true });
  
var obj;

db.find({}, function (err, docs) {
   obj=docs;

});
    console.log(obj);