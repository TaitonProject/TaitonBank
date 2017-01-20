/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

CardRegistrationController = function ($scope, $http) {

    $scope.user = {};
    $scope.card = {
        id: '',
        cardNumber: '',
        dateOfExpiry: '',
        accountId: ''
    };
    $scope.account = {};

    $scope.addCard = function (card) {
        $scope.resetError();
        card.accountId = $scope.account.id;
        $http.post('/card/addCard', card).success(function () {
            $scope.fetchServiceList();
            $scope.card = {
                cardNumber: '',
                dateOfExpiry: null
            };
        }).error(function () {
            $scope.setError('беда при добавлении карты');
        })
    };

    $scope.fetchAccountList = function (id) {
        $scope.resetError();
        $http.get('/card/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка аккаунтов')
        });
    };

    $scope.fetchUsersList = function () {
        $scope.resetError();
        $http.get('/card/listUsers.json').success(function (response) {
            $scope.users = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка пользователей')
        });
    };

    $scope.setUser = function (user) {
        $scope.resetError();
        $scope.fetchAccountList(user.userByUserId.id);
        $scope.user = user;
    };

    $scope.setAccount = function (account) {
        $scope.resetError();
        $scope.account = account;
        $scope.formVisible = true;
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.closed= function () { 
        $scope.formVisible = false;
     };

    $scope.closed= function () { 
        $scope.formVisible = false; 
    };

    $scope.fetchUsersList();

};
