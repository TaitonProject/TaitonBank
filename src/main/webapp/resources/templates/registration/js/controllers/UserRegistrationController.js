/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserRegistrationController = function ($scope, $http) {

    $scope.user = {};

    $scope.fetchUsersList = function () {
        $scope.resetError();
        $http.get('/registration/registration.json').success(function (response) {
            $scope.users = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка пользователей')
        });
    };

    $scope.addNewUser = function (user) {
        $scope.resetError();
        $http.post('/registration/addUser', user).success(function () {
            $scope.fetchUsersList();
            $scope.user = {
                username: '',
                password: '',
                confirmPassword: '',
                info : {
                    firstName: '',
                    secondName: '',
                    sureName: '',
                    passportNumber: ''
                }
            };
        }).error(function () {
            $scope.setError('беда при добавлении пользователя');
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

    $scope.fetchUsersList();
};
