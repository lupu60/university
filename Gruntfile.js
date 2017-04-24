'use strict';
// wrapper function that exposes the grunt instance
module.exports = function(grunt) {
    // load all grunt tasks
    require('load-grunt-tasks')(grunt);
    // show elapsed time at the end
    require('time-grunt')(grunt);
    // =========================================================
    const WORKINGDIR = 'src/main/resources/static/';
    // configure the tasks
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        asciify: {
            banner: {
                text: '<%= pkg.name %> ',
                options: {
                    font: 'doom',
                    log: true
                },
            },
        },
        jshint: {
            options: {
                curly: true,
                eqeqeq: true,
                eqnull: true,
                browser: true,
                globals: {
                    jQuery: true
                },
            },
            all: [WORKINGDIR + '/scripts/**/*.js']
        },
        htmlmin: {
            dist: {
                options: {
                    collapseWhitespace: true,
                    conservativeCollapse: true,
                    collapseBooleanAttributes: true,
                    removeCommentsFromCDATA: true,
                    removeOptionalTags: true
                },
                files: [{
                    expand: true,
                    cwd: WORKINGDIR,
                    src: '**/*.html',
                    dest: WORKINGDIR
                }]
            }
        },
    });
    grunt.registerTask('default', ['asciify']);
};
