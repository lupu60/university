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
                    var ctx = $("#" + element.name);
                    var steps = [];
                    var labels = [];
                    element.activity.forEach(function(element, index) {
                        steps.push(element.steps);
                        let date = new Date(element.timestamp);
                        labels.push(date.getHours()+":"+date.getMinutes());
                    });
                    var myLineChart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: labels,
                            datasets: [{
                                label: 'steps today overview',
                                data: steps,
                                backgroundColor: "rgba(153,255,51,0.6)"
                            }],
                        }
                    });
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
