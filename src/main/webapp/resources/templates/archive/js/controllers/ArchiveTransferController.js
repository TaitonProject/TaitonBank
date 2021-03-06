/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchiveTransferController = function ($scope, $http) {

    $scope.isLoading = false;
    $scope.isTransferNull = false;
    $scope.isCardsNull = false;

    $scope.fetchTransferList = function (card) {
        $scope.isTransferNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        number = card.cardNumber;
        $scope.formVisible = true;
        $http.get('/archive/listTransfer.json/'+number).success(function (response) {
            $scope.isLoading = false;
            $scope.transfers = response;
            if($scope.transfers.length == 0){
                $scope.isTransferNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список переводов. Пожалуйста, повторите позже');
        });
    };

    $scope.fetchCardList = function () {
        $scope.isCardsNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/payment/cardListBalance.json').success(function (response) {
            $scope.isLoading = false;
            $scope.cards = response;
            if($scope.cards.length == 0){
                $scope.isCardsNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список карт. Пожалуйста, повторите позже')
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
