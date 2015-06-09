var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {

	var app =require('../app');
	var nosql = require('./nosql_controller.js');
	var insert_nosql = require('./insert_db.js');
	//insert_nosql.insert();

	app.io.on('connection', function (socket) {
		socket.emit('carinfo', {data:nosql.last});
	});
 
	res.render('index', { title: 'Remote Diagnostics'});
});

module.exports = router; 