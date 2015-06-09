var express = require('express');
var router = express.Router();

var car={};
/* GET home page. */
router.get('/', function(req, res, next) {
	var nosql = require('./nosql_controller.js');
	car = nosql.read();

	var app =require('../app');
	app.io.on('connection', function (socket) {
		socket.emit('carinfo', {data:car});
	});
	res.render('index', { title: 'Remote Diagnostics'});
});

module.exports = router;
