const express = require('express');
const router = express.Router();
const passport = require('../config/passport');
const bcrypt = require('bcrypt-nodejs');
const userRepo = require('../db/user');
const UserDto = require('../model/user.dto');
const config = require('../config/config');
const jwt = require('jsonwebtoken');

router.post('/', (req, res) => {
    if (req.body.username && req.body.password) {
        const username = req.body.username;
        const password = req.body.password;
        userRepo.findOne({
            username: username
        }, (err, user) => {
            if (err || !user || !bcrypt.compareSync(password, user.password)) {
                return res.status(401).json({
                    error: 'Your login details could not be verified. Please try again.'
                });
            } else {
                const token = jwt.sign({
                    id: user._id
                }, config.jwtSecret);
                return res.json({
                    token: 'Bearer ' + token,
                    user: {
                        username: user.username,
                        id: user._id
                    }
                });
            }
        });
    }
});

router.post('/user', (req, res) => {
    if (req.body.username && req.body.password) {
        userRepo.findOne({
            username: req.body.username
        }, {
            __v: 0
        }, (err, dbuser) => {
            if (dbuser) {
                return res.status(400).jsonp({
                    info: "User already exists"
                });
            }
            if (err) {
                return res.status(401).json({
                    error: 'Your login details could not be verified. Please try again.'
                });
            }
            const user = new userRepo({
                username: req.body.username,
                password: bcrypt.hashSync(req.body.password)
            });
            user.save((err, user) => {
                if (err) {
                    return res.status(401).json({
                        error: err
                    });
                }
                const userDto = new UserDto(user._id, user.username);
                return res.status(200).jsonp(userDto);
            });
        });
    }
});

router.get('/checkauth', passport.authenticate('jwt', {
    session: false
}), (req, res) => {
    res.status(200).jsonp({
        info: 'true',
    });
});

module.exports = router;