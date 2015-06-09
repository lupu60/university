var socket = io();

socket.on('carinfo', function (car) {
  levels(car.data.sensordata.levels);
});

function levels (levels){
	$('#fuel').css( "width", levels.fuel+"%" );
	$('#oil').css( "width", levels.oil+"%" );
	$('#windshield').css( "width", levels.windshield_washer_fluid+"%" );
};
