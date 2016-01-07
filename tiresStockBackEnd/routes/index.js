var express = require('express');
var mysql = require("mysql");
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  // password: "root",
  database: "tiresstock"
});
con.connect(function(err){
  if(err){
    console.log('Error connecting to Db');
    return;
  }
  console.log('Connection established');
});
var router = express.Router();
/* GET home page. */
router.get('/tires', function(req, res, next) {
  con.query('SELECT * FROM employees',function(err,rows,fields){
  if(err) throw err;
  res.send(rows);
  });
});

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

// con.end(function(err) {
//   // The connection is terminated gracefully
//   // Ensures all previously enqueued queries are still
//   // before sending a COM_QUIT packet to the MySQL server.
// });

module.exports = router;
