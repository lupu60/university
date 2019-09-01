var expect = require('chai').expect;
var assert = require('chai').assert;
var request = require('request');

describe('Server is running: Status and content', function () {
    it('Main page content', (done) => {
        request('http://localhost:3000/api/', (error, response, body) => {
            expect(body).to.equal('{"info":"Welcome to the API!"}');
            done();
        });
    });

    it('Main page status', (done) => {
        request('http://localhost:3000/api/', (error, response, body) => {
            expect(response.statusCode).to.equal(200);
            done();
        });
    });
});