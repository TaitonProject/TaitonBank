/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserBalanceEditingController = function ($scope, $http) {

    $scope.account = {
        accountNumber : '',
        accountBalance: ''
    };

    $scope.editUserBalance = function (account) {
        $scope.resetError();
        $http.post('/editing/addUserBalance', account).success(function () {
            $scope.account = {
                accountNumber: '',
                accountBalance: 0
            };
        }).error(function () {
            $scope.setError('беда при изменении баланса пользователя');
        })
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

};

