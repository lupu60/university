var app = angular.module('todoapp', ['ngAnimate', 'ui.bootstrap']);
var usertoken;
app.controller('LoginController', function($scope, $http, $uibModal, $log) {

  $scope.animationsEnabled = true;

  $scope.login = function(user) {

    console.log(user);
    $http.post("http://localhost:8090/login",user).then(function successCallback(response) {
      usertoken=response.data;
      console.log(usertoken);
    }, function errorCallback(response) {
      console.log(response.data);
    });
  };

  $scope.register = function(size) {

    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      templateUrl: 'myModalContent.html',
      controller: 'RegisterController',
      size: size
    });
  };
});

app.controller('RegisterController', function($scope, $uibModalInstance, $http) {

  $scope.ok = function(user) {
    console.log(user);
    $http.post("http://localhost:8090/createUser",user).then(function successCallback(response) {
      console.log(response.data);
    }, function errorCallback(response) {
      console.log(response.data);
    });

    $uibModalInstance.close();
  };

  $scope.cancel = function() {
    $uibModalInstance.dismiss('cancel');
  };
});
