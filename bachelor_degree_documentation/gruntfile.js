module.exports = function(grunt) {
    grunt.initConfig({
        latex: {
            options: {
                haltOnError: 'true'
            },
            pdf_target: {
                options: {
                    outputDirectory: 'pdf'
                },
                src: ['bachelor.tex']
            }
        },
    });
    grunt.loadNpmTasks('grunt-latex');
    grunt.registerTask('default', ['latex']);
};