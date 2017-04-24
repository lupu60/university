'use strict';
/**
 * @ngdoc overview
 * @name sbAdminApp
 * @description
 * # sbAdminApp
 *
 * Main module of the application.
 */
angular.module('sbAdminApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'smart-table',
]).config(['$stateProvider', '$locationProvider', '$urlRouterProvider', '$ocLazyLoadProvider', function($stateProvider, $locationProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    // $locationProvider.html5Mode(true);
    $ocLazyLoadProvider.config({
        debug: false,
        events: true,
    });
    $urlRouterProvider.otherwise('/dashboard/home');
    $stateProvider.state('dashboard', {
            url: '/dashboard',
            templateUrl: 'views/dashboard/main.html',
            resolve: {
                loadMyDirectives: function($ocLazyLoad) {
                    return $ocLazyLoad.load({
                            name: 'sbAdminApp',
                            files: [
                                'scripts/directives/header/header.js',
                                'scripts/directives/sidebar/sidebar.js'
                            ]
                        }),
                        $ocLazyLoad.load({
                            name: 'toggle-switch',
                            files: ["bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                                "bower_components/angular-toggle-switch/angular-toggle-switch.css"
                            ]
                        }),
                        $ocLazyLoad.load({
                            name: 'ngAnimate',
                            files: ['bower_components/angular-animate/angular-animate.js']
                        })
                    $ocLazyLoad.load({
                        name: 'ngCookies',
                        files: ['bower_components/angular-cookies/angular-cookies.js']
                    })
                    $ocLazyLoad.load({
                        name: 'ngResource',
                        files: ['bower_components/angular-resource/angular-resource.js']
                    })
                    $ocLazyLoad.load({
                        name: 'ngSanitize',
                        files: ['bower_components/angular-sanitize/angular-sanitize.js']
                    })
                    $ocLazyLoad.load({
                        name: 'ngTouch',
                        files: ['bower_components/angular-touch/angular-touch.js']
                    })
                }
            }
        }).state('dashboard.home', {
            url: '/home',
            controller: 'MainCtrl',
            templateUrl: 'views/dashboard/home.html',
            resolve: {
                loadMyFiles: function($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: 'sbAdminApp',
                        files: [
                            'bower_components/parallax/deploy/jquery.parallax.min.js',
                            'bower_components/parallax/deploy/parallax.min.js',
                            'scripts/controllers/main.js',
                        ]
                    })
                }
            }
        }).state('dashboard.patients', {
            templateUrl: 'scripts/directives/patient/patients.html',
            url: '/patients',
            controller: 'PatientCtrl',
            resolve: {
                loadMyFiles: function($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: 'sbAdminApp',
                        files: [
                            'scripts/directives/patient/patients.js'
                        ]
                    })
                }
            }
        }).state('dashboard.activity', {
            templateUrl: 'scripts/directives/activity/activity.html',
            url: '/activity',
            controller: 'ActivityCtrl',
            resolve: {
                loadMyFiles: function($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: 'sbAdminApp',
                        files: [
                            'bower_components/chart.js/dist/Chart.min.js',
                            'bower_components/chart.js/dist/Chart.bundle.js',
                            'scripts/directives/activity/activity.js'
                        ]
                    })
                }
            }
        }).state('dashboard.smart-band', {
            templateUrl: 'scripts/directives/smart-band/smart-band.html',
            url: '/smart-band',
            controller: 'SmartBandCtrl',
            resolve: {
                loadMyFiles: function($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: 'sbAdminApp',
                        files: [
                            'scripts/directives/smart-band/smart-band.js'
                        ]
                    })
                }
            }
        })
}]);
