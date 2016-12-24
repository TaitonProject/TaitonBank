myApp.config(function($routeProvider){
    $routeProvider.when('/user',
        {
            templateUrl:'pages/user_profile.html',
            controller:'QuestionController'
        });
});
