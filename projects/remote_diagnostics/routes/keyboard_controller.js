var express = require('express');
var router = express.Router();
var io = require('socket.io').listen(4000);
var gpio_controller = require('./gpio_controller.js');
router.get('/', function(req, res, next) {
    res.render('keyboard_controller', {
        title: 'Keyboard Controller'
    });
});
io.sockets.on('connection', function(socket) {
    socket.on('moving', function(data) {
        gpio_controller.moving(data);
    });
    socket.on('disconnect', function() {
        gpio_controller.user_left();
    });
});
module.exports = router;