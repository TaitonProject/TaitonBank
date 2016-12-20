/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */
/*angular.module('AppRole',[]).controller('RoleController',
    function($scope, $http) {
    $http.get('/listRoles.json').success(function (response) {
        $scope.roles = response;
    });
});*/
RoleController = function ($scope, $http) {

    $scope.fetchRoleList = function () {
        $scope.resetError();
        $http.get('/registration/listRoles.json').success(function (response) {
            $scope.roles = response;
            $scope.selectedOption = $scope.roles[0];
        }).error(function () {
            $scope.setError('беда в предосталвнии списка ролей')
        });
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchRoleList();
};
