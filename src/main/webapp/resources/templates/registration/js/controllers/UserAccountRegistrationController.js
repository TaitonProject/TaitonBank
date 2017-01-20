/**
 * Created by Taiton on 1/15/2017.
 */
/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserAccountRegistrationController = function ($scope, $http) {

    $scope.account = {
        number: '',
        userId: ''
    };

    $scope.fetchUsersList = function () {
        $scope.resetError();
        $http.get('/editing/listUsers.json').success(function (response) {
            $scope.users = response;
            $scope.setError(response);
        }).error(function () {
            $scope.setError('беда в предосталвнии списка пользователей')
        });
    };

    $scope.addUserAccount = function (account) {
        $scope.resetError();
        $http.post('/registration/userAccount', account).success(function (response) {
            $scope.fetchUsersList();
            $scope.account = {
                userId: '',
                number: ''
            };
            $scope.setTrueMessage(response)
        }).error(function (response, status) {
            if (status === 400){
                $scope.setError(response)
            } else {
                $scope.setError(' Некорректные данные.');
            }
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

    $scope.errorMessage = '';
    $scope.successMessage = '';

    $scope.setUser = function (userInfoId) {
        $scope.resetError();
        $scope.account.userId = userInfoId;
        $scope.formVisible = true;
    };

    $scope.closed= function () {
        $scope.formVisible = false;
    };

    $scope.fetchUsersList();
};

