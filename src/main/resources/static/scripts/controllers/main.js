'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp').controller('MainCtrl', ['$scope', '$http', function($scope, $http) {
    const restURLPatients = "/webapi/patient/";
    const restURLSmartBands = "/webapi/smartband/";
    const restURLActivity = "/webapi/activity/";

    $(document).ready(function() {
        $.ajax({
            url: "/webapi"
        }).then(function(data, status, jqxhr) {
            $('#hello').append(data);
        });
    });
    $http({
        method: "GET",
        url: restURLPatients
    }).then(function mySucces(response) {
        $scope.patientsNumber = response.data.length;
    }, function myError(response) {
        console.log(response.statusText);
    });

    $http({
        method: "GET",
        url: restURLSmartBands
    }).then(function mySucces(response) {
        $scope.smartBandsNumber = response.data.length;
    }, function myError(response) {
        console.log(response.statusText);
    });
    $http({
        method: "GET",
        url: restURLActivity
    }).then(function mySucces(response) {
        $scope.activityNumber = response.data.length;
    }, function myError(response) {
        console.log(response.statusText);
    });
}]);;
(function() {
    $('#side-menu').metisMenu();
})();
