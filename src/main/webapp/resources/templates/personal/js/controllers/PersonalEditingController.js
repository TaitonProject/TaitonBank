/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

PersonalEditingController = function ($scope, $http) {

    $scope.user = {};
    $scope.editingUser = null;

    $scope.fetchUsersList = function () {
        $scope.resetError();
        $http.get('/personal/personalsList.json').success(function (response) {
            $scope.users = response;
        }).error(function () {
            $scope.setError(' Невозможно предоставить список пользователей')
        });
    };

    $scope.editUser = function (user) {
        $scope.resetError();
        $http.put('/personal/editUser', user).success(function (response) {
            $scope.setTrueMessage(response);
            $scope.fetchUsersList();
            $scope.user = {
                surName: null,
                firstName: null,
                secondName: null,
                pasportNumber: null,
                userByUserId : {
                    isBlocked: null,
                    roleByRoleIdRole: null
                }
            };
        }).error(function (response, status) {
            if(status === 400) {
                $scope.setError(response);
            } else
                $scope.setError(" Некорректные данные.")
        })
    };

    $scope.edit = function (user) {
        $scope.resetError();
        $scope.user = user;
        $scope.formVisible = true;
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
    $scope.closed= function () { 
        $scope.formVisible = false; 
    };


    $scope.errorMessage = '';
    $scope.successMessage = '';

    $scope.fetchUsersList();
};

