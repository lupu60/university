var express = require('express');
var router = express.Router();

var Gpio = require('onoff').Gpio,
led = new Gpio(17, 'out');

/* GET home page. */
router.get('/', function(req, res, next) {
	res.render('index', { title: 'Express' });
});
router.get('/on', function(req, res, next) {
	console.log("on");

	var iv = setInterval(function(){
	led.writeSync(led.readSync() === 0 ? 1 : 0)
	}, 500);
	// Stop blinking the LED and turn it off after 5 seconds.
	setTimeout(function() {
	clearInterval(iv); // Stop blinking
	led.writeSync(0);  // Turn LED off.
	led.unexport();    // Unexport GPIO and free resources
	}, 5000);

	res.render('index', { title: 'Express' });
});


module.exports = router;
