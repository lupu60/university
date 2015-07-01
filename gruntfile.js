module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    var BUILD_DIR = './public/';
    var BUILD_DIR_JS = BUILD_DIR + 'javascripts/';
    var BUILD_DIR_CSS = BUILD_DIR + 'stylesheets/';
    var BUILD_DIR_IMAGES = BUILD_DIR + 'images/';
    var BUILD_DIR_LESS = BUILD_DIR + 'less/';
    // =========================================================
    var BUILD_FILE_JS = BUILD_DIR_JS + 'libs.js';
    // =========================================================
    var BUILD_FILES_LESS = BUILD_DIR_LESS + '*.less';
    // =========================================================
    // =========================================================
    var JQUERY = './node_modules/jquery/dist/jquery.js';
    var BOOTSTRAP_JS = './node_modules/bootstrap/dist/js/bootstrap.js';
    var general = BUILD_DIR_JS + 'general.js';
    var graphs = BUILD_DIR_JS + 'graphs.js';
    var gyroscope_controller = BUILD_DIR_JS + 'gyroscope_controller.js';
    var index = BUILD_DIR_JS + 'index.js';
    var keyboard_controller = BUILD_DIR_JS + 'keyboard_controller.js';
    var speech_controller = BUILD_DIR_JS + 'speech_controller.js';
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
                sourceMap: false,
            },
            libs: {
                src: [JQUERY, BOOTSTRAP_JS],
                dest: BUILD_FILE_JS,
            },
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' + '<%= grunt.template.today("yyyy-mm-dd") %> */',
                sourceMap:true
            },
            my_code: {
                files: [{
                    expand: true,
                    cwd: './public/javascripts/',
                    src: ['**/*.js', '!libs/*.js'],
                    dest: './public/min_javascripts/',
                }],
            },
            libs: {
                files: [{
                    expand: true,
                    cwd: './public/javascripts/libs',
                    src: ['**/*.js'],
                    dest: './public/min_javascripts/libs',
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
                    cwd: './public/less/',
                    src: ['*.less', '!_imports.less'],
                    dest: './public/stylesheets/',
                    ext: '.css'
                }],
            },
        },
        watch: {
            stylesless: {
                options: {
                    livereload: true
                },
                files: [BUILD_FILES_LESS],
                tasks: ['less:development']
            },
            javascripts: {
                options: {
                    livereload: true
                },
                files: [BUILD_DIR_JS],
                tasks: ['uglify']
            },
        },
        clean: {
            production: {
                src: ['./public/min_javascripts/*.map', './public/min_javascripts/libs/*.map','./public/stylesheets/*.map'],
            },
        },
    });
    grunt.registerTask('javascripts', ['concat', 'uglify']);
    grunt.registerTask('css', ['less']);
    grunt.registerTask('production', ['asciify','css', 'javascripts','clean']);
    grunt.registerTask('development', ['asciify', 'css', 'javascripts','watch']);
};