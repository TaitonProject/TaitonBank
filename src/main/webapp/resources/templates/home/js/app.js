'use strict';

var TaitonBankApp = {};

var App = angular.module('TaitonBankApp', ['TaitonBankApp.filters', 'TaitonBankApp.services', 'TaitonBankApp.directives']);

// Declare app level module which depends on filters, and services
/*
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/registration', {
        templateUrl: 'registration/layout',
        controller: RegistrationController
    });
    $routeProvider.when('/user', {
        templateUrl: 'user/user_info',
        controller: UserController
    });

}]);
*/


App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/registration', {
        templateUrl: 'registration/layout',

    });
    $routeProvider.when('/registration/userInfo', {
        templateUrl: 'registration/userInfo',
        controller: 'UserRegistrationController'
    });

    $routeProvider.when('/user', {
        templateUrl: 'user/users',
        controller: 'UserController'
    });
    $routeProvider.when('/phone', {
        templateUrl: 'pay/phone',
        controller: 'UserController'
    });
    $routeProvider.when('/editing/userInfo', {
        templateUrl: 'editing/userInfo',
        controller: 'UserEditingController'
    });
    $routeProvider.when('/edit_personal', {
        templateUrl: 'editing/personal',
    });
    $routeProvider.when('/editing/personal', {
        templateUrl: 'editing/personal',
    });

    $routeProvider.when('/editing/userAccount', {
        templateUrl: 'editing/userAccount',
    });

    $routeProvider.when('/registration/userAccount', {
        templateUrl: 'registration/userAccount',
        controller: 'UserAccountRegistrationController'
    });

    $routeProvider.otherwise({redirectTo: '/'});
}]);