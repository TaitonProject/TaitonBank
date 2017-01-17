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
            $scope.setError('беда в предосталвнии списка пользователей')
        });
    };

    $scope.editUser = function (user) {
        $scope.resetError();
        $http.put('/personal/editUser', user).success(function () {
            $scope.fetchUsersList();
            $scope.user = {
                surName: '',
                firstName: '',
                secondName: '',
                pasportNumber: '',
                userByUserId : {
                    username: '',
                    password: '',
                    isBlocked: null,
                    roleByRoleIdRole: null
                }
            };
        }).error(function () {
            $scope.setError('беда при изменении пользователя');
        })
    };

    /*    $scope.deleteUser = function (id) {
     $scope.resetError();
     $http.delete('/editing/deleteUser/'+id).success(function () {
     $scope.fetchUsersList();
     $scope.user = {
     surName: '',
     firstName: '',
     secondName: '',
     pasportNumber: '',
     userByUserId : {
     username: '',
     password: '',
     isBlocked: null
     }
     };
     }).error(function () {
     $scope.setError('беда при удалении пользователя');
     })
     };*/

    $scope.edit = function (user) {
        $scope.resetError();
        $scope.user = user;
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchUsersList();
};

