module.exports = function(grunt) {


    // Load required modules
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-watch-change');
    grunt.loadNpmTasks('grunt-contrib-copy');

    // Project configuration.
    var taskConfig = {

        // Metadata.
        pkg: grunt.file.readJSON('package.json'),

        watch : {
            scripts : {
                files: ['src/**/resources/**/js/**/*.js', 'src/**/resources/**/html/**/*.html'],
                tasks: ['copy'],
                options : {
                    spawn : false
                }
            }
        },

        copy: {
            main: {
                expand: true,
                cwd: 'src/main/resources/public/',
                src: ['**/*.js', '**/*.html'],
                dest: 'target/classes/public/'
            }
        }


    };

    // grunt.event.on('watch', function(action, filepath, target) {
    //     grunt.config(['jshint', 'all'], filepath);
    // });



    grunt.initConfig(taskConfig);


    // Task definitions
    grunt.registerTask('default', ['watch', 'copy']);
};