/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchivePaymentController = function ($scope, $http) {

    $scope.fetchPaymentList = function (card) {
        $scope.resetError();
        number = card.id;
        $scope.formVisible = true;
        $http.get('/archive/listPayment.json/'+number).success(function (response) {
            $scope.payments = response;
        }).error(function () {
            $scope.setError('Ошибка в предоставлении списка платежей');
        });
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardList.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('Ошибка в предосталвнии списка карт.')
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
