var expect = require('chai').expect;
var assert = require('chai').assert;
var request = require('request');
var randomstring = require('randomstring');

let newUser = {
    username: randomstring.generate(),
    password: randomstring.generate()
};

let credentials;
let createdUser;
describe('auth system', function () {
    beforeEach(function (done) {
        setTimeout(done, 500);
    });

    it('it should create a new user', (done) => {
        request({
            uri: 'http://localhost:3000/api/auth/user/',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            json: newUser
        }, (error, response, body) => {
            createdUser = body;
            assert.equal(response.statusCode, 200);
            assert.isNotEmpty(body);
            assert.equal(body.username, newUser.username);
            done();
        });
    });

    it('succesfuly login', (done) => {
        request({
            uri: 'http://localhost:3000/api/auth/',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            json: newUser
        }, (error, response, body) => {
            credentials = body;
            assert.equal(response.statusCode, 200);
            assert.equal(body.user.id, createdUser.id);
            done();
        });
    });

    it('unsuccesfuly login', (done) => {
        let wrongUser = {
            username: randomstring.generate(),
            password: randomstring.generate()
        };
        request({
            uri: 'http://localhost:3000/api/auth/',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            json: wrongUser
        }, (error, response, body) => {
            assert.equal(response.statusCode, 401);
            assert.equal(body.error, 'Your login details could not be verified. Please try again.');
            done();
        });
    });

    it('authorized request', (done) => {
        request({
            uri: 'http://localhost:3000/api/auth/checkauth/',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': credentials.token
            }
        }, (error, response, body) => {
            assert.equal(response.statusCode, 200);
            done();
        });
    });

    it('unauthorized request', (done) => {
        const optionsSuccesfulyLogin = {
            uri: 'http://localhost:3000/api/auth/checkauth/',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer test'
            }
        };
        request(optionsSuccesfulyLogin, (error, response, body) => {
            assert.equal(response.statusCode, 401);
            done();
        });
    });
});