/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserEditingController = function ($scope, $http) {

    $scope.user = {};
    $scope.editingUser = null;

    $scope.fetchUsersList = function () {
        $scope.resetError();
        $http.get('/editing/listUsers.json').success(function (response) {
            $scope.users = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка пользователей')
        });
    };

    $scope.editUser = function (user) {
        $scope.resetError();
        $http.put('/editing/editUser', user).success(function (response) {
            $scope.fetchUsersList();
            $scope.user = {
                surName: '',
                firstName: '',
                secondName: '',
                pasportNumber: '',
                userByUserId : {
                    isBlocked: null
                }
            };
            $scope.setTrueMessage(response)
        }).error(function (response, status) {
            if (status === 400){
                $scope.setError(response);
            } else {
                $scope.setError('Некорректные данные.');
            }
        })
    };

    $scope.edit = function (user) {
        $scope.resetError();
        $scope.user = user;
        $scope.formVisible = true;
    };
    $scope.closed= function () {
        $scope.formVisible = false;
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

    $scope.fetchUsersList();
};

