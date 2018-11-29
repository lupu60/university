const express = require('express');
const router = express.Router();
const twitter = require('../service/twitter.client');

router.get('/', (req, res) => {
    res.status(200).jsonp({
        info: 'Welcome to the API!',
    });
});

router.post('/twitter', (req, res) => {
    const query = req.body.hashtag;
    twitter.get('search/tweets', { q: query }, function (error, tweets, response) {
        res.status(200).jsonp({ data: JSON.parse(response.body).statuses });
    });
});


module.exports = router;
