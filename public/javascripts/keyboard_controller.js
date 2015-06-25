var socket = io.connect(':4000');
var move = {
    "data": '',
    "val": ''
};
function send(move) {
    socket.emit('moving', {move:move});
    return false;
};
function startPeristentVibrate(level) {
 navigator.vibrate(level);
};
function stopVibrate() {
navigator.vibrate(0);
navigator.vibrate([]);
};
function touchstart(selector) {
    startPeristentVibrate(5000);
    $(selector).css({
        'background-color': '#1AFF00'
    });
    move.data = "true";
    move.val = selector[0].id;
    send(move);
};
function touchend(selector) {
    stopVibrate();
    $(selector).css({
        'background-color': '#F1F1F1'
    });
    move.data = "false";
    move.val = selector[0].id;
    send(move);
};
$(document).ready(function () {
    $('#up').bind('touchstart', function () {
        touchstart($(this));
    });
    $('#up').bind('touchend', function () {
        touchend($(this));
    });
    $('#down').bind('touchstart', function () {
        touchstart($(this));
    });
    $('#down').bind('touchend', function () {
        touchend($(this));
    });
    $('#left').bind('touchstart', function () {
        touchstart($(this));
    });
    $('#left').bind('touchend', function () {
        touchend($(this));
    });
    $('#right').bind('touchstart', function () {
        touchstart($(this));
    });
    $('#right').bind('touchend', function () {
        touchend($(this));
    });
    $('#stop').bind('touchstart', function () {
        startPeristentVibrate(5000);
        $(this).css({
            'background-color': 'red'
        });
        move.data = "true";
        move.val = "stop";
        send(move);
    });
    $('#stop').bind('touchend', function () {
        stopVibrate();
        $(this).css({
            'background-color': '#F1F1F1'
        });
    });
});