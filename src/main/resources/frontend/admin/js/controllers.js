application
    .controller('Admin', ['$scope', '$location', function ($scope, $location) {

        $scope.login = function () {
            $location.path('/roles');
        }

        $scope.logged = function ()
        {
            if ( $location.path() === '/' ) {
                return false;
            }
            else {
                return true;
            }

        }
    }])

    .controller('ElementListCtrl', ['$scope', 'Element', '$location', function($scope, Element, $location) {
        $scope.elements = Element.query();
        $scope.edit = function (element) {
            $location.path('/elements/' + element.id);
        }
        $scope.add = function () {
            $location.path('/elements/add');
        }
    }])
    .controller('ElementEditCtrl', ['$scope', 'Element', '$location', '$routeParams', function($scope, Element, $location, $routeParams) {
        if ( $routeParams.id != null ) {
            $scope.element = Element.get( { id : $routeParams.id } );
        }
        else  {
            $scope.element = new Element({});
        }
        $scope.save =  function() {
            $scope.element.$save();
        }
    }])
    .controller('ItemListCtrl', ['$scope', 'Item', '$location', function($scope, Item, $location) {
        $scope.items = Item.query();
        $scope.edit = function (element) {
            $location.path('/items/' + element.id);
        }
    }])
    .controller('ItemEditCtrl', ['$scope', 'Item', '$routeParams', function($scope, Item, $routeParams) {
        $scope.item = Item.get( $routeParams.id ); //TODO should be { id : $routeParams.id }
    }])
    .controller('OrderListCtrl', ['$scope', function($scope) {
    }])
    .controller('UserListCtrl', ['$scope', function($scope) {
    }])

    /** ROLE **/

    .controller('RoleList', ['$scope', '$location', 'Role', function($scope, $location, Role) {
        $scope.roles = Role.query();
        $scope.edit = function (role) {
            $location.path('/roles/' + role.id);
        }
        $scope.add = function () {
            $location.path('/roles/add');
        }
    }])
    .controller('RoleEdit', ['$routeParams', '$scope', '$location', 'Role', 'Util', function($routeParams, $scope, $location, Role, Util) {
        $scope.isNew = true;
        if ( $routeParams.id != null ) {

            Role.get(
                 { id : $routeParams.id },
                 function(role) {
                     $scope.role = role;
                     $scope.isNew = false;
            });
        }
        else  {
            $scope.role = new Role({});
        }
        $scope.save =  function() {
            Util.save($scope.role, '/roles');
        }

        $scope.cancel =  function() {
            $location.path('/roles');
        }

        $scope.canSave = function () {
            return Util.canSave( $scope.roleForm );
        }
    }])

   ;
