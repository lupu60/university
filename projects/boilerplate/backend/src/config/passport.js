const userRepo = require('../db/user');

// jwt
const jwt = require('jsonwebtoken');
const passport = require("passport");
const passportJWT = require("passport-jwt");
const ExtractJwt = passportJWT.ExtractJwt;
const JwtStrategy = passportJWT.Strategy;
const config = require('./config');

const jwtOptions = {
    jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
    secretOrKey: config.jwtSecret
};

var jwtLogin = new JwtStrategy(jwtOptions, (jwt_payload, done) => {
    userRepo.find({
        id: jwt_payload.id
    }, (err, user) => {
        if (!user) {
            return done(null, false, {
                error: 'Your login details could not be verified. Please try again.'
            });
        }
        if (err) {
            return done(err, false);
        }
        return done(null, user);
    });
});

passport.use(jwtLogin);
module.exports = jwtOptions;
module.exports = passport;