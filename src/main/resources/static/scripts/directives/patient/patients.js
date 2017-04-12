'use strict';
angular.module('sbAdminApp').controller('PatientCtrl', ['$http', '$scope', '$filter', '$uibModal', function($http, $scope, $filter, $uibModal) {
    $scope.alerts = [];
    var restURL = "/webapi/patient/";
    var $ctrl = this;
    $ctrl.animationsEnabled = false;
    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };

    function draw() {
        $http({
            method: "GET",
            url: restURL
        }).then(function mySucces(response) {
            $scope.rowCollection = response.data;
        }, function myError(response) {
            console.log(response.statusText);
        });
    }
// {
//   "id": 1,
//   "name": "name",
//   "sex": true,
//   "age": 22,
//   "height": 180,
//   "weight": 80,
//   "smartBand": {
//     "mac": "C8:0F:10:88:2A:5B"
//   }
// }
    $scope.addItem = function() {
        var modalInstance = $uibModal.open({
            animation: $ctrl.animationsEnabled,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: 'itemmodal.html',
            scope: $scope,
            controller: function($scope, $uibModalInstance) {
                $scope.ok = function() {
                    $http({
                        method: "POST",
                        url: restURL,
                        data: $scope.patient
                    }).then(function mySucces(response) {
                        $scope.rowCollection.push(response.data);
                        console.log(response);
                    }, function myError(response) {
                        $scope.alerts.push({
                            type: 'danger',
                            msg: 'Oh snap! Change a few things up and try submitting again.'
                        });
                        console.log(response.statusText);
                    });
                    $uibModalInstance.close();
                };
                $scope.cancel = function() {
                    $uibModalInstance.dismiss('cancel');
                };
            },
            controllerAs: '$ctrl',
            size: 'lg'
        });
    };
    $scope.editItem = function(row) {
        var modalInstance = $uibModal.open({
            animation: $ctrl.animationsEnabled,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: 'itemmodal.html',
            controller: function($scope, $uibModalInstance) {
                $scope.patient = row;
                $scope.ok = function() {
                    $http({
                        method: "PUT",
                        url: restURL,
                        data: $scope.patient
                    }).then(function mySucces(response) {
                        console.log(response);
                    }, function myError(response) {
                        console.log(response.statusText);
                    });
                    $uibModalInstance.close();
                };
                $scope.cancel = function() {
                    $uibModalInstance.dismiss('cancel');
                };
            },
            controllerAs: '$ctrl',
            size: 'lg'
        });
    };
    $scope.removeItem = function(row) {
        var index = $scope.rowCollection.indexOf(row);
        if (index !== -1) {
            $scope.rowCollection.splice(index, 1);
        }
        $http({
            method: "DELETE",
            url: restURL + row.id
        }).then(function mySucces(response) {
            console.log(response);
        }, function myError(response) {
            console.log(response.statusText);
        });
    };
    draw();
}]);
