/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */
var myApp=angular.module('myApp',[]);
var UserController = function($scope, $http) {
        $http.get('/listUsers.json').success(function (response) {
                $scope.users = response;
        });
};



