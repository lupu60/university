'use strict';
// wrapper function that exposes the grunt instance
module.exports = function(grunt)
{
    // load all grunt tasks
    require('load-grunt-tasks')(grunt);
    // show elapsed time at the end
    require('time-grunt')(grunt);
    // =========================================================
    // configure the tasks
    grunt.initConfig(
    {
        pkg: grunt.file.readJSON('package.json'),
        asciify:
        {
            banner:
            {
                text: '<%= pkg.name %> ',
                options:
                {
                    font: 'doom',
                    log: true
                },
            },
        },
        // =============================================
        // =            Core Tasks                     =
        // =============================================
        // copy files into dist directory
    });
    grunt.registerTask('default', ['asciify']);
};