/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserProfileController = function ($scope, $http) {

    $scope.user = {};

    $scope.password = {
        password: '',
        confirmPassword: ''
    };

    $scope.helloUser = function () {
        $scope.resetError();
        $http.get('/user/hello').success(function (response) {
            $scope.user = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии имени пользователя')
        });

    };

    $scope.editPassword = function (password) {
        $scope.resetError();
        $http.put('/user/editPassword', password).success(function () {
            $scope.password = {
                password: '',
                confirmPassword: ''
            };
        }).error(function () {
            $scope.setError('беда при изменении пользователя');
        })
    };
    if(document.getElementById("confirm_Password").value !==  document.getElementById("user_password").value){
        document.getElementById("confirm_password_info").value("Пароли не совпадают");
    }

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.helloUser();
};

function stageController($scope) {
    $scope.user_password = 'password';
}
