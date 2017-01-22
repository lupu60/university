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
        $http({
            method: "GET",
            url: "/webapi/patient/"
        }).then(function mySucces(response) {
            $scope.rowCollection = response.data;
        }, function myError(response) {
            console.log(response.statusText);
        });
    });
