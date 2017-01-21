'use strict';
angular.module('sbAdminApp')
    .directive('patients', function() {
        return {
            templateUrl: 'scripts/directives/patient/patients.html',
            restrict: 'E',
            replace: true,
        }
    })
    .controller('PatientCtrl', function($http, $scope, $position) {
        $(function() {
            $('#patients').DataTable({
                "ajax": {
                    "url": "/webapi/patient/",
                    "dataSrc": ""
                },
                "columns": [
                    { "data": "id" },
                    { "data": "name" },
                    { "data": "sex" },
                    { "data": "bandId" }
                ]
            });
        });
    });
