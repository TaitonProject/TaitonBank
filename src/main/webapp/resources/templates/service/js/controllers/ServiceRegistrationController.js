/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

ServiceRegistrationController = function ($scope, $http) {

    $scope.service = {};
    $scope.organization = {};
    $scope.account = {};
    $scope.category = {};
    $scope.isLoading = false;
    $scope.isServicesNull = false;
    $scope.isOrgNull = false;
    $scope.isCatNull = false;

    $scope.addService = function (service) {
        $scope.isLoading = true;

        $scope.resetError();
        /*service.organizationId = $scope.organization.id;
        service.accountId = $scope.account.id;
        service.categoryIdCategory = $scope.categoryIdCategory;*/
        service.accountId = $scope.account.id;
        service.organizationId = $scope.organization.id;
        service.categoryIdCategory = $scope.category.idCategory;
        $http.post('/service/addService', service).success(function (response) {
            $scope.isLoading = false;

            $scope.fetchServiceList();
            $scope.service = {
                categoryIdCategory: null,
                account: ''
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

    $scope.fetchServiceList = function () {
        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/service/serviceList.json').success(function (response) {
            $scope.services = response;
            $scope.isLoading = false;
            if ($scope.services.length == 0){
                $scope.isServicesNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError(' Не удалось получить список сервисов. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchOrganizationList = function () {
        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/service/organizationList.json').success(function (response) {
            $scope.organizations = response;
            $scope.isLoading = false;
            if ($scope.organizations.length == 0){
                $scope.isOrgNull = true;
            }
        }).error(function () {
            $scope.isLoading = false;
            $scope.setError('Не удалось получить список организаций. Пожалуйста, повторите позже')
        });
    };

    $scope.fetchCategoryList = function () {
        $scope.isLoading = true;
        $scope.resetError();
        $http.get('/service/categoryList.json').success(function (response) {
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

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.organization = organization;
        $scope.formVisible = true;
        $scope.Fieldshow = true;
        $scope.formVisible = false;
    };

    $scope.setCategory = function (category) {
        $scope.resetError();
        $scope.category = category;
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

    $scope.fetchCategoryList();
    $scope.fetchOrganizationList();
};
