/**
 * Created by egordragun on 25.12.16.
 */
var UserController = function($scope, $http) {
    $http.get('/listUsers.json').success(function (response) {
        $scope.users = response;
    });
};
