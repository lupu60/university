var app = angular.module('todoApp', []);



app.controller('login', function($scope, $http, $modal) {

  var login = this;
  login.login = function() {
    $http.post("localhost:8090/login").then(function successCallback(response) {
      console.log(username, password);
      console.log(response.data);
    }, function errorCallback(response) {
      console.log(response.data);
    });
  };

});
