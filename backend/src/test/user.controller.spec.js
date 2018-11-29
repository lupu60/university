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

describe('user api', () => {
    beforeEach(function (done) {
        setTimeout(done, 500);
    });

    before((done) => {
        const testUser = { username: randomstring.generate(), password: randomstring.generate() };
        request({
            uri: 'http://localhost:3000/api/user/',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            json: testUser
        }, (error, response, body) => {
            request({
                uri: 'http://localhost:3000/api/auth/',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                json: testUser
            }, (error, response, body) => {
                credentials = body;
                done();
            });
        });
    });

    it('createUser', (done) => {
        request({
            uri: 'http://localhost:3000/api/user/',
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

    it('get user', (done) => {
        request({
            uri: 'http://localhost:3000/api/user/' + createdUser.id,
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': credentials.token
            }
        }, (error, response, body) => {
            expect(newUser.id).to.equal(body.id);
            done();
        });
    });

    it('get all', (done) => {
        request({
            uri: 'http://localhost:3000/api/user/',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': credentials.token
            }
        }, (error, response, body) => {
            const users = JSON.parse(body);
            assert.isArray(users);
            assert.isNotEmpty(users);
            done();
        });
    });
});

