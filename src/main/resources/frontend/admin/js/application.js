var application = angular.module('private', ['ngRoute', 'ngResource','ui.bootstrap'])

    .run(function ($rootScope, $location, $log, Auth) {

        // enumerate routes that don't need authentication
        var routesThatDontRequireAuth = ['/login'];

        $rootScope.$on('$routeChangeStart', function (event, next, current) {

            if ($.inArray($location.path(), routesThatDontRequireAuth) == -1 && !Auth.isLogged()) {
                // Authentication needed
                $location.path('/login');
            }

        });
    });;
