'use strict';

module.exports = class UserDto {
    /**
     * Creates an instance of UserDto.
     * @param {UUID} id
     * @param {string} username
     * @memberof UserDto
     */
    constructor(id, username) {
        this.id = id;
        this.username = username;
    }
}