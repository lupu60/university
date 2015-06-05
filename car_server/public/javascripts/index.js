var socket = io();

socket.on('carinfo', function (car) {

  console.log(car.data);
  levels(car.data.sensordata.levels);
});
function levels (levels){
	$('#fuel').css( "width", levels.fuel+"%" );
	console.log(levels.fuel);
}