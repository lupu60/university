const userRepo = require('../db/sequelize/models/').user;

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
    userRepo.findOne({ where: { id: jwt_payload.id } }).then(userdb => {
        const user = userdb.dataValues;
        if (!user) { return done(null, false, { error: 'Your login details could not be verified. Please try again.' }); }
        return done(null, user);
    }).catch((error) => {
        return done(error, false);
    });
});

passport.use(jwtLogin);
module.exports = jwtOptions;
module.exports = passport;