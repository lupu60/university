'use strict';
angular.module('sbAdminApp').directive('patients', function()
{
    return {
        templateUrl: 'scripts/directives/patient/patients.html',
        restrict: 'E',
        replace: true,
    }
});
angular.module('sbAdminApp').controller('PatientCtrl', ['$http', '$scope', '$filter', '$uibModal', function($http, $scope, $filter, $uibModal)
    {
        var $ctrl = this;
        $ctrl.animationsEnabled = false;
        $http(
        {
            method: "GET",
            url: "/webapi/patient/"
        }).then(function mySucces(response)
        {
            $scope.rowCollection = response.data;
        }, function myError(response)
        {
            console.log(response.statusText);
        });

        function generateRandomItem()
        {
            var names = ['Laurent', 'Blandine', 'Olivier', 'Max', 'Shelly', 'Ambrose', 'Teresia', 'Thomasine', 'Teressa', 'Wava', 'Tula', 'Kelly', 'Jacelyn', 'Sheila', 'Sylvester', 'Scarlet', 'Babette', 'Vivian', 'Lorene', 'Keri', 'Mao', 'Jetta', 'Nichol', 'Marlene'];
            var sexs = ['MALE', 'FEMALE'];
            var bands = ['91553dc2-4ebc-4e61-9604-38b041b4cb0d', 'e76d3deb-9a68-4584-84de-186bfc85ac14', '75fa5708-ef64-49d7-b6fc-ba612876758e', '0581f4ae-f106-11e6-bc64-92361f002671', '0581fa1c-f106-11e6-bc64-92361f002671', '0581fb48-f106-11e6-bc64-92361f002671', '0581fc38-f106-11e6-bc64-92361f002671', '0581fd1e-f106-11e6-bc64-92361f002671', '0581fe04-f106-11e6-bc64-92361f002671', '0581ff30-f106-11e6-bc64-92361f002671', '058200b6-f106-11e6-bc64-92361f002671', '05820728-f106-11e6-bc64-92361f002671', '058209e4-f106-11e6-bc64-92361f002671', '05820b4c-f106-11e6-bc64-92361f002671', '05820de0-f106-11e6-bc64-92361f002671', '05820eee-f106-11e6-bc64-92361f002671', '05820fc0-f106-11e6-bc64-92361f002671', '058212e0-f106-11e6-bc64-92361f002671', '058213c6-f106-11e6-bc64-92361f002671', '05821498-f106-11e6-bc64-92361f002671', '05821560-f106-11e6-bc64-92361f002671', '05821628-f106-11e6-bc64-92361f002671', '05821c9a-f106-11e6-bc64-92361f002671', '05821db2-f106-11e6-bc64-92361f002671'];
            return {
                "name": names[Math.floor(Math.random() * 24)],
                "sex": sexs[Math.floor(Math.random() * 2)],
                "bandId": bands[Math.floor(Math.random() * 24)]
            };
        }
        $scope.addRandomItem = function addRandomItem()
        {
            var tmp = generateRandomItem()
            $scope.rowCollection.push(tmp);
            $http(
            {
                method: "POST",
                url: "/webapi/patient/",
                data: tmp
            }).then(function mySucces(response)
            {
                console.log(response);
            }, function myError(response)
            {
                console.log(response.statusText);
            });
        };
        $scope.removeItem = function removeItem(row)
        {
            var index = $scope.rowCollection.indexOf(row);
            if (index !== -1)
            {
                $scope.rowCollection.splice(index, 1);
            }
            $http(
            {
                method: "DELETE",
                url: "/webapi/patient/" + row.id,
            }).then(function mySucces(response)
            {
                console.log(response);
            }, function myError(response)
            {
                console.log(response.statusText);
            });
        };
        $scope.editItem = function editItem(row)
        {
            var modalInstance = $uibModal.open(
            {
                animation: $ctrl.animationsEnabled,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: 'patientModal.html',
                controller: function($scope, $uibModalInstance)
                {
                    $scope.patient = row;
                    $scope.ok = function()
                    {
                        $uibModalInstance.close();
                    };
                    $scope.cancel = function()
                    {
                        $uibModalInstance.dismiss('cancel');
                    };
                },
                controllerAs: '$ctrl',
                size: 'lg'
            });
            // $http(
            // {
            //     method: "DELETE",
            //     url: "/webapi/patient/",
            //     data: row.data
            // }).then(function mySucces(response)
            // {
            //     console.log(response);
            // }, function myError(response)
            // {
            //     console.log(response.statusText);
            // });
        };
}]);