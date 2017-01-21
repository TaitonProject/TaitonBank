/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserProfileController = function ($scope, $http) {

    $scope.card = {
        cardNumber : '',
        balance: ''
    };

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
        $http.put('/user/editPassword', password).success(function (response) {
            $scope.password = {
                password: '',
                confirmPassword: ''
            };
            $scope.setTrueMessage(response)
        }).error(function (response, status) {
            if (status === 400) {
                $scope.setError(response);
            } else {
                $scope.setError(' Некорректный ввод.');
            }
        })
    };
    if(document.getElementById("confirm_Password").value !==  document.getElementById("user_password").value){
        document.getElementById("confirm_password_info").value("Пароли не совпадают");
    }

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardListBalance.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('Ошибка в предоставлении списка карт')
        });
    };

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

    $scope.helloUser();
    $scope.fetchCardList();
};

function stageController($scope) {
    $scope.user_password = 'password';
}
