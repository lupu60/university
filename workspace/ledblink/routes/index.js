var express = require('express');
var router = express.Router();

var gpio = require("pi-gpio");
/* GET home page. */
router.get('/', function(req, res, next) {
	res.render('index', { title: 'Express' });
});

router.get('/on', function(req, res, next) {
	console.log("on");

gpio.open(16, "output", function(err) {     // Open pin 16 for output 
    gpio.write(16, 1, function() {          // Set pin 16 high (1) 
        gpio.close(16);                     // Close pin 16 
    });
});
	res.render('index', { title: 'Express' });
});


module.exports = router;
