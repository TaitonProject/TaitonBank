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

    $scope.addService = function (service) {
        $scope.resetError();
        service.organizationId = $scope.organization.id;
        service.accountId = $scope.account.id;
        $http.post('/service/addService', service).success(function () {
            $scope.fetchServiceList();
            $scope.service = {
                name: '',
                account: ''
            };
        }).error(function () {
            $scope.setError('беда при добавлении сервиса');
        })
    };

    $scope.deleteService = function (id) {
        $scope.resetError();
        $http.delete('/service/deleteService/'+id).success(function () {
            $scope.fetchServiceList();
            $scope.service = {
                name: '',
                account: ''
            };
        }).error(function () {
            $scope.setError('беда при удалении сервиса');
        })
    };

    $scope.fetchServiceList = function () {
        $scope.resetError();
        $http.get('/service/serviceList.json').success(function (response) {
            $scope.services = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка сервисов')
        });
    };

    /*    $scope.fetchAccountList = function () {
     $scope.resetError();
     $http.get('/service/accountList.json').success(function (response) {
     $scope.accounts = response;
     }).error(function () {
     $scope.setError('беда в предосталвнии списка аккаунтов')
     });
     };*/

    $scope.fetchOrganizationList = function () {
        $scope.resetError();
        $http.get('/service/organizationList.json').success(function (response) {
            $scope.organizations = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка организаций')
        });
    };

    /*    $scope.setService = function (service) {
     $scope.resetError();
     $scope.service = service;
     };*/

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.organization = organization;
    };

    /*    $scope.setAccount = function (account) {
     $scope.resetError();
     $scope.account = account;
     };*/

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchOrganizationList();
    $scope.fetchServiceList();

};
