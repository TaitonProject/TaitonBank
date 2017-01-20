/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

TransferCardsController = function ($scope, $http) {

    $scope.transfer = {
        cardTo: '',
        cardFrom: '',
        amount: ''
    };

    $scope.addTransfer = function (transfer) {
        $scope.resetError();
        transfer.cardFrom = $scope.transfer.cardFrom;
        transfer.amount = $scope.transfer.amount;
        $http.post('/transaction/addTransfer', transfer).success(function () {
            $scope.transfer = {
                cardTo: null,
                cardFrom: null,
                amount: null
            };
        }).error(function (response) {
            $scope.setError(response);
        })
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardList.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('Ошибка в предосталвнии списка карт.')
        });
    };

    $scope.setCard = function (card) {
        $scope.resetError();
        $scope.transfer.cardFrom = card;
    };

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchCardList();

};
