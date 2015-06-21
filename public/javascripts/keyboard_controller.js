var socket = io.connect(':4000');
var move = {
    "data": '',
    "val": ''
};

function send(move) {
    socket.emit('moving', {
        move
    });
    return false;
};
$(document).ready(function() {
    $('#up').bind('touchstart', function() {
        $(this).css({
            'background-color': '#1AFF00'
        });
        move.data = "true";
        move.val = "up";
        send(move);
    });
    $('#up').bind('touchend', function() {
        $(this).css({
            'background-color': '#F1F1F1'
        });
        move.data = "false";
        move.val = "up";
        send(move);
    });
    $('#down').bind('touchstart', function() {
        $(this).css({
            'background-color': '#1AFF00'
        });
        move.data = "true";
        move.val = "down";
        send(move);
    });
    $('#down').bind('touchend', function() {
        $(this).css({
            'background-color': '#F1F1F1'
        });
        move.data = "false";
        move.val = "down";
        send(move);
    });
    $('#left').bind('touchstart', function() {
        $(this).css({
            'background-color': '#1AFF00'
        });
        move.data = "true";
        move.val = "left";
        send(move);
    });
    $('#left').bind('touchend', function() {
        $(this).css({
            'background-color': '#F1F1F1'
        });
        move.data = "false";
        move.val = "left";
        send(move);
    });
    $('#right').bind('touchstart', function() {
        $(this).css({
            'background-color': '#1AFF00'
        });
        move.data = "true";
        move.val = "right";
        send(move);
    });
    $('#right').bind('touchend', function() {
        $(this).css({
            'background-color': '#F1F1F1'
        });
        move.data = "false";
        move.val = "right";
        send(move);
    });
    $('#stop').bind('touchstart', function() {
        $(this).css({
            'background-color': 'red'
        });
        move.data = "true";
        move.val = "stop";
        send(move);
    });
    $('#stop').bind('touchend', function() {
        $(this).css({
            'background-color': '#F1F1F1'
        });
    });
});