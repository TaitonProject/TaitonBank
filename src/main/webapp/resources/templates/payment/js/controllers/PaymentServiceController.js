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

    $scope.addPayment = function (paymentInfo) {
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
        $http.post('/payment/addPayment', paymentInfo).success(function () {
            $scope.fetchServiceList();
            $scope.paymentInfo = {
                category: '',
                organization: '',
                card: '',
                payment: {
                    info: '',
                    amount: ''
                }
            };
        }).error(function () {
            $scope.setError('беда при добавлении карты');
        })
    };

    $scope.fetchAccountList = function (id) {
        $scope.resetError();
        $http.get('/payment/listUsersAccount.json/'+id).success(function (response) {
            $scope.accounts = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка аккаунтов')
        });
    };

    $scope.fetchOrganizationList = function (id) {
        $scope.resetError();
        $http.get('/payment/organizationList.json/'+id).success(function (response) {
            $scope.organizations = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка организаций')
        });
    };

    $scope.fetchCategoryList = function () {
        $scope.resetError();
        $http.get('/payment/categoryList.json').success(function (response) {
            $scope.categoryies = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка категорий')
        });
    };

    $scope.fetchCardList = function () {
        $scope.resetError();
        $http.get('/payment/cardList.json').success(function (response) {
            $scope.cards = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка категорий')
        });
    };

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.paymentInfo.organization = organization;
    };

    $scope.setCard = function (card) {
        $scope.resetError();
        $scope.paymentInfo.card = card;
    };

    $scope.setCategory = function (category) {
        $scope.resetError();
        $scope.fetchOrganizationList(category.idCategory);
        //$scope.organization = organization;
        $scope.paymentInfo.category = category;
    };
    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchCategoryList();
    $scope.fetchCardList();

};
