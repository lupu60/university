var express = require('express');
var router = express.Router();


router.get('/', function(req, res, next) {
	var app =require('../app');
	
	var gpio_controller = require('./gpio_controller.js');
	
	app.io.on('connection', function (socket) {
		socket.on('moving', function (data) {
			gpio_controller.gyro_moving(data);
		});
	});

	res.render('gyroscope_controller', { title: 'Gyroscope Controller' });

});
module.exports = router; 