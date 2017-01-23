/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ArchivePaymentController = function ($scope, $http) {

    $scope.isLoading = false;
    $scope.isPaymentsNull = false;
    $scope.isCardsNull = false;

    $scope.fetchPaymentList = function (card) {
        $scope.isLoading = true;
        $scope.resetError();
        number = card.cardNumber;
        $scope.formVisible = true;
        $http.get('/archive/listPayment.json/'+number).success(function (response) {
            $scope.isLoading = false;
            $scope.payments = response;
            if($scope.payments.length == 0){
                $scope.isPaymentsNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список платежей. Пожалуйста, повторите позже');
        });
    };

    $scope.fetchCardList = function () {
        $scope.isCardsNull = false;
        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/payment/cardListBalance.json').success(function (response) {
            $scope.isLoading = false;
            $scope.cards = response;
            if ($scope.cards.length == 0){
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
