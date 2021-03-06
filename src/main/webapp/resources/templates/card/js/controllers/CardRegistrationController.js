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
    $scope.isLoading = false;
    $scope.isAccountsNull = false;
    $scope.isUsersNull = false;

    $scope.addCard = function (card) {
        $scope.resetError();
        $scope.isLoading = true;
        card.accountId = $scope.account.id;
        $http.post('/card/addCard', card).success(function (response) {
            $scope.isLoading = false;
            $scope.card = {
                cardNumber: '',
                dateOfExpiry: null
            };
            $scope.setTrueMessage(response);
        }).error(function (response, status) {
            $scope.isLoading = false;

            if (status === 400){
                $scope.setError(response)
            } else {
                $scope.setError(' Некорректные данные.');
            }
        })
    };

    $scope.fetchAccountList = function (id) {
        $scope.isAccountsNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/card/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
            $scope.isLoading = false;
            if ($scope.accounts.length == 0){
                $scope.isAccountsNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список счетов. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchUsersList = function () {
        $scope.isUsersNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/card/listUsers.json').success(function (response) {
            $scope.users = response;
            $scope.isLoading = false;
            if ($scope.users.length == 0){
                $scope.isUsersNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список пользователей. Пожалуйста, повторите позже')
        });
    };

    $scope.setUser = function (user) {
        $scope.resetError();
        $scope.fetchAccountList(user.userByUserId.id);
        $scope.user = user;
        $scope.tableVisible = true;
        $scope.formVisible = false;
    };

    $scope.setAccount = function (account) {
        $scope.resetError();
        $scope.account = account;
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

    $scope.errorMessage = '';
    $scope.successMessage = '';

    $scope.closed= function () { 
        $scope.formVisible = false;
     };

    $scope.fetchUsersList();

};
