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
    $scope.isOrgNull = false;
    $scope.isCardsNull = false;
    $scope.isAccountsNull = false;
    $scope.isCatNull = false;

    $scope.addPayment = function (paymentInfo) {
        $scope.isLoading = true;

        $scope.resetError();
        paymentInfo = {
            category: $scope.paymentInfo.category,
            organization: $scope.paymentInfo.organization,
            card: $scope.paymentInfo.card,
            payment: {
                info: $scope.paymentInfo.payment.info,
                amount: $scope.paymentInfo.payment.amount
            }

        };
        if ($scope.paymentInfo.category != '') {
            $http.post('/payment/addPayment', paymentInfo).success(function (response) {
                $scope.closed();
                $scope.fetchCardList();
                $scope.isLoading = false;

                $scope.paymentInfo = {
                    category: {
                        categoryName : '',
                        idCategory : ''
                    },
                    organization: {
                        id: '',
                        name: ''
                    },
                    card: {
                        accountNumber : '',
                        balance : '',
                        cardNumber : '',
                        dateOfExpiry : ''
                    },
                    payment: {
                        info: '',
                        amount: ''
                    }
                };
                $scope.setTrueMessage(response);
            }).error(function (response, status) {
                $scope.isLoading = false;
                if (status === 400) {
                    $scope.setError(response)
                } else {
                    $scope.setError(' Некорректные данные.');
                }
            })
        }
        else {
            $scope.setError(' Не выбрана услуга!');
            $scope.isLoading = false;
        }
    };

    $scope.fetchAccountList = function (id) {
        $scope.isLoading = true;
        $scope.isAccountsNull = false;

        $scope.resetError();
        $http.get('/payment/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
            $scope.isLoading = false;
            if ($scope.accounts.length == 0){
                $scope.isAccountsNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError('Не удалось получить список счетов. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchOrganizationList = function (id) {
        $scope.isOrgNull = false;
        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/payment/organizationList.json/'+id).success(function (response) {
            $scope.organizations = response;
            $scope.isLoading = false;
            if ($scope.organizations.length == 0){
                $scope.isOrgNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError('Не удалось список организаций. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchCategoryList = function () {
        $scope.isCatNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/payment/categoryList.json').success(function (response) {
            $scope.categoryies = response;
            $scope.isLoading = false;
            if ($scope.categoryies.length == 0){
                $scope.isCatNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError('Не удалось получить список категорий. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchCardList = function () {
        $scope.isCardsNull = false;

        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/payment/cardListBalance.json').success(function (response) {
            $scope.cards = response;
            $scope.isLoading = false;
            if($scope.cards.length == 0){
                $scope.isCardsNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
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

        $scope.paymentInfo = {
            card : card,
            category: null,
            organization: null,
            payment: null
        };
        $scope.formVisible = false;
        $scope.formVisibleSelect = true;
        $scope.Fieldshow = false;
    };

    $scope.setCategory = function (category) {
        $scope.resetError();
        $scope.fetchOrganizationList(category.idCategory);
        //$scope.organization = organization;
        $scope.paymentInfo.category = category;
        $scope.Fieldshow = false;
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

    $scope.closed= function () {
        $scope.formVisible = false;
        $scope.Fieldshow = false;
        $scope.formVisibleSelect = false;
    };

    $scope.fetchCategoryList();
    $scope.fetchCardList();

};
