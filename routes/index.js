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

router.get('/summer', function(req, res, next) {
  res.render('summer');
});

router.get('/agricultural', function(req, res, next) {
  res.render('agricultural');
});

router.get('/page_orders', function(req, res, next) {
  res.render('page_orders');
});
router.get('/page_customers', function(req, res, next) {
  res.render('page_customers');
});
router.get('/page_order_items', function(req, res, next) {
  res.render('page_order_items');
});

router.put('/place_order', function(req, res, next) {
  console.log(req.body);
  // INSERT ORDER

  var query_text_order = squel.insert()
    .into("orders")
    .set("customer_id", req.body.customer_id)
    .toString();
  pg.connect(connect_string, function(err, client, done) {
    client.query(query_text_order, function(err, result) {
      done();
      if (err) {
        console.error(err);
      } else {
        console.error("order inserted");
        order_id();
      }
    });
  });
  // find last order id
  function order_id() {
    pg.connect(connect_string, function(err, client, done) {
      client.query("SELECT id from orders order by 1 desc limit 1;", function(err, result) {
        done();
        if (err) {
          console.error(err);
        } else {
          insert_order_items(result.rows[0].id);
        }
      });
    });
  };

  function insert_order_items(order_id_value) {

    var order_items = req.body.orderitems_id.toString().split(";");
    var location = req.body.location.toString().split("/");
    for (var i in order_items) {
      switch (location[3]) {
        case "winter":
          var query_text_order_items = squel.insert()
            .into("order_items")
            .set("order_id", order_id_value)
            .set("winter_id", parseInt(order_items[i]))
            .set("agricultural_id", null)
            .set("summer_id", null)
            .toString();
          pg.connect(connect_string, function(err, client, done) {
            client.query(query_text_order_items, function(err, result) {
              done();
              if (err) {
                console.error(err);
              } else {
                console.log("ok");
              }
            });
          });
          break;
        case "summer":
          var query_text_order_items = squel.insert()
            .into("order_items")
            .set("order_id", order_id_value)
            .set("winter_id", null)
            .set("agricultural_id", null)
            .set("summer_id", parseInt(order_items[i]))
            .toString();
          pg.connect(connect_string, function(err, client, done) {
            client.query(query_text_order_items, function(err, result) {
              done();
              if (err) {
                console.error(err);
              } else {
                console.log("ok");
              }
            });
          });
          break;
        case "agricultural":
          var query_text_order_items = squel.insert()
            .into("order_items")
            .set("order_id", order_id_value)
            .set("winter_id", null)
            .set("agricultural_id", parseInt(order_items[i]))
            .set("summer_id", null)
            .toString();
          pg.connect(connect_string, function(err, client, done) {
            client.query(query_text_order_items, function(err, result) {
              done();
              if (err) {
                console.error(err);
              } else {
                console.log("ok");
              }
            });
          });
          break;
        default:
      }
    };
  };
  console.log("all_ok");
  res.send("ok");
});



// pg.connect(connect_string, function(err, client) {
//   if (err) throw err;
//   console.log('Connected to postgres! Getting schemas...');
//   client.query('SELECT LAST(customer_id) AS LastOrders FROM orders;', function(err, result) {
//     if (err)
//      { console.error(err);  }
//     else
//      { res.send(result.rows)}
//   });
// });



// List winter_tire
router.get('/winter_tire', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM winter_tire', function(err, result) {
      done();
      if (err) {
        console.error(err);
        res.send("Error " + err);
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
  console.log(query_text);
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
//INSERT agricultural_tire
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
//UDPATE agricultural_tire
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
//DELETE agricultural_tire
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
//List customers
router.get('/customers', function(req, res, next) {
  console.log("mata");
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM customers', function(err, result) {
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
//INSERT customers
router.put('/customers', function(req, res, next) {
  var query_text = squel.insert()
    .into("customers")
    .set("name", req.body.name)
    .set("phone_no", req.body.phone_no)
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
//UDPATE customers
router.post('/customers', function(req, res, next) {
  var query_text = squel.update()
    .table("customers")
    .set("name", req.body.name)
    .set("phone_no", req.body.phone_no)
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
//DELETE customers
router.delete('/customers', function(req, res, next) {
  var query_text = squel.delete()
    .from("customers").where("id=" + req.body.id)
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
//List order_items
router.get('/order_items', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM order_items', function(err, result) {
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
//INSERT order_items
router.put('/order_items', function(req, res, next) {
  var query_text = squel.insert()
    .into("order_items")
    .set("order_id", req.body.order_id)
    .set("winter_id", req.body.winter_id)
    .set("agricultural_id", req.body.agricultural_id)
    .set("summer_id", req.body.summer_id)
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
//UDPATE order_items
router.post('/order_items', function(req, res, next) {
  var query_text = squel.update()
    .table("order_items")
    .set("order_id", req.body.order_id)
    .set("winter_id", req.body.winter_id)
    .set("agricultural_id", req.body.agricultural_id)
    .set("summer_id", req.body.summer_id)
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
//DELETE order_items
router.delete('/order_items', function(req, res, next) {
  var query_text = squel.delete()
    .from("order_items").where("id=" + req.body.id)
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
//List orders
router.get('/orders', function(req, res, next) {
  pg.connect(connect_string, function(err, client, done) {
    client.query('SELECT * FROM orders', function(err, result) {
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
//INSERT orders
router.put('/orders', function(req, res, next) {
  var query_text = squel.insert()
    .into("orders")
    .set("customer_id", req.body.customer_id)
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
//UDPATE orders
router.post('/orders', function(req, res, next) {
  var query_text = squel.update()
    .table("orders")
    .set("customer_id", req.body.customer_id)
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
//DELETE orders
router.delete('/orders', function(req, res, next) {
  var query_text = squel.delete()
    .from("orders").where("id=" + req.body.id)
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
