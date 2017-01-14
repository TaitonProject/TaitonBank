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
    $routeProvider.when('/registration/user', {
        templateUrl: 'registration/user',
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
    $routeProvider.when('/edit_user', {
        templateUrl: 'editing/user',
        controller: 'UserEditingController'
    });
    $routeProvider.when('/edit_personal', {
        templateUrl: 'editing/personal',
    });

    $routeProvider.otherwise({redirectTo: '/'});
}]);