'use strict';

var TaitonBankApp = {};

var App = angular.module('TaitonBankApp', []);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/user', {
        templateUrl: 'pages/user_profile.html',
        controller: ProfileController
    });

}]);
