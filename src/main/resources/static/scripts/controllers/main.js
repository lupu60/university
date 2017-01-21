'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp').controller('MainCtrl', function($scope, $position) {
    $(document).ready(function() {
        $.ajax({
            url: "/webapi"
        }).then(function(data, status, jqxhr) {
            $('#hello').append(data);
        });
    });
});
