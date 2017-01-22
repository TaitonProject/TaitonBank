/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchiveTransferController = function ($scope, $http) {

    $scope.fetchTransferList = function (card) {
        $scope.resetError();
        number = card.id;
        $scope.formVisible = true;
        $http.get('/archive/listTransfer.json/'+number).success(function (response) {
            $scope.transfers = response;
        }).error(function () {
            $scope.setError(' Ошибка в предоставлении списка переводов. Пожалуйста, повторите позже');
        });
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardList.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError(' Ошибка в предоставлении списка карт. Пожалуйтса, повторите позже')
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

    $scope.fetchCardList();
};
