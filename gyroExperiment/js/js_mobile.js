 myFunction();
        var messagesRef = new Firebase('https://gyrotest.firebaseio.com/');
        var x, y, z;
        var key;
        if (window.DeviceMotionEvent != undefined) {
            window.ondevicemotion = function(e) {
                x = e.accelerationIncludingGravity.x;
                y = e.accelerationIncludingGravity.y;
                z = e.accelerationIncludingGravity.z;
                $("#x").text(x);
                $("#y").text(y);
                $("#z").text(z);
            }
        }

        function myFunction() {
            setInterval(function() {
                    if (x > 4 && y < -3) {
                        key = 1;
                        $(".logo").rotate({
                            animateTo: -70
                        })
                    }
                    if (x > 4 && y > 3) {
                        key = 6;
                    }
                    if (x < -4 && y < -3) {
                        key = 3;
                        $(".logo").rotate({
                            animateTo: 70
                        })
                    }
                    if (x < -4 && y > 3) {
                        key = 4;
                    }
                    if (x < 4 && x > -4 && y < 0) {
                        key = 2;
                        $(".logo").rotate({
                            animateTo: 0
                        })
                    }
                    if (x < 4 && x > -4 && y > 0) {
                        key = 5;
                    }
                    //firebase
                    messagesRef.update({
                        key: key
                    });

                },
                100
            );
        }