/**
 * Created by Taiton on 12/15/2016.
 */

var listUsersCtrl = function($scope, $http) {
    $scope.fetchUserList = function () {
        $http.get('/listUsers.json').success(function (listUsers) {
            $scope.users = listUsers;
        });
    };

    $scope.fetchUserList();
};

