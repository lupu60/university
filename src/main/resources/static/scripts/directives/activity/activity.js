'use strict';
angular.module('sbAdminApp').controller('ActivityCtrl', ['$http', '$scope', '$filter', '$uibModal', function($http, $scope, $filter, $uibModal) {
    var patientrestURL = "/webapi/patient/";
    $scope.oneAtATime = true;

    function draw() {
        $http({
            method: "GET",
            url: patientrestURL
        }).then(function mySucces(response) {
            $scope.patients = response.data;
            response.data.forEach(function(element, index) {
                $http({
                    method: "GET",
                    url: patientrestURL + "activity/" + element.smartBand.mac
                }).then(function mySucces(response) {
                    element.activity = response.data;
                    var stepsChart = $("#" + element.name + "steps");
                    var heartRateChart = $("#" + element.name + "heartRate");
                    var steps = [];
                    var labels = [];
                    var heartRate = [];
                    element.activity.forEach(function(element, index) {
                        steps.push(element.steps);
                        var sum = element.heartRate.reduce(function(a, b) {
                            return a + b;
                        });
                        heartRate.push(sum / element.heartRate.length);
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
    $scope.viewActivity = function(patient, dt) {
        $http({
            method: "GET",
            url: patientrestURL + "activity/" + patient.smartBand.mac + '/' + dt.getTime(),
        }).then(function mySucces(response) {
            var stepsChart = $("#" + patient.name + "steps");
            var heartRateChart = $("#" + patient.name + "heartRate");
            var steps = [];
            var labels = [];
            var heartRate = [];
            response.data.forEach(function(element, index) {
                steps.push(element.steps);
                var sum = element.heartRate.reduce(function(a, b) {
                    return a + b;
                });
                heartRate.push(sum / element.heartRate.length);
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
    }
    draw();

    $scope.today = function() {
        $scope.dt = new Date();
    };

    $scope.today();

    $scope.clear = function() {
        $scope.dt = null;
    };

    $scope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };

    $scope.dateOptions = {
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };

    $scope.toggleMin = function() {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.toggleMin();

    $scope.open1 = function() {
        $scope.popup1.opened = true;
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.altInputFormats = ['M!/d!/yyyy'];

    $scope.popup1 = {
        opened: false
    };

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }

        return '';
    }

}]);
