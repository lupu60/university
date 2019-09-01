const express = require('express');
const router = express.Router();
const main = require('../service/main.service');

router.get('/', main.hello);

module.exports = router;
