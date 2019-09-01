var app = angular.module('todoapp', ['ngAnimate', 'ui.bootstrap', 'dndLists']);
var usertoken;
var x = false;
$.ajax({
        beforeSend: function(xhrObj){
                xhrObj.setRequestHeader("Authorization","Bearer tj7LTLycpQC6DRup5BkHUO7uVbYaAZI40");
        },
        type: "GET",
        url: "http://localhost:8090/todoitems/",
        success: function(e){
                console.log(e)
        }
});


app.controller('LoginController', function($scope, $http, $uibModal, $log, $window) {

  $scope.animationsEnabled = true;

  $scope.login = function(user) {

    $http.post("http://localhost:8090/login", user).then(function successCallback(response) {
      $window.sessionStorage.token = response.data;
      usertoken = response.data;
      x = true;
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

app.controller('TodolistController', function($scope, $http, $window) {
  $scope.getInclude = function() {
    if (x) {
      return "todolist.html";
    }
    return "";
  };

  // var req = {
  //  method: 'GET',
  //  url: 'http://localhost:8090/todoitems',
  //  headers: {
  //    "Content-type": "application/json",
  //   "Authorization": "Bearer 3333454"
  // },
  //    crossDomain: true
  // };
  //
  // $http(req).then(function(){}, function(){});

  $scope.models = {
    selected: null,
    lists: {
      "ToDo": [],
      "InProgress": [],
      "Done": []
    }
  };

  // Generate initial model
  for (var i = 1; i <= 3; ++i) {
    $scope.models.lists.ToDo.push({
      label: "Item A" + i
    });
    $scope.models.lists.InProgress.push({
      label: "Item B" + i
    });
    $scope.models.lists.Done.push({
      label: "Item C" + i
    });
  }

});

app.controller('RegisterController', function($scope, $uibModalInstance, $http) {

  $scope.ok = function(user) {
    console.log(user);
    $http.post("http://localhost:8090/createUser", user).then(function successCallback(response) {
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

// $http({url: '/api/restricted', method: 'GET'})
// .success(function (data, status, headers, config) {
//   console.log(data.name); // Should log 'foo'
// });
app.factory('authInterceptor', function($rootScope, $q, $window) {
  return {
    request: function(config) {
      config.headers = config.headers || {};
      if ($window.sessionStorage.token) {
        config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
      }
      return config;
    },
    response: function(response) {
      if (response.status === 401) {
        // handle the case where the user is not authenticated
      }
      return response || $q.when(response);
    }
  };
});

app.config(function($httpProvider) {
 //   $httpProvider.defaults.useXDomain = true;
 //  $httpProvider.interceptors.push('authInterceptor');
 //  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
 //  $httpProvider.defaults.headers.common = {};
 // $httpProvider.defaults.headers.post = {};
 // $httpProvider.defaults.headers.put = {};
 // $httpProvider.defaults.headers.patch = {};
 //  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});
