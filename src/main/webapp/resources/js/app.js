'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp',['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/listUsers', {
        templateUrl: 'listUsers/listUsers',
        controller: listUsersCtrl
    });

    $routeProvider.otherwise({redirectTo: '/listUsers'});
}]);

