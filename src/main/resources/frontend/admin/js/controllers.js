application
    .controller('AdminCtrl', ['$scope', '$location', function ($scope, $location) {

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
    .controller('DefaultCtrl', ['$scope', '$location', function ($scope, $location) {

        $scope.login = function () {
            $location.path('/elements');
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
   ;
