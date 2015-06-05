var express = require('express');
var router = express.Router();
var car={};
/* GET home page. */
router.get('/', function(req, res, next) {
	var app =require('../app');
	var nosql = require('./nosql_controller.js');
	car=nosql.read();
	console.log(car);
	app.io.on('connection', function (socket) {
		socket.emit('carinfo', {data:car});
	});
	// console.log(car["sensordata"]["levels"]["fuel"]);
	res.render('index', { title: 'Remote Diagnostics'});
});
   
module.exports = router;
