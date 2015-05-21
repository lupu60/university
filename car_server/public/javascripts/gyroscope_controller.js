/* 
 * JQuery CSS Rotate property using CSS3 Transformations
 * Copyright (c) 2011 Jakub Jankiewicz  <http://jcubic.pl>
 * licensed under the LGPL Version 3 license.
 * http://www.gnu.org/licenses/lgpl.html
 */
(function($) {
    function getTransformProperty(element) {
        var properties = ['transform', 'WebkitTransform', 'MozTransform', 'msTransform', 'OTransform'];
        var p;
        while (p = properties.shift()) {
            if (element.style[p] !== undefined) {
                return p;
            }
        }
        return false;
    }
    $.cssHooks['rotate'] = {
        get: function(elem, computed, extra) {
            var property = getTransformProperty(elem);
            if (property) {
                return elem.style[property].replace(/.*rotate\((.*)deg\).*/, '$1');
            } else {
                return '';
            }
        },
        set: function(elem, value) {
            var property = getTransformProperty(elem);
            if (property) {
                value = parseInt(value);
                $(elem).data('rotatation', value);
                if (value == 0) {
                    elem.style[property] = '';
                } else {
                    elem.style[property] = 'rotate(' + value % 360 + 'deg)';
                }
            } else {
                return '';
            }
        }
    };
    $.fx.step['rotate'] = function(fx) {
        $.cssHooks['rotate'].set(fx.elem, fx.now);
    };
})(jQuery);
/*==========  my  ==========*/
var socket = io();
var move = {
    "x": '1',
    "y": '1',
    "z": '1'
};

function send() {
    socket.emit('moving', {
        move
    });
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
$(document).ready(function() {
    watch(move, ["x", "y"], function() {
        send();
        wheel();
    });
});