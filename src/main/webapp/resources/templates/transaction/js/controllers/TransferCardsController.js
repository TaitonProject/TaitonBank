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
    $scope.isLoading = false;

    $scope.addTransfer = function (transfer) {
        $scope.isLoading = true;

        $scope.resetError();
        transfer.cardFrom = $scope.transfer.cardFrom;
        transfer.amount = $scope.transfer.amount;
        $http.post('/transaction/addTransfer', transfer).success(function (response) {
            $scope.isLoading = false;

            $scope.setTrueMessage(response);
            $scope.transfer = {
                cardTo: null,
                cardFrom: null,
                amount: null
            };

        }).error(function (response, status) {
            $scope.isLoading = false;

            if(status === 400) {
                $scope.setError(response);
            } else
                $scope.setError(" Некорректные данные.")
        })
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardList.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('Не удалось получить список карт. Пожалуйста, повторите позже')
        });
    };

    $scope.setCard = function (card) {
        $scope.resetError();
        $scope.transfer.cardFrom = card;
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

    $scope.fetchCardList();

};
