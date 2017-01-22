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

    $scope.isLoading = false;

    $scope.editUserBalance = function (account) {
        $scope.isLoading = true;
        $scope.resetError();

            $http.post('/editing/addUserBalance', account).success(function (response) {
                $scope.isLoading = false;
                $scope.account = {
                    accountNumber: null,
                    accountBalance: null
                };
                $scope.setTrueMessage(response);
            }).error(function (response) {
                $scope.isLoading = false;
                $scope.setError(response);
            })
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

};

