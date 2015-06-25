var socket = io.connect(':5000');
var move = {
    "x": '1',
    "y": '1',
    "z": '1'
};

function send() {
    socket.emit('moving', {move:move});
    return false;
}

function wheel() {
    if (move.x < -3) {
        $(".wheel").rotate({
            animateTo: 70
        })
    }
    if (move.x > 3) {
        $(".wheel").rotate({
            animateTo: -70
        })
    }
    if (move.x < 3 && move.x > -3) {
        $(".wheel").rotate({
            animateTo: 0
        })
    }
};
if (window.DeviceMotionEvent != undefined) {
    window.ondevicemotion = function(e) {
        move.x = Math.round(e.accelerationIncludingGravity.x);
        move.y = Math.round(e.accelerationIncludingGravity.y);
        move.z = Math.round(e.accelerationIncludingGravity.z);
        $("#x").text(move.x);
        $("#y").text(move.y);
        $("#z").text(move.z);
    }
};
$(document).ready(function() {
    watch(move, ["x", "y"], function() {
        send();
        wheel();
    });
});