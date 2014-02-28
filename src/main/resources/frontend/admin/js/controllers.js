application
    .controller('Admin', ['$scope', '$location', function ($scope, $location) {

        $scope.login = function () {
            $location.path('/roles');
        }

        $scope.logged = function ()
        {
            return $location.path() != '/';
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

    /** USERS **/

    .controller('UserList', ['$scope', '$location', 'User', function($scope, $location, User) {
        $scope.users = User.query();

        $scope.edit = function (user) {
            $location.path('/users/' + user.id);
        }

        $scope.add = function () {
            $location.path('/users/add');
        }
    }])
    .controller('UserEdit', ['$routeParams', '$scope', 'User', 'Role', 'Util', '$log', function($routeParams, $scope, User, Role, Util, $log) {
        $scope.path = '/users';
        $scope.isNew = true;
        Role.query(function(roles) {
            $scope.roles = roles;
            if ( $routeParams.id != null ) {

                User.get(
                    { id : $routeParams.id },
                    function(user) {
                        $scope.user = user;

                        // Note: ngModel compares by reference, not value. So role from user an roles of Roles resource are different, and I must re-assign.
                        angular.forEach(roles, function (role) {
                            if ($scope.user.role.id === role.id)
                            {
                                $scope.user.role = role;
                            }

                        });
                        $scope.isNew = false;
                    });
            }
            else  {
                $scope.user = new User({});
            }
        });

        $scope.save =  function() {
            Util.save($scope.user, $scope.path);
        }

        $scope.cancel =  function() {
            Util.redirect($scope.path);
        }

        $scope.canSave = function () {
            return Util.canSave( $scope.userForm );
        }

        $scope.delete =  function() {
            Util.delete($scope.user, $scope.path);
        }
    }])

    /** ROLES **/

    .controller('RoleList', ['$scope', '$location', 'Role', function($scope, $location, Role) {

        $scope.roles = Role.query();

        $scope.edit = function (role) {
            $location.path('/roles/' + role.id);
        }

        $scope.add = function () {
            $location.path('/roles/add');
        }
    }])
    .controller('RoleEdit', ['$routeParams', '$scope', 'Role', 'Util', function($routeParams, $scope, Role, Util) {
        $scope.path = '/roles';
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
            Util.save($scope.role, $scope.path);
        }

        $scope.cancel =  function() {
            Util.redirect($scope.path);
        }

        $scope.canSave = function () {
            return Util.canSave( $scope.roleForm );
        }

        $scope.delete =  function() {
            Util.delete($scope.role, $scope.path);
        }
    }])

   ;
