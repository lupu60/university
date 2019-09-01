var messagesRef = new Firebase('https://gyrotest.firebaseio.com/');
var game = function () {
    var p = Math.random,
            w, i, s = [],
            C, x = 0,
            z = "",
            m = {
                maxHeight: 900,
                maxCurve: 300,
                length: 3E3,
                curvy: 0.8,
                mountainy: 0.8,
                zoneSize: 150
            }, q = [],
            c = {
                width: 320,
                height: 240,
                depthOfField: 150,
                camera_distance: 30,
                camera_height: 100
            }, e = {
                position: 10,
                speed: 0,
                acceleration: 0.05,
                deceleration: 0.3,
                breaking: 0.6,
                turning: 2.5,
                posx: 0,
                maxSpeed: 15
            }, D, E, J = {
                x: 161,
                y: 0,
                w: 69,
                h: 38
            }, K = {
                x: 231,
                y: 0,
                w: 77,
                h: 38
            }, L = {
                x: 309,
                y: 0,
                w: 77,
                h: 38
            }, u = {
                x: 0,
                y: 0,
                w: 160,
                h: 60
            }, M = {
                x: 387,
                y: 0,
                w: 23,
                h: 50
            }, N = {
                x: 411,
                y: 0,
                w: 11,
                h: 14
            }, P = function () {
                w = $("#c")[0];
                i = w.getContext("2d");
                w.height = c.height;
                w.width = c.width;
                F();
                $(window).resize(F);
                messagesRef.on('child_changed', function () {
                    messagesRef.once('value', function (snapshot) {
                        var key = snapshot.child('key').val();
                        switch (key) {
                            case 1:
                                s[38] = true;
                                s[37] = true;
                                s[39] = false;
                                s[40] = false;
                                $(".wheel").rotate({animateTo: -70})
                                break;
                            case 2:
                                s[38] = true;
                                s[37] = false;
                                s[39] = false;
                                s[40] = false;
                                $(".wheel").rotate({animateTo: 0})
                                break;
                            case 3:
                                s[38] = s[39] = true;
                                s[37] = s[40] = false;
                                $(".wheel").rotate({animateTo: 70})
                                break;
                            case 4:
                                s[39] = s[40] = true;
                                s[37] = s[38] = false;
                                break;
                            case 5:
                                s[40] = true;
                                s[39] = s[37] = s[38] = false;
                                break;
                        }
                    });
                });

                O()
            }, R = function () {
                clearInterval(D);
                E = setInterval(Q, 30);
                C = new Date

            }, Q = function () {
                i.fillStyle = "#dc9";
                i.fillRect(0, 0, c.width, c.height);
                if (Math.abs(x) > 130) {
                    if (e.speed > 3) e.speed -= 0.2
                } else if (s[38]) e.speed += e.acceleration;//up
                else e.speed -= s[40] ? e.breaking : e.deceleration;//down
                e.speed = Math.max(e.speed, 0);
                e.speed = Math.min(e.speed, e.maxSpeed);
                e.position += e.speed;
                if (s[37]) {
                    //left
                    if (e.speed > 0) e.posx -= e.turning;
                    var a = {
                        a: K,
                        x: 117,
                        y: 190
                    }
                } else if (s[39]) {
                    //right
                    if (e.speed > 0) e.posx += e.turning;
                    a = {
                        a: L,
                        x: 125,
                        y: 190
                    }
                } else a = {
                    a: J,
                    x: 125,
                    y: 190
                };
                S(-e.posx);
                var d = [],
                        b = Math.floor(e.position /
                                5);
                if (b >= m.length - c.depthOfField - 1) {
                    clearInterval(E);
                    r("You did it!", {
                        x: 100,
                        y: 20
                    });
                }
                var f = (b - 2) % q.length,
                        j = (b - 2) * 5 - e.position,
                        g = q[f],
                        k = Number.POSITIVE_INFINITY,
                        n = 0,
                        o = b % 8,
                        h = q[b % q.length].height,
                        l = e.position % 5 / 5;
                h = c.camera_height + h + (q[(b + 1) % q.length].height - h) * l;
                l = g.curve + (q[(f + 1) % q.length].curve - g.curve) * l;
                x = e.posx - l;
                for (var U = c.depthOfField; U--;) {
                    var G = (f + 1) % q.length,
                            A = q[G];
                    n = Math.floor((h - g.height) * c.camera_distance / (c.camera_distance + j));
                    var t = 30 / (c.camera_distance + j),
                            H = Math.floor((h - A.height) * c.camera_distance / (c.camera_distance + j + 5)),
                            I = 30 / (c.camera_distance + j + 5),
                            B = Math.min(k, n);
                    t = t;
                    if (B > H) V(c.height / 2 + B, t, g.curve - l - x * t, c.height / 2 + H, I, A.curve - l - x * I, o < 4, f == 2 || f == m.length - c.depthOfField);
                    g.sprite && d.push({
                        y: c.height / 2 + n,
                        x: c.width / 2 - g.sprite.pos * c.width * t + g.curve - l - (e.posx - l) * t,
                        ymax: c.height / 2 + k,
                        s: 2.5 *
                                t,
                        i: g.sprite.type
                    });
                    k = B;
                    n = j;
                    f = G;
                    g = A;
                    j += 5;
                    o = (o + 1) % 8
                }
                for (; sprite = d.pop();) W(sprite);
                y(a.a, a.x, a.y, 1);
                r("" + Math.round(b / (m.length - c.depthOfField) * 100) + "%", {
                    x: 287,
                    y: 1
                });
                b = (new Date).getTime() - C.getTime();
                a = Math.floor(b / 6E4);
                d = Math.floor((b - a * 6E4) / 1E3);
                if (d < 10) d = "0" + d;
                b = Math.floor(b - a * 6E4 - d * 1E3);
                if (b < 100) b = "0" + b;
                if (b < 10) b = "0" + b;
                z = "" + a + ":" + d + ":" + b;
                r(z, {
                    x: 1,
                    y: 1
                });
                r("" + Math.round(e.speed / e.maxSpeed * 200) + "mph", {
                    x: 1,
                    y: 10
                })
            }, y = function (a, d, b, f) {
                i.drawImage(spritesheet, a.x, a.y, a.w, a.h, d, b, f * a.w, f * a.h)
            }, W = function (a) {
                var d =
                                a.y - a.i.h * a.s,
                        b = a.ymax < a.y ? Math.min(a.i.h * (a.ymax - d) / (a.i.h * a.s), a.i.h) : a.i.h;
                b > 0 && i.drawImage(spritesheet, a.i.x, a.i.y, a.i.w, b, a.x, d, a.s * a.i.w, a.s * b)
            }, V = function (a, d, b, f, j, g, k, n) {
                var o = k ? "#eda" : "#dc9",
                        h = k ? "#e00" : "#fff",
                        l = k ? "#999" : "#777";
                k = k ? "#fff" : "#777";
                if (n) h = k = l = "#fff";
                i.fillStyle = o;
                i.fillRect(0, f, c.width, a - f);
                v(a, d, b, f, j, g, -0.5, 0.5, l);
                v(a, d, b, f, j, g, -0.5, -0.47, h);
                v(a, d, b, f, j, g, 0.47, 0.5, h);
                v(a, d, b, f, j, g, -0.18, -0.15, k);
                v(a, d, b, f, j, g, 0.15, 0.18, k)
            }, v = function (a, d, b, f, j, g, k, n, o) {
                var h = c.width / 2;
                i.fillStyle =
                        o;
                i.beginPath();
                i.moveTo(h + k * c.width * d + b, a);
                i.lineTo(h + k * c.width * j + g, f);
                i.lineTo(h + n * c.width * j + g, f);
                i.lineTo(h + n * c.width * d + b, a);
                i.fill()
            }, S = function (a) {
                a = a / 2 % (u.w * 2);
                y(u, a - u.w * 2 + 1, 0, 2);
                y(u, a + u.w * 2 - 1, 0, 2);
                y(u, a, 0, 2)
            }, r = function (a, d) {
                a = a.toUpperCase();
                for (var b = d.x, f = 0; f < a.length; f++) {
                    i.drawImage(spritesheet, (a.charCodeAt(f) - 32) * 8, 60, 8, 8, b, d.y, 8, 8);
                    b += 8
                }
            }, F = function () {
                var a = $(window).width() / $(window).height() > c.width / c.height ? $(window).height() / c.height : $(window).width() / c.width,
                        d = "scale(" + a + ")";
                $("#c").css("MozTransform",
                                d).css("transform", d).css("WebkitTransform", d).css({
                            top: (a - 1) * c.height / 2,
                            left: (a - 1) * c.width / 2 + ($(window).width() - c.width * a) / 2
                        })
            }, O = function () {
                for (var a = 0, d = [
                    [0, 1, 2],
                    [0, 2, 2],
                    [0, 1, 1]
                ], b = 0, f = [
                    [0, 1, 2],
                    [0, 2, 2],
                    [0, 1, 1]
                ], j = 0, g = 0, k = m.length / m.zoneSize; k--;) {
                    var n;
                    switch (a) {
                        case 0:
                            n = 0;
                            break;
                        case 1:
                            n = m.maxHeight * p();
                            break;
                        case 2:
                            n = -m.maxHeight * p();
                            break
                    }
                    var o;
                    switch (b) {
                        case 0:
                            o = 0;
                            break;
                        case 1:
                            o = -m.maxCurve * p();
                            break;
                        case 2:
                            o = m.maxCurve * p();
                            break
                    }
                    for (var h = 0; h < m.zoneSize; h++) {
                        if (h % m.zoneSize / 4 == 0) var l = {
                            type: N,
                            pos: -0.55
                        };
                        else if (p() < 0.05) {
                            l = {
                                type: M,
                                pos: 0.6 + 4 * p()
                            };
                            if (p() < 0.5) l.pos = -l.pos
                        } else l = false;
                        q.push({
                            height: j + n / 2 * (1 + Math.sin(h / m.zoneSize * Math.PI - Math.PI / 2)),
                            curve: g + o / 2 * (1 + Math.sin(h / m.zoneSize * Math.PI - Math.PI / 2)),
                            sprite: l
                        })
                    }
                    j += n;
                    g += o;
                    a = p() < m.mountainy ? d[a][1 + Math.round(p())] : d[a][0];
                    b = p() < m.curvy ? f[b][1 + Math.round(p())] : f[b][0]
                }
            };
    return {
        start: function () {
            P();
            spritesheet = new Image;
            spritesheet.onload = function () {
                D = setInterval(R, 30)
            };
            spritesheet.src = "img/s.png"
        }
    }
}();
$(function () {
    game.start()
});
       