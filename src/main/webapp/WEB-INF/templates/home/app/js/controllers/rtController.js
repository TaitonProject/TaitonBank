var myApp=angular.module('myApp', [])
    .run(function ($rootScope) {
        $rootScope.message="Modul myApp";
    });
myApp.controller('myController', function ($scope) {
    $scope.message="Controller myController";
});
myApp.controller('phoneController',function ($scope) {
    $scope.phones = [{
        name: 'Nokia Lumia 630',
        year: 2014,
        price: 200,
        company: 'Nokia'
    },{
        name: 'Samsung Galaxy S 4',
        year: 2014,
        price: 400,
        company: 'Samsung'
    },{
        name: 'Mi 5',
        year: 2015,
        price: 300,
        company: 'Xiaomi'
    }];
});