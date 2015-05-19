var socket = io();
var move = {
    "x": '1',
    "y": '1',
    "z":'1'
};

function send() {
    socket.emit('moving', {move});
    return false;
}

function myFunction() {
    setInterval(function() {
        send();
        },
        100
    );
}
if (window.DeviceMotionEvent != undefined) {
    window.ondevicemotion = function(e) {
        move.x = Math.round(e.accelerationIncludingGravity.x);
        move.y = Math.round(e.accelerationIncludingGravity.y);
        move.z = Math.round(e.accelerationIncludingGravity.z);
        $("#x").text(move.x);
        $("#y").text(move.y);
        $("#z").text(move.z);
    }
}

$( document ).ready(function() {
//   $(".logo").animate({  borderSpacing: -70 }, {
//     step: function(now,fx) {
//       $(this).css('-webkit-transform','rotate('+now+'deg)'); 
//       $(this).css('-moz-transform','rotate('+now+'deg)');
//       $(this).css('transform','rotate('+now+'deg)');
//     },
//     duration:'slow'
// },'linear');
 myFunction();
    console.log( "ready!" );
});
