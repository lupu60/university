const bcrypt = require('bcrypt-nodejs');
const config = require('../config/config');
const express = require('express');
const jwt = require('jsonwebtoken');
const passport = require('../config/passport');
const router = express.Router();
const userRepo = require('../db/sequelize/models/').user;

router.post('/', (req, res) => {
    if (req.body.username && req.body.password) {
        const username = req.body.username;
        const password = req.body.password;
        userRepo.findOne({ where: { username: username } }).then(dbuser => {
            if (!dbuser) {
                return res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
            }
            if (!bcrypt.compareSync(password, dbuser.dataValues.password)) {
                return res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
            } else {
                const payload = { id: dbuser.dataValues.id };
                const token = jwt.sign(payload, config.jwtSecret);
                res.json({ token: 'Bearer ' + token, userId: dbuser.dataValues.id, username: dbuser.dataValues.username });
            }
        }).catch((error) => {
            res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
        });
    }
});

router.get('/checkauth', passport.authenticate('jwt', { session: false }), (req, res) => {
    res.status(200).jsonp({
        info: 'true',
    });
});

module.exports = router;
