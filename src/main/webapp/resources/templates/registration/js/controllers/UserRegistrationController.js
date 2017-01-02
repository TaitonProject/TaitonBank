/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

UserRegistrationController = function ($scope, $http) {

    $scope.user = {};


    $scope.addNewUser = function (user) {
        $scope.resetError();
        $http.post('/registration/addUser', user).success(function () {
            $scope.fetchUsersList();
            $scope.user.username = '';
            $scope.user.password = '';
            $scope.user.confirmPassword = '';
            $scope.user.isBlocked = false;
            $scope.user.roleByRoleIdRole = null;
        }).error(function (status) {
            if(status === 400){
                $scope.setError('Ошибка! Проверьте введенные данные!')
            }
            $scope.setError('Не удалось зарегестрировать пользователя')
        })
    };

/*    $scope.fetchRoleList = function () {
        $scope.resetError();
        $http.get('/registration/listRoles.json').success(function (response) {
            $scope.roles = response;
            $scope.selectedOption = $scope.roles[0];
        }).error(function () {
            $scope.setError('беда в предосталвнии списка ролей')
        });
    };*/

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    // $scope.fetchRoleList();
};

