var express = require('express');
var router = express.Router();
var pg = require('pg');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express'
  });
});

pg.connect('postgres://oerwxunzakxntm:zMVQKkdOOHBxhRLzntgOSTdEem@ec2-54-83-52-71.compute-1.amazonaws.com:5432/df4a0g4bh0chk4?ssl=true', function(err, client) {
  if (err) throw err;
  console.log('Connected to postgres! Getting schemas...');
  // client.query('DROP TABLE foo', function(err, result) {
  //   if (err)
  //    { console.error(err);  }
  //   else
  //    { res.send(result.rows)}
  // });
});



// List winter_tire
router.get('/winter_tire', function(req, res, next) {
  pg.connect(process.env.DATABASE_URL, function(err, client, done) {
    client.query('SELECT * FROM winter_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        response.send("Error " + err);
      } else {
              res.send('{"tires":'+JSON.stringify(result.rows)+'}')
      }
    });
  });
});

router.put('/winter_tire', function(req, res, next) {
  console.log(req.body.brand);
  res.send(req.body);
  var query_text = 'INSERT INTO winter_tire (brand ,size ,profile ,speed_rating ,quantity , price ) values (' + req.body.brand + ',' + req.body.size + ',' + req.body.profile + ',' + req.body.speed_rating + ',' + req.body.quantity + ', ' + req.body.price + ');'
  console.log(query_text);

  pg.connect('postgres://oerwxunzakxntm:zMVQKkdOOHBxhRLzntgOSTdEem@ec2-54-83-52-71.compute-1.amazonaws.com:5432/df4a0g4bh0chk4?ssl=true', function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err)
       { console.error(err); }
      else
       { res.send(result.rows)}
    });
  });
});

router.get('/summer_tire', function(req, res, next) {
  pg.connect('postgres://oerwxunzakxntm:zMVQKkdOOHBxhRLzntgOSTdEem@ec2-54-83-52-71.compute-1.amazonaws.com:5432/df4a0g4bh0chk4?ssl=true', function(err, client, done) {
    client.query('SELECT * FROM summer_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        response.send("Error " + err);
      } else {
        res.send('{"tires":'+result.rows+'}')
      }
    });
  });

});
module.exports = router;
