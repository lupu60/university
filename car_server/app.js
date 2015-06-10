var express = require('express');
/*===================================
=            new require            =
===================================*/
var socket_io    = require('socket.io' );

var passport = require('passport')
var flash = require('connect-flash')
var LocalStrategy = require('passport-local').Strategy;
/*-----  End of new require  ------*/
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var routes = require('./routes/index');
var users = require('./routes/users');
/*================================
=            Passport            =
================================*/

/*-----  End of Passport  ------*/


/*==================================
=            New Routes            =
==================================*/
var keyboard_controller = require('./routes/keyboard_controller');
var gyroscope_controller = require('./routes/gyroscope_controller');
var speech_controller = require('./routes/speech_controller');
/*-----  End of New Routes  ------*/
var app = express();
/*================================== 
=            Socket io             =
==================================*/
var io           = socket_io();
app.io           = io;
/*-----  End of Socket io   ------*/
/*===============================
=            new var            =
===============================*/

/*-----  End of new var  ------*/


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

// uncomment after placing your favicon in /public
app.use(favicon(__dirname + '/public/images/favicon.ico'));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser()); 
app.use(require('less-middleware')(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, 'public')));
 
app.use('/', routes);
app.use('/users', users);
/*==================================  
=            New Routes            =
==================================*/
app.use('/keyboard_controller', keyboard_controller);
app.use('/gyroscope_controller', gyroscope_controller);
app.use('/speech_controller',speech_controller);
/*-----  End of New Routes  ------*/

 
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});
/*================================
=            passport            =
================================*/


/*-----  End of passport  ------*/


/*========================
=                        =
========================*/


/*-----  End of   ------*/


// module.exports = io;
module.exports = app;

