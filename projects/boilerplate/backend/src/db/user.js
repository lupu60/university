var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var userSchema = new Schema({
  username: {
    type: String,
    required: true,
    unique: true
  },
  password: {
    type: String,
    required: true,
    unique: false
  },
  createdAt: {
    type: Date,
    default: Date.now
  }
});

userSchema.pre('save', next => {
  now = new Date();
  if (!this.createdAt) {
    this.createdAt = now.toLocaleDateString();
  }
  next();
});

module.exports = mongoose.model('User', userSchema);