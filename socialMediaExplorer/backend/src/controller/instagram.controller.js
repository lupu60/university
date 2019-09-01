const express = require('express');
const router = express.Router();
const passport = require('../config/passport');
const logger = require('winston-color');
const Instagram = require('node-instagram').default;

const instagram = new Instagram({
    clientId: '',
    clientSecret: '',
    accessToken: '',
});

router.post('/', passport.authenticate('jwt', { session: false }), (req, res) => {
    hastag = req.body.text;
    logger.info('user searching ' + hastag);
    instagram.get('tags/search', { q: hastag }).then((data) => {
        res.status(200).jsonp({
            data: data,
        });
    });
});

module.exports = router;
