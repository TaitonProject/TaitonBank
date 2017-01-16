/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

OrganizationRegistrationController = function ($scope, $http) {

    $scope.organization = {};

    $scope.addOrganization = function (organization) {
        $scope.resetError();
        $http.post('/organization/addOrganization', organization).success(function () {
            $scope.fetchOrganizationList();
            $scope.organization = {
                id: '',
                name: ''
            };
        }).error(function () {
            $scope.setError('беда при добавлении организации');
        })
    };

    $scope.deleteOrganization = function (id) {
        $scope.resetError();
        $http.delete('/organization/deleteOrganization/'+id).success(function () {
            $scope.fetchOrganizationList();
            $scope.organization = {
                name: ''
            };
        }).error(function () {
            $scope.setError('беда при удалении организации');
        })
    };

    $scope.fetchOrganizationList = function () {
        $scope.resetError();
        $http.get('/organization/organizationList.json').success(function (response) {
            $scope.organizations = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка организаций')
        });
    };

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.organization = organization;
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchOrganizationList();
};
