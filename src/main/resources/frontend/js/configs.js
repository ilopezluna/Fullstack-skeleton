application
    .config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/',                       {templateUrl: 'templates/partials/default.html',        controller: 'DefaultCtrl' }).
        when('/element/:id',            {templateUrl: 'templates/partials/element-detail.html', controller: 'ElementDetailCtrl' }).
        when('/congrats',               {templateUrl: 'templates/partials/congrats.html'}).
        when('/registrationSuccess',    {templateUrl: 'templates/partials/registrationSuccess.html'}).
        when('/404',                    {templateUrl: 'templates/partials/404.html' }).
        otherwise({redirectTo: '/404'});
    }])
//    .config(function ($locationProvider) {
//        $locationProvider.html5Mode(true);
//    })
;