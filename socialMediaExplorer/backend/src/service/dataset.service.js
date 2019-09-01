const logger = require("winston-color");
const datasetRepo = require('../db/sequelize/models/').dataset;

let tempDataset = {
    name: '',
    raw_data: []
};

exports.saveTempDataset = (name, element) => {
    tempDataset.name = name;
    tempDataset.raw_data.push(element);
};

exports.clearTempDataset = () => {
    tempDataset = {
        name: '',
        raw_data: []
    };
    logger.info('temp dataset clean');
};

exports.saveDataset = () => {
    datasetRepo.create(tempDataset).then(dataset => {
        logger.info('data set ' + dataset.name + ' is in the db');
        tempDataset = {
            name: '',
            raw_data: []
        };
    }).catch((error) => res.status(400).jsonp(error));
};

exports.findById = (req, res) => {
    let id = req.params.id;
    datasetRepo.findById(id, {
        attributes: {
            exclude: ['updatedAt', 'raw_data']
        }
    }).then(dataset => {
        if (!dataset) {
            return res.status(400).jsonp({
                message: 'Dataset Not Found',
            });
        }
        res.jsonp(dataset);
    }).catch((error) => res.status(400).jsonp(error));
};

exports.retrieveAll = (req, res) => {
    datasetRepo.findAll({
        attributes: {
            exclude: ['updatedAt', 'raw_data']
        }
    }).then(dbresponse => {
        res.status(200).jsonp(dbresponse);
    }).catch((error) => res.status(400).jsonp(error));
};

exports.deleteById = (req, res) => {
    datasetRepo.findById(req.params.id)
        .then(dataset => {
            if (!dataset) {
                return res.status(400).send({
                    message: 'Dataset Not Found',
                });
            }
            return dataset
                .destroy()
                .then(() => res.status(204).jsonp())
                .catch(error => res.status(400).jsonp(error));
        })
        .catch(error => res.status(400).jsonp(error));
};