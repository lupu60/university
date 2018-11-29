var express = require('express');
var router = express.Router();
var passport = require('../config/passport');
var document = require('../service/document.service');

router.post('/', document.add);
router.get('/', passport.authenticate('jwt', { session: false }), document.findAll);
router.get('/user/:id', passport.authenticate('jwt', { session: false }), document.getUserFiles);
router.get('/:id', document.downloadFile);
router.delete('/:id', passport.authenticate('jwt', { session: false }), document.delete);

module.exports = router;
