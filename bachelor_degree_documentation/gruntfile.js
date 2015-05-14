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
          watch: {
    tex: {
      files: ['*.tex'],
      tasks: ['latex'],
      options: {
        spawn: false,
      },
    },
  },
    });
    grunt.loadNpmTasks('grunt-latex');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.registerTask('default', ['watch']);
};