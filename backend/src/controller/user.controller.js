const express = require('express');
const router = express.Router();
const passport = require('../config/passport');
const user = require('../service/user.service');


router.post('/', user.create);
router.get('/:id', passport.authenticate('jwt', { session: false }), user.findById);
router.get('/', passport.authenticate('jwt', { session: false }), user.retrieveAll);
router.put('/', passport.authenticate('jwt', { session: false }), user.update);
router.delete('/:id', passport.authenticate('jwt', { session: false }), user.delete);

module.exports = router;