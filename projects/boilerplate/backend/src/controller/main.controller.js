const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.status(200).jsonp({
        info: 'Welcome to the API!',
    });
});

module.exports = router;