var express = require('express');
var pg = require('pg');
var router = express.Router();

var db_url= "postgres://dipigtzgodfvyq:ZtgZZC9ImjGdqn9ynR5uaciPQH@ec2-54-83-52-71.compute-1.amazonaws.com:5432/d994h8hvvdstts";
// console.log(process.env.+db_url);

pg.connect(db_url + '?ssl=true',function(err, client) {
  if (err) throw err;
  console.log('Connected to postgres! Getting schemas...');

  // client
  //   .query('SELECT table_schema,table_name FROM information_schema.tables;')
  //   .on('row', function(row) {
  //     console.log(JSON.stringify(row));
  //   });
});


router.get('/tires', function(req, res, next) {
  connection.query('SELECT * FROM winterTire', function(err, rows, fields) {
    if (err) throw err;
    res.send(rows);
  });
});


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express'
  });
});

module.exports = router;
