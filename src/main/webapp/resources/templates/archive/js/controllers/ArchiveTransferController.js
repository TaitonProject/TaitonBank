/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchiveTransferController = function ($scope, $http) {

    $scope.fetchTransferList = function (id) {
        $scope.resetError();
        $http.get('/card/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка аккаунтов')
        });
    };

    $scope.fetchTransferList();

};
