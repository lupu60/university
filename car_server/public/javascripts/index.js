var socket = io();
socket.on('carinfo', function(car) {
    levels(car.data.sensordata.levels);
    temperatures(car.data.sensordata.temperatures);
    console.log(car);
});

function levels(levels) {
    $('#fuel').css("width", levels.fuel + "%");
    $('#oil').css("width", levels.oil + "%");
    $('#windshield').css("width", levels.windshield_washer_fluid + "%");
};

function temperatures(temperatures){
console.log();
$('#engine').circleProgress({
    value: "."+temperatures.engine,
    fill: {
        gradient: [
            ['#ff1e41', .5],
            ['#ff5f43', .5]
        ],
        gradientAngle: Math.PI / 4
    }
}).on('circle-animation-progress', function(event, progress, stepValue) {
    $(this).find('strong').text(String(stepValue.toFixed(2)).substr(1));
});

$('#outside').circleProgress({
    value: "."+temperatures.outside,
    fill: {
        gradient: [
            ['#0681c4', .5],
            ['#4ac5f8', .5]
        ],
        gradientAngle: Math.PI / 4
    }
}).on('circle-animation-progress', function(event, progress, stepValue) {
    $(this).find('strong').text(String(stepValue.toFixed(2)).substr(1));
});
};
