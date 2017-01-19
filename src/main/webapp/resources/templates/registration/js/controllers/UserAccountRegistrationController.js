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

        $http.post('/registration/userAccount', account).success(function () {
            $scope.fetchUsersList();
            $scope.account = {
                userId: '',
                number: ''
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

    $scope.setUser = function (userInfoId) {
        $scope.resetError();
        $scope.account.userId = userInfoId;
    };

    $scope.fetchUsersList();
};

