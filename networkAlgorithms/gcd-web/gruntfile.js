module.exports = function(grunt) {
    require('load-grunt-tasks')(grunt);
    var build_dir = './public/';
    var build_dir_js = build_dir + 'javascripts/';
    var build_dir_js_min = build_dir + 'javascripts.min/';
    var build_dir_css = build_dir + 'stylesheets/';
    var build_dir_less = build_dir + 'less/';
    var build_dir_images = build_dir + 'images/';
    // =========================================================
    var build_files_less = build_dir_less + '*.less';
    var build_files_js = build_dir_js + '*.js';
    // =========================================================
    // =========================================================
    var js_libs = ['./node_modules/jquery/dist/jquery.js', './node_modules/bootstrap/dist/js/bootstrap.js'];
    var build_file_js = build_dir_js + 'libs.js';
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
                src: [js_libs],
                dest: build_file_js,
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
                    cwd: './public/javascripts/',
                    src: ['**/*.js', '!libs/*.js'],
                    dest: build_dir_js_min,
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
            stylesheets: {
                options: {
                    livereload: true
                },
                files: [build_files_less],
                tasks: ['less:development']
            },
            javascripts: {
                options: {
                    livereload: true
                },
                files: [build_files_js],
                tasks: ['uglify']
            },
        },
        clean: {
            production: {
                src: ['./public/javascripts.min/*.map', './public/stylesheets/*.map'],
            },
            commit: {
                src: ['./public/javascripts.min/*.map', './public/stylesheets/*.map', './public/javascripts.min/*.js', './public/stylesheets/*.css'],
            },
        },
    });
    grunt.registerTask('javascripts', ['concat', 'uglify']);
    grunt.registerTask('css', ['less']);
    grunt.registerTask('production', ['asciify', 'css', 'javascripts', 'clean:production']);
    grunt.registerTask('development', ['asciify', 'css', 'javascripts', 'watch']);
    grunt.registerTask('dev', ['asciify', 'css', 'javascripts', 'watch']);
};