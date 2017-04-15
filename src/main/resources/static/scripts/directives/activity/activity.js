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
                    var stepsChart = $("#" + element.name + "steps");
                    var heartRateChart = $("#" + element.name + "heartRate");
                    var steps = [];
                    var labels = [];
                    var heartRate = [];
                    element.activity.forEach(function(element, index) {
                        steps.push(element.steps);
                        heartRate.push(Math.max(...element.heartRate));

                        let date = new Date(element.timestamp);
                        labels.push(date.getHours() + ":" + date.getMinutes());
                    });
                    var myStepsChart = new Chart(stepsChart, {
                        type: 'line',
                        data: {
                            labels: labels,
                            datasets: [{
                                label: 'steps',
                                data: steps,
                                backgroundColor: "rgba(83, 66, 244,0.6)"
                            }],
                        }
                    });
                    var myHrChart = new Chart(heartRateChart, {
                        type: 'line',
                        data: {
                            labels: labels,
                            datasets: [{
                                label: 'Heart Rate',
                                data: heartRate,
                                backgroundColor: "rgba(244, 65, 65,0.6)"
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
