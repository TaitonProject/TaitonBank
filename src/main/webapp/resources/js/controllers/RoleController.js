/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */
angular.module('RoleApp',[]).controller('RoleController',
    function($scope, $http) {
    $http.get('/listRoles.json').success(function (response) {
        $scope.roles = response;
    });
});

