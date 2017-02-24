'use strict';
angular.module('sbAdminApp').controller('HeartRateCtrl', ['$http', '$scope', '$filter', '$uibModal', function($http, $scope, $filter, $uibModal) {
    var restURL = "/webapi/patient/";
    function draw() {
        $http({
            method: "GET",
            url: restURL
        }).then(function mySucces(response) {
            $scope.patients = response.data;
        }, function myError(response) {
            console.log(response.statusText);
        });
    }
    draw();
}]);
