exports.hello = (req, res) => {
    res.status(200).jsonp({
        info: 'Welcome to the API!',
    });
};
