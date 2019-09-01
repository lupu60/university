const logger = require("winston-color");
const params = { screen_name: 'nodejs' };
const twitter = require('./twitter.client');
const io = require('socket.io').listen(4000);
const twee = io.of('tweet');
const datasetservice = require('./dataset.service');


let currentTwitterStream = null;

io.on('connect', function (socket) {
    logger.info('user connected');
    socket.on('search hastag', (hastag) => {
        destroyStream();
        datasetservice.clearTempDataset();
        if (hastag != null) {
            logger.info('user searching ' + hastag);
            twitter.stream('statuses/filter', { track: hastag }, function (stream) {
                currentTwitterStream = stream;
                stream.on('data', (tweet) => {
                    try {
                        datasetservice.saveTempDataset(hastag, tweet);
                        io.emit('tweets', tweet);
                    } catch (error) {
                        logger.error(error);
                    }
                });
            });
        }
    });

    socket.on('save dataset', () => {
        datasetservice.saveDataset();
    });

    socket.on('clear dataset', () => {
        datasetservice.clearTempDataset();
    });

    socket.on('stop search', () => {
        destroyStream();
        logger.info('user stop searching');
    });

    socket.on('disconnect', () => {
        destroyStream();
        datasetservice.clearTempDataset();
        logger.info('user disconnected');
    });
});

function destroyStream() {
    if (currentTwitterStream !== null && typeof currentTwitterStream !== 'undefined') {
        currentTwitterStream.destroy();
        logger.info('steam destroyed');
    }
}

module.exports = io;