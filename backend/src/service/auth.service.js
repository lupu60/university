const jwt = require('jsonwebtoken');
const userRepo = require('../db/sequelize/models/').user;
const config = require('../config/config');

exports.login = (req, res) => {
    if (req.body.username && req.body.password) {
        const username = req.body.username;
        const password = req.body.password;
        userRepo.findOne({ where: { username: username } }).then(dbuser => {
            if (!dbuser) {
                res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
            }
            if (dbuser.dataValues.password !== password) {
                res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
            } else {
                const payload = { id: dbuser.dataValues.id };
                const token = jwt.sign(payload, config.jwtSecret);
                res.json({token: 'Bearer ' + token, userId: dbuser.dataValues.id, username:dbuser.dataValues.username });
            }
        }).catch((error) => {
            res.status(401).json({ error: 'Your login details could not be verified. Please try again.' });
        });
    }
};

