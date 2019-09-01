const express = require('express');
const router = express.Router();
const logger = require("winston-color");
const datasetRepo = require('../db/sequelize/models').dataset;
const sentimentservice = require('../service/sentiment.service');
const cheerio = require('cheerio');

const twitterSentimentChart = {
    labels: ['Negative', 'Neutral', 'Positive'],
    datasets: [
        {
            data: [0, 0, 0],
            backgroundColor: [
                '#FF6384',
                '#36A2EB',
                '#FFCE56'
            ],
            hoverBackgroundColor: [
                '#FF6384',
                '#36A2EB',
                '#FFCE56'
            ]
        }]
};

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

router.get('/:id', (req, res) => {
    const datasetid = req.params.id;
    datasetRepo.findById(datasetid, {
        attributes: {
            exclude: ['updatedAt']
        }
    }).then(dataset => {
        if (!dataset) {
            return res.status(400).jsonp({
                message: 'Dataset Not Found',
            });
        }
        var ctr = 0;
        dataset.dataValues.raw_data.forEach(element => {
            try {
                sentimentservice.getSentiment(element.text, (err, body) => {
                    try {
                        const $ = cheerio.load(body);
                        const btag = $('.result').html();
                        if (btag !== null) {
                            const sentiment = btag.slice(15, 22);
                            if (sentiment !== null) {
                                populateTwitterSentimentChart(sentiment);
                            }
                        }
                        ctr++;
                        if (ctr === dataset.dataValues.raw_data.length) {
                            return res.status(200).jsonp(twitterSentimentChart);
                        }
                    } catch (error) {
                        throw new Error(error);
                    }
                });
            } catch (error) {
                throw new Error(error);
            }
        });
    }).catch((error) => res.status(400).jsonp(error));
});

function populateTwitterSentimentChart(sentiment) {
    switch (sentiment) {
        case 'Negativ':
            twitterSentimentChart.datasets[0].data[0] += 1;
            break;
        case 'Neutral':
            twitterSentimentChart.datasets[0].data[1] += 1;
            break;
        case 'Positiv':
            twitterSentimentChart.datasets[0].data[2] += 1;
            break;
        default:
            break;
    }
}

module.exports = router;
