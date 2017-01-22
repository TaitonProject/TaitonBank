/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserRegistrationController = function ($scope, $http) {

    $scope.isLoading = false;

    $scope.addNewUser = function (user) {
        $scope.isLoading = true;

        $scope.resetError();
        $http.post('/registration/addUser', user).success(function (response) {
            $scope.isLoading = false;

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
            $scope.setTrueMessage(response)
        }).error(function (response, status) {
            $scope.isLoading = false;

            if (status === 400){
                $scope.setError(response)
            } else {
                $scope.setError(" Некорректные данные.")
            }
        })
    };
    if(document.getElementById("confirm_Password").value !==  document.getElementById("user_password").value){
        document.getElementById("confirm_password_info").value("Пароли не совпадают");
    }

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.setTrueMessage = function (message) {
        $scope.success = true;
        $scope.successMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.success = false;
        $scope.errorMessage = '';
        $scope.successMessage = '';
    };

    $scope.errorMessage = '';
    $scope.successMessage = '';

    function stageController($scope) {
        $scope.user_password = 'password';
    }
};


