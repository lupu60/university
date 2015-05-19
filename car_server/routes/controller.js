var express = require('express');
var router = express.Router();


router.get('/', function(req, res, next) {
	var app =require('../app');
	
	var gpio_controller = require('./gpio_controller.js');

	app.io.on('connection', function (socket) {
		socket.on('moving', function (data) {
			gpio_controller.moving(data);
		});
	});

	res.render('controller', { title: 'Express' });

});
module.exports = router; 