application
    .config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/elements',       {templateUrl: 'templates/partials/elements.html',      controller: 'ElementListCtrl' }).
        when('/elements/add',   {templateUrl: 'templates/partials/elementEdit.html',   controller: 'ElementEditCtrl' }).
        when('/elements/:id',   {templateUrl: 'templates/partials/elementEdit.html',   controller: 'ElementEditCtrl' }).
        when('/items',          {templateUrl: 'templates/partials/items.html',         controller: 'ItemListCtrl' }).
        when('/items/:id',      {templateUrl: 'templates/partials/itemEdit.html',      controller: 'ItemEditCtrl' }).
        when('/orders',          {templateUrl: 'templates/partials/orders.html',       controller: 'OrderListCtrl' }).

        when('/login',      {templateUrl: 'templates/partials/login.html',      controller: 'Login' }).

        when('/users',      {templateUrl: 'templates/partials/users.html',      controller: 'UserList' }).
        when('/users/add',  {templateUrl: 'templates/partials/userEdit.html',   controller: 'UserEdit' }).
        when('/users/:id',  {templateUrl: 'templates/partials/userEdit.html',   controller: 'UserEdit' }).

        when('/roles',      {templateUrl: 'templates/partials/roles.html',      controller: 'RoleList' }).
        when('/roles/add',  {templateUrl: 'templates/partials/roleEdit.html',   controller: 'RoleEdit' }).
        when('/roles/:id',  {templateUrl: 'templates/partials/roleEdit.html',   controller: 'RoleEdit' }).
        otherwise({redirectTo: '/login'});
    }]);