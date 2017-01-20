/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserRegistrationController = function ($scope, $http) {

    $scope.addNewUser = function (user) {
        $scope.resetError();
        $http.post('/registration/addUser', user).success(function () {
            $scope.user = {
                surName: '',
                firstName: '',
                secondName: '',
                pasportNumber: '',
                userByUserId : {
                    username: '',
                    password: '',
                    confirmPassword: ''
                }
            };
        }).error(function () {
            $scope.setError('беда при добавлении пользователя, возможно такой пользователь уже есть');
        })
    };
    if(document.getElementById("confirm_Password").value !==  document.getElementById("user_password").value){
        document.getElementById("confirm_password_info").value("Пароли не совпадают");
    }

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.errorMessage = '';
};

function stageController($scope) {
    $scope.user_password = 'password';
}
