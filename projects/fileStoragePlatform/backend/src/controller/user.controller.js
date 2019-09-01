var express = require('express');
var router = express.Router();
var passport = require('../config/passport');
var user = require('../service/user.service');


router.post('/', user.create);
router.get('/:id', passport.authenticate('jwt', { session: false }), user.findById);
router.get('/', passport.authenticate('jwt', { session: false }), user.findAll);
// router.put('/', passport.authenticate('jwt', { session: false }), user.update);
// router.delete('/:id', passport.authenticate('jwt', { session: false }), user.delete);

module.exports = router;