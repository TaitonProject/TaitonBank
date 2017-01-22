/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

PaymentServiceController = function ($scope, $http) {

    $scope.paymentInfo = {
        category: '',
        organization: '',
        card: '',
        payment: {
            info: '',
            amount: ''
        }
    };
    $scope.isLoading = false;

    $scope.addPayment = function (paymentInfo) {
        $scope.isLoading = true;

        $scope.resetError();
        //card.accountId = $scope.account.id;
        paymentInfo = {
            category: $scope.paymentInfo.category,
            organization: $scope.paymentInfo.organization,
            card: $scope.paymentInfo.card,
            payment: {
                info: $scope.paymentInfo.payment.info,
                amount: $scope.paymentInfo.payment.amount
            }

        };
        $http.post('/payment/addPayment', paymentInfo).success(function (response) {
            //$scope.fetchServiceList();
            $scope.isLoading = false;

            $scope.paymentInfo = {
                category: '',
                organization: '',
                card: '',
                payment: {
                    info: '',
                    amount: ''
                }
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
        $scope.resetError();
        $http.get('/payment/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
        }).error(function () {
            $scope.setError('Не удалось получить список счетов. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchOrganizationList = function (id) {
        $scope.resetError();
        $http.get('/payment/organizationList.json/'+id).success(function (response) {
            $scope.organizations = response;
        }).error(function () {
            $scope.setError('Не удалось список организаций. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchCategoryList = function () {
        $scope.resetError();
        $http.get('/payment/categoryList.json').success(function (response) {
            $scope.categoryies = response;
        }).error(function () {
            $scope.setError('Не удалось получить список категорий. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardListBalance.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('Не удалось получить список карт. Пожалуйста, повторите позже')
        });
    };

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.paymentInfo.organization = organization;
        $scope.Fieldshow = true;
    };

    $scope.setCard = function (card) {
        $scope.resetError();
        $scope.paymentInfo.card = card;
        $scope.formVisible = true;
        $scope.formVisibleSelect = true;
    };

    $scope.setCategory = function (category) {
        $scope.resetError();
        $scope.fetchOrganizationList(category.idCategory);
        //$scope.organization = organization;
        $scope.paymentInfo.category = category;
        $scope.Fieldshow = false;
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

    $scope.closed= function () {
        $scope.formVisible = false;
        $scope.Fieldshow = false;
        $scope.formVisibleSelect = false;
    };

    $scope.fetchCategoryList();
    $scope.fetchCardList();

};
