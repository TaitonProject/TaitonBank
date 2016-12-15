/**
 * Created by Taiton on 12/15/2016.
 */
var listUsersApp = angular.module('listUsersApp', []);
//noinspection JSAnnotator
listUsersApp.controller() = function ($scope, $http) {
    $scope.fetchUsersList = function () {
        $http.get('/listUsers').success(function (listUsers) {
            $scope.users = listUsers;
        })
    }
}