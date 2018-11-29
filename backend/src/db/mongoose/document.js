var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var documentSchema = new Schema({
  name: { type: String, required: true, unique: false },
  userid: { type: String, required: true, unique: false },
  docData: { type: Buffer, required: true },
  type: { type: String, required: true, unique: false },
  createdAt: { type: Date, default: Date.now }
});

documentSchema.pre('save', next => {
  now = new Date();
  if (!this.createdAt) {
    this.createdAt = now.toLocaleDateString();
  }
  next();
});

module.exports = mongoose.model('Document', documentSchema);
