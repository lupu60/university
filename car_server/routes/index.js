var express = require('express');
var router = express.Router();
var nosql = require('nosql').load('.././database/db.nosql');

	var read = function(err, selected){
    selected.forEach(function(o) {
        console.log(o.levels);
    });
};


/* GET home page. */
router.get('/', function(req, res, next) {
	// var nosql = require('./nosql_controller.js');
	// nosql.go();
	nosql.all(read);
  res.render('index', { title: 'Remote Diagnostics' });
});

module.exports = router;
