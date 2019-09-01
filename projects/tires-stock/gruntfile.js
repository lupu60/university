module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    var PUBLIC_DIR = './public/';
    var PUBLIC_DIR_JS = PUBLIC_DIR + 'javascripts/';
    var PUBLIC_DIR_MIN_JS = PUBLIC_DIR + 'min_javascripts/';
    var PUBLIC_DIR_CSS = PUBLIC_DIR + 'stylesheets/';
    var PUBLIC_DIR_IMAGES = PUBLIC_DIR + 'images/';
    var PUBLIC_DIR_LESS = PUBLIC_DIR + 'less/';
    // =========================================================
    var JQUERY_BOOTSTRAP_JS = PUBLIC_DIR_JS + 'jquery_bootstrap.js';
    // =========================================================
    var PUBLIC_FILES_JS = PUBLIC_DIR_JS + '*.js';
    var PUBLIC_FILES_LESS = PUBLIC_DIR_LESS + '*.less';
    // =========================================================
    // =========================================================
    var JQUERY = './node_modules/jquery/dist/jquery.js';
    var BOOTSTRAP_JS = './node_modules/bootstrap/dist/js/bootstrap.js';
    // =========================================================
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
        // =============================================
        // =            Core Tasks                     =
        // =============================================
        concat: {
            options: {
                banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' + '<%= grunt.template.today("yyyy-mm-dd") %> */',
                  sourceMap: true
            },
            jq_bootrap: {
                src: [JQUERY, BOOTSTRAP_JS],
                dest: JQUERY_BOOTSTRAP_JS,
            },
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' + '<%= grunt.template.today("yyyy-mm-dd") %> */',
                sourceMap: true
            },
            my_code: {
                files: [{
                    expand: true,
                    cwd: PUBLIC_DIR_JS,
                    src: ['**/*.js'],
                    dest: PUBLIC_DIR_MIN_JS,
                }],
            },
        },
        less: {
            development: {
                options: {
                    banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' + '<%= grunt.template.today("yyyy-mm-dd") %> */',
                    compress: true,
                    cleancss: false,
                    sourceMap: true,
                    sourceMapURL: './style.css.map',
                    sourceMapRootpath: '../../',
                },
                files: [{
                    expand: true,
                    cwd: PUBLIC_DIR_LESS,
                    src: ['*.less', '!_imports.less'],
                    dest: PUBLIC_DIR_CSS,
                    ext: '.css'
                }],
            },
        },
        watch: {
            stylesless: {
                options: {
                    livereload: true
                },
                files: [PUBLIC_FILES_LESS],
                tasks: ['css']
            },
            javascripts: {
                options: {
                    livereload: true
                },
                files: [PUBLIC_FILES_JS],
                tasks: ['uglify']
            },
        },
        clean: {
            production: {
                src: ['./public/min_javascripts/*.map', './public/stylesheets/*.map','./public/javascripts/*.map'],
            },
        },
        open: {
            dev: {
                // Gets the port from the connect configuration
                path: 'http://localhost:3000'
            },
        },
    });
    grunt.registerTask('javascripts', ['clean', 'concat', 'uglify']);
    grunt.registerTask('css', ['less']);
    grunt.registerTask('production', ['asciify', 'css', 'javascripts', 'clean:production']);
    grunt.registerTask('development', ['asciify', 'css', 'javascripts', 'open','watch']);
    grunt.registerTask('run', ['asciify', 'open']);
};