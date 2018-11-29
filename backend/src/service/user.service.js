const userRepo = require('../db/sequelize/models/').user;
const bcrypt = require('bcrypt-nodejs');

exports.retrieveAll = (req, res) => {
  userRepo.findAll({
    attributes: {
      exclude: ['password']
    }
  }).then(dbresponse => {
    res.status(200).jsonp(dbresponse);
  }).catch((error) => res.status(400).jsonp(error));
};

exports.create = (req, res) => {
  if (req.body.username && req.body.password) {
    userRepo.findOne({ where: { username: req.body.username } }).then(dbuser => {
      if (dbuser) {
        return res.status(400).jsonp({ info: "user already exists" });
      }
      let newUser = {
        username: req.body.username,
        password: bcrypt.hashSync(req.body.password)
      };
      userRepo.create(newUser).then(user => {
        return res.jsonp(user);
      }).catch((error) => res.status(400).jsonp(error));
    }).catch((error) => res.status(400).jsonp(error));
  }
};

exports.update = (req, res) => {
  let newUser = {
    username: req.body.username,
    password: bcrypt.hashSync(req.body.password)
  };
  userRepo.update(newUser, { where: { id: req.body.id }, returning: true })
    .catch((error) => res.status(400).jsonp(error));
  res.status(200).jsonp({ info: "user updated" });
};

exports.findById = (req, res) => {
  let id = req.params.id;
  userRepo.findById(id, {
    attributes: {
      exclude: ['password']
    }
  }).then(user => {
    if (!user) {
      return res.status(400).jsonp({
        message: 'User Not Found',
      });
    }
    res.jsonp(user);
  }).catch((error) => res.status(400).jsonp(error));
};

exports.delete = (req, res) => {
  let id = req.params.id;
  userRepo.findById(req.params.id)
    .then(user => {
      if (!user) {
        return res.status(400).send({
          message: 'User Not Found',
        });
      }
      return user
        .destroy()
        .then(() => res.status(204).jsonp())
        .catch(error => res.status(400).jsonp(error));
    })
    .catch(error => res.status(400).jsonp(error));
};