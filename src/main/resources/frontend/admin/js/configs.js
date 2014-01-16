application
    .config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/',               {templateUrl: 'templates/partials/default.html',       controller: 'DefaultCtrl' }).
        when('/elements',       {templateUrl: 'templates/partials/elements.html',      controller: 'ElementListCtrl' }).
        when('/elements/add',   {templateUrl: 'templates/partials/elementEdit.html',   controller: 'ElementEditCtrl' }).
        when('/elements/:id',   {templateUrl: 'templates/partials/elementEdit.html',   controller: 'ElementEditCtrl' }).
        when('/items',          {templateUrl: 'templates/partials/items.html',         controller: 'ItemListCtrl' }).
        when('/items/:id',      {templateUrl: 'templates/partials/itemEdit.html',      controller: 'ItemEditCtrl' }).
        when('/orders',          {templateUrl: 'templates/partials/orders.html',       controller: 'OrderListCtrl' }).
        when('/users',          {templateUrl: 'templates/partials/users.html',         controller: 'UserListCtrl' }).
        otherwise({redirectTo: '/'});
    }])
//    .config(function ($locationProvider) {
//        $locationProvider.html5Mode(true);
//    })
;