var UserController = function($scope, $http) {
    $scope.fetchUserList = function () {
        $http.get('/listUsers.json').success(function (listUsers) {
            $scope.users = listUsers;
        });
    };

    $scope.fetchUserList();
};

