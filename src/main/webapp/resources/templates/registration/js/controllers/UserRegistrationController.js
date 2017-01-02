/**
 * Created by Taiton on 1/2/2017.
 */

UserRegistrationController = function ($scope, $http) {
    $scope.addNewUser = function (user) {
        $scope.resetError();
        $http.post('/registration/addUser', user).success(function () {
            $scope.fetchUsersList();
            $scope.user.username = '';
            $scope.user.password = '';
            $scope.user.confirmPassword = '';
            $scope.user.isBlocked = false;
            $scope.user.roleByRoleIdRole = null;
        }).error(function () {
            $scope.setError('беда при добавлении пользователя');
        })
    };
}