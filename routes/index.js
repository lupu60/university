var express = require('express');
var router = express.Router();
var pg = require('pg');
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express2'
  });
});

router.get('/db', function(req, res, next) {
pg.connect(process.env.DATABASE_URL, function(err, client, done) {
    client.query('SELECT * FROM test_table', function(err, result) {
      done();
      if (err)
       { console.error(err); response.send("Error " + err); }
      else
       { res.send(result)}
    });
  });

});
module.exports = router;
