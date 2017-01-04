UserController = function($scope, $http) {
    $scope.fetchUserList = function () {
        $http.get('/editing/listUsers.json').success(function (listUsers) {
            $scope.users = listUsers;
        });
    };

    $scope.fetchUserList();
};

