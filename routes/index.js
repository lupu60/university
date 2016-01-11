var express = require('express');
var router = express.Router();
var pg = require('pg');
var squel = require("squel");
squel.useFlavour('postgres');
var connect_string = 'postgres://oerwxunzakxntm:zMVQKkdOOHBxhRLzntgOSTdEem@ec2-54-83-52-71.compute-1.amazonaws.com:5432/df4a0g4bh0chk4?ssl=true';

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});
router.get('/winter', function(req, res, next) {
  res.render('winter');
});

router.get('/summer' ,function(req, res, next) {
  res.render('summer');
});
router.get('/agricultural' ,function(req, res, next) {
  res.render('agricultural');
});
pg.connect(connect_string, function(err, client) {
  if (err) throw err;
  console.log('Connected to postgres! Getting schemas...');
  // client.query('DROP TABLE winter_tire', function(err, result) {
  //   if (err)
  //    { console.error(err);  }
  //   else
  //    { res.send(result.rows)}
  // });
});



// List winter_tire
router.get('/winter_tire', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM winter_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        response.send("Error " + err);
      } else {
        res.send('{"tires":' + JSON.stringify(result.rows) + '}')
      }
    });
  });
});
//INSERT winter_tire
router.put('/winter_tire', function(req, res, next) {
  var query_text = squel.insert()
    .into("winter_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//UDPATE winter_tire
router.post('/winter_tire', function(req, res, next) {
  var query_text = squel.update()
    .table("winter_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//DELETE winter_tire
router.delete('/winter_tire', function(req, res, next) {
  var query_text = squel.delete()
    .from("winter_tire").where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});

//List summer_tire
router.get('/summer_tire', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM summer_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        response.send("Error " + err);
      } else {
        res.send('{"tires":' + JSON.stringify(result.rows) + '}')
      }
    });
  });
});
//INSERT summer_tire
router.put('/summer_tire', function(req, res, next) {
  var query_text = squel.insert()
    .into("summer_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//UDPATE summer_tire
router.post('/summer_tire', function(req, res, next) {
  var query_text = squel.update()
    .table("summer_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//DELETE summer_tire
router.delete('/summer_tire', function(req, res, next) {
  var query_text = squel.delete()
    .from("summer_tire").where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//List agricultural_tire
router.get('/agricultural_tire', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM agricultural_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        response.send("Error " + err);
      } else {
        res.send('{"tires":' + JSON.stringify(result.rows) + '}')
      }
    });
  });
});
//INSERT summer_tire
router.put('/agricultural_tire', function(req, res, next) {
  var query_text = squel.insert()
    .into("agricultural_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//UDPATE summer_tire
router.post('/agricultural_tire', function(req, res, next) {
  var query_text = squel.update()
    .table("agricultural_tire")
    .set("brand", req.body.brand)
    .set("size", req.body.size)
    .set("profile", req.body.profile)
    .set("speed_rating", req.body.speed_rating)
    .set("quantity", req.body.quantity)
    .set("price", req.body.price)
    .where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
//DELETE summer_tire
router.delete('/agricultural_tire', function(req, res, next) {
  var query_text = squel.delete()
    .from("agricultural_tire").where("id=" + req.body.id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text, function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send(err);
      } else {
        res.send("ok")
      }
    });
  });
});
module.exports = router;
