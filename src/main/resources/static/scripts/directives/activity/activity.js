'use strict';
angular.module('sbAdminApp').controller('ActivityCtrl', ['$http', '$scope', '$filter', '$uibModal', function($http, $scope, $filter, $uibModal) {
    var patientrestURL = "/webapi/patient/";

    function draw() {
        $http({
            method: "GET",
            url: patientrestURL
        }).then(function mySucces(response) {
            $scope.patients = response.data;
            response.data.forEach(function(element, index) {
                $http({
                    method: "POST",
                    url: patientrestURL + "activity/",
                    data: element
                }).then(function mySucces(response) {
                    element.activity = response.data;
                }, function myError(response) {
                    console.log(response.statusText);
                });
            });
        }, function myError(response) {
            console.log(response.statusText);
        });
    }
    draw();
}]);
