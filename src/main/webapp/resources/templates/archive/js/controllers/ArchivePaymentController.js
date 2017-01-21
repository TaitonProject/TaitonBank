/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchivePaymentController = function ($scope, $http) {

    $scope.fetchPaymentList = function (id) {
        $scope.resetError();
        $http.get('/card/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка аккаунтов')
        });
    };

    $scope.fetchPaymentList();

};
