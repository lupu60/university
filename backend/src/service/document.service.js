const mongoose = require('mongoose');
const documentRepo = require('../db/mongoose/document');
const logRepo = require('../db/sequelize/models/').logs;
mongoose.connect('mongodb://127.0.0.1:27017/devdb');
mongoose.set('debug', true);


exports.add = (req, res) => {
    if (!req.files) {
        logRepo.create({
            type: 'upload',
            message: 'No files were uploaded'
        });
        return res.status(400).send('No files were uploaded.');
    }
    if (Array.isArray(req.files.uploadfiles)) {
        req.files.uploadfiles.forEach(file => {
            const newdoc = new documentRepo({
                name: file.name,
                userid: req.body.userid,
                docData: file.data,
                type: file.mimetype
            });
            newdoc.save((err) => {
                if (err) {
                    logRepo.create({
                        type: 'upload error',
                        message: err
                    });
                }
                logRepo.create({
                    type: 'upload succesfuly',
                    message: newdoc.name
                });
            });
        });
        return res.status(200).jsonp({ info: 'upload started' });
    } else {
        var newdoc = new documentRepo({
            name: req.files.uploadfiles.name,
            userid: req.body.userid,
            docData: req.files.uploadfiles.data,
            type: req.files.uploadfiles.mimetype
        });
        newdoc.save(function (err) {
            if (err) {
                logRepo.create({
                    type: 'upload error',
                    message: err
                });
            }
            return res.status(200).jsonp({ info: 'upload started' });
        });
    }
};

exports.getUserFiles = (req, res) => {
    let userid = req.params.id;
    documentRepo.find({ userid: userid }, { docData: 0, __v: 0 }, function (err, docs) {
        if (err) {
            return res.status(400).jsonp(err);
        }
        return res.status(200).jsonp(docs);
    });
};

exports.downloadFile = (req, res) => {
    let fileid = req.params.id;
    documentRepo.findById(fileid, function (err, doc) {
        if (err) {
            return res.status(400).jsonp(err);
        }
        res.setHeader('content-type', doc.type);
        res.setHeader('Content-Disposition', 'attachment; filename=' + doc.name);
        return res.send(doc.docData);
    });
};

exports.findAll = (req, res) => {
    documentRepo.find({}, { docData: 0 }, function (err, docs) {
        if (err) {
            return res.status(400).jsonp(err);
        }
        return res.status(200).jsonp(docs);
    });
};

exports.delete = (req, res) => {
    let fileid = req.params.id;
    documentRepo.findById(fileid, function (err, doc) {
        if (err) {
            return res.status(400).jsonp(err);
        }
        doc.remove((err) => {
            if (err) {
                return res.status(400).jsonp(err);
            }
            return res.status(200).jsonp({ info: 'file deleted' });
        });
    });
};