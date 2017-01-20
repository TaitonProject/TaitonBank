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

    $scope.addService = function (service) {
        $scope.resetError();
        /*service.organizationId = $scope.organization.id;
        service.accountId = $scope.account.id;
        service.categoryIdCategory = $scope.categoryIdCategory;*/
        service.accountId = $scope.account.id;
        service.organizationId = $scope.organization.id;
        service.categoryIdCategory = $scope.category.idCategory;
        $http.post('/service/addService', service).success(function () {
            $scope.fetchServiceList();
            $scope.service = {
                categoryIdCategory: null,
                account: ''
            };
        }).error(function () {
            $scope.setError('беда при добавлении сервиса');
        })
    };

/*    $scope.deleteService = function (id) {
        $scope.resetError();
        $http.delete('/service/deleteService/'+id).success(function () {
            $scope.fetchServiceList();
            $scope.service = {
                category: '',
                account: ''
            };
        }).error(function () {
            $scope.setError('беда при удалении сервиса');
        })
    };*/

    $scope.fetchServiceList = function () {
        $scope.resetError();
        $http.get('/service/serviceList.json').success(function (response) {
            $scope.services = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка сервисов')
        });
    };

    $scope.fetchOrganizationList = function () {
        $scope.resetError();
        $http.get('/service/organizationList.json').success(function (response) {
            $scope.organizations = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка организаций')
        });
    };

    $scope.fetchCategoryList = function () {
        $scope.resetError();
        $http.get('/service/categoryList.json').success(function (response) {
            $scope.categoryies = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка организаций')
        });
    };

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.organization = organization;
    };

    $scope.setCategory = function (category) {
        $scope.resetError();
        $scope.category = category;
    };

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.errorMessage = '';

    $scope.fetchCategoryList();
    $scope.fetchOrganizationList();
};
