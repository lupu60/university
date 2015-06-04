
var d = new Date();
var t = d.getTime();
var time = Math.round(t/86400000);
var Datastore = require('nedb')
  , db = new Datastore({ filename: './database/car.db', autoload: true });
// You can issue commands right away
var doc = { hello: 'world'
               , n: 5
               , today: new Date()
               , nedbIsAwesome: true
               , notthere: null
               , notToBeSaved: undefined  // Will not be saved
               , fruits: [ 'apple', 'orange', 'pear' ]
               , infos: { name: 'nedb' }
               };

db.insert(doc, function (err, newDoc) {   // Callback is optional
  // newDoc is the newly inserted document, including its _id
  // newDoc has no key called notToBeSaved since its value was undefined
});