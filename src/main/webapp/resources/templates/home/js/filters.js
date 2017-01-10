'use strict';

/* Filters */

var AppFilters = angular.module('TaitonBankApp.filters', []);

AppFilters.filter('interpolate', ['version', function (version) {
    return function (text) {
        return String(text).replace(/\%VERSION\%/mg, version);
    }
}]);

AppFilters.controller('mainController', function($scope) {

$scope.submitForm = function() {

    // check to make sure the form is completely valid
    if ($scope.userForm.$valid) {
        alert('our form is amazing');
    }

}

});