/**
 * Created by Taiton on 1/16/2017.
 */
/**
 * UserController
 * @constructor
 */

OrganizationRegistrationController = function ($scope, $http) {

    $scope.organization = {};
    $scope.isLoading = false;

    $scope.addOrganization = function (organization) {
        $scope.isLoading = true;

        $scope.resetError();
        $http.post('/organization/addOrganization', organization).success(function () {
            $scope.isLoading = false;

            $scope.fetchOrganizationList();
            $scope.organization = {
                id: '',
                name: ''
            };
            $scope.setTrueMessage(' Добавлена организация.');
        }).error(function (response, status) {
            $scope.isLoading = false;
            $scope.fetchOrganizationList();
            if (status === 400) {
                $scope.setError(response)
            } else
                $scope.setError(" Некорректные данные.")
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
            $scope.setError(" Не удалось предоставить список организаций")
        });
    };

    $scope.setOrg = function (organization) {
        $scope.resetError();
        $scope.organization = organization;
        /*$scope.formVisible = true;*/
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

    $scope.fetchOrganizationList();
};
