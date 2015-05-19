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
        copy: {
            bootstrap_fonts: {
                files: [{
                    expand: true,
                    cwd: './node_modules/bootstrap/fonts/',
                    src: ['**'],
                    dest: BUILD_DIR + 'fonts'
                }, ],
            },
        },
        concat: {
            options: {
                sourceMap: true,
            },
            libs: {
                src: [JQUERY, BOOTSTRAP_JS],
                dest: BUILD_FILE_JS,
            },
        },
        less: {
            development: {
                options: {
                    compress: false,
                    cleancss: false,
                    sourceMap: true,
                    sourceMapURL: './style.css.map',
                    sourceMapRootpath: '../../',
                },
                files: {
                    "./public/stylesheets/style.css": "./public/less/style.less",
                    "./public/stylesheets/controller.css": "./public/less/controller.less",
                    "./public/stylesheets/gyro_controller.css": "./public/less/gyro_controller.less",
                },
            },
        },
        watch: {
            stylesless: {
                options: {
                    livereload: false
                },
                files: [BUILD_FILES_LESS],
                tasks: ['less:development']
            },
        },
    });
    grunt.registerTask('default', ['asciify','watch']);
};