var express = require('express');
var router = express.Router();
var pg = require('pg');
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express'
  });
});

router.get('/db', function(req, res, next) {
pg.connect(process.env.DATABASE_URL+ '?ssl=true', function(err, client, done) {
    client.query('SELECT * FROM winter_tire', function(err, result) {
      done();
      if (err)
       { console.error(err); response.send("Error " + err); }
      else
       { res.send(result.rows)}
    });
  });

});
module.exports = router;
