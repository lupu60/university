const express = require('express');
const router = express.Router();
const authService = require('../service/auth.service');
const passport = require('../config/passport');

router.post('/', authService.login);
router.get('/secret', passport.authenticate('jwt', { session: false }), (req, res) => {
    res.status(200).jsonp({
        info: 'secret api!',
    });
});

module.exports = router;
