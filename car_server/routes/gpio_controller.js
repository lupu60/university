var Gpio = require('onoff').Gpio,
    wra = new Gpio(17, 'out');
    wrb = new Gpio(27, 'out');
    wla = new Gpio(22, 'out');
    wlb = new Gpio(23, 'out');
    
function up() {
    console.log("up");
    wra.write(1);
    wrb.write(0);   
    wla.write(0);
    wlb.write(1);
}

function down() {
    console.log("down");
    wra.write(0);
    wrb.write(1);   
    wla.write(1);
    wlb.write(0);
}

function left() {
    console.log("left");
    wra.write(1);
    wrb.write(0);   
    wla.write(1);
    wlb.write(0);
}

function right() {
    console.log("right");
    wra.write(0);
    wrb.write(1);   
    wla.write(0);
    wlb.write(1);
}

function stop() {
    console.log("stop");
    wra.write(0);
    wrb.write(0);   
    wla.write(0);
    wlb.write(0);
}
// function up() {
//     console.log("up");
// }

// function down() {
//     console.log("down");
// }

// function left() {
//     console.log("left");
// }

// function right() {
//     console.log("right");
// }

// function stop() {
//     console.log("stop");
// }
exports.moving = function(move) {
    switch (move["move"].val) {
        case "up":
            if (move["move"].data=="true") {
                up();
            } else {
                stop();
            };
            break;
        case "down":
            if (move["move"].data=="true") {
                down();
            } else {
                stop();
            };
            break;
        case "left":
            if (move["move"].data=="true") {
                left();
            } else {
                stop();
            };
            break;
        case "right":
            if (move["move"].data=="true") {
                right();
            } else {
                stop();
            };
            break;
        case "stop":
            stop();
            break;
    }
};
exports.gyro_moving = function(move){
    if (move["move"].y<-3) {
         up();
    };
    if (move["move"].y>3) {
        down();
    };
    if (move["move"].x<-3) {
         right();
    };
    if (move["move"].x>3) {
        left();
    };
    if (move["move"].x<3 &&move["move"].x>-3 && move["move"].y <3 && move["move"].y >-3  ) {
        stop();
    };
};