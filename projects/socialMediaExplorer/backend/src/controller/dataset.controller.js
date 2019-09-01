const express = require('express');
const router = express.Router();
const passport = require('../config/passport');
const logger = require("winston-color");
const datasetservice = require('../service/dataset.service');

router.get('/', passport.authenticate('jwt', { session: false }), datasetservice.retrieveAll);
router.get('/:id', passport.authenticate('jwt', { session: false }), datasetservice.findById);
router.delete('/:id', passport.authenticate('jwt', { session: false }), datasetservice.deleteById);

module.exports = router;
