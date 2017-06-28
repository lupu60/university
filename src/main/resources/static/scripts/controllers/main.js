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
        // var stepsChart = $("#stepsTop");
        // var patientsName = [];
        // var datasets = [];
        // response.data.forEach(function(element, index) {
        //     $http({
        //         method: "GET",
        //         url: restURLPatients + "activity/" + element.smartBand.mac
        //     }).then(function mySucces(response) {
        //         element.activity = response.data;
        //         var steps = [];
        //         var labels = [];
        //         patientsName.push(element.name);
        //         element.activity.forEach(function(element, index) {
        //             steps.push(element.steps);
        //             let date = new Date(element.timestamp);
        //             labels.push(date.getHours() + ":" + date.getMinutes());
        //         });
        //         var color = 'rgba(' + (Math.floor(Math.random() * 255)+1) + "," +  (Math.floor(Math.random() * 255)+1) + "," +  (Math.floor(Math.random() * 255)+1) + ',0.3)';
        //         let newData = {
        //             label: element.name,
        //             data: steps,
        //             backgroundColor: color
        //         }
        //         datasets.push(newData);
        //     }, function myError(response) {
        //         console.log(response.statusText);
        //     });
        // });
        // var myStepsChart = new Chart(stepsChart, {
        //     type: 'line',
        //     data: {
        //         // labels: patientsName,
        //         datasets: datasets,
        //     }
        // });
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
