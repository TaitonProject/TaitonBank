/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */

PersonalRegistrationController = function ($scope, $http) {

    $scope.isLoading = false;
    $scope.isRolesNull = false;

    $scope.addNewUser = function (user) {
        $scope.isLoading = true;
        $scope.resetError();
        $http.post('/personal/addUser', user).success(function (response) {
            $scope.isLoading = false;
            $scope.setTrueMessage(response);
            $scope.user = {
                surName: null,
                firstName: null,
                secondName: null,
                pasportNumber: null,
                userByUserId : {
                    username: null,
                    password: null,
                    confirmPassword: null,
                    roleByRoleIdRole: null
                }
            };
        }).error(function (response, status) {
            $scope.isLoading = false;
            if(status === 400) {
                $scope.setError(response);
            } else
                $scope.setError(" Некорректные данные.")
        })
    };
    if(document.getElementById("confirm_Password").value !==  document.getElementById("user_password").value){
        document.getElementById("confirm_password_info").value("Пароли не совпадают");
    }

    $scope.fetchRoleList = function () {
        $scope.isLoading = true;
        $scope.isRolesNull = false;

        $scope.resetError();
        $http.get('/personal/rolesList.json').success(function (response) {
            $scope.roles = response;
            $scope.isLoading = false;
            if($scope.roles.length == 0 ){
                $scope.isRolesNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' В предоставлении списка ролей')
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

    $scope.fetchRoleList();

};

function stageController($scope) {
    $scope.user_password = 'password';
}
