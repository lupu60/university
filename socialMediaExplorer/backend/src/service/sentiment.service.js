const request = require('request');
const syncRequest = require('sync-request');
const logger = require('winston-color');

const datumBox = {
    twitterSentimentAnalysisUrl: 'http://api.datumbox.com/1.0/TwitterSentimentAnalysis.json',
    api_key: '',
};

/**
 *
 *
 * @param {string} text
 */
exports.getSentiment = (text, callback) => {
    request.post(
        'http://loudelement.com/sent/',
        {
            formData: {
                text: text,
            },
        },
        (error, response, body) => {
            if (error) throw new Error(error);
            callback(null, body);
        },
    );
};
