application
    .controller('HeaderCtrl', ['$scope', function ($scope) {
        $scope.header = { name: 'header', url: 'templates/components/header.html'};
    }])
    .controller('FooterCtrl', ['$scope', function ($scope) {
        $scope.footer = { name: 'footer', url: 'templates/components/footer.html'};
    }])
    .controller('DefaultCtrl', ['$scope', 'Element', function ($scope, Element) {
        $scope.elements = Element.query();

        $scope.item = { name: 'item', url: 'templates/components/element-resum.html'}
    }])
    .controller('RegisterCtrl', ['$scope', '$modal', '$location','$log', function($scope, $modal, $location, $log) {

        $scope.open = function () {

            var modalInstance = $modal.open({
                templateUrl: 'templates/components/RegisterForm.html',
                scope: $scope,
                controller: function ($scope, $modalInstance) {

                    $scope.ok = function () {
                        $modalInstance.close();
                    };

                    $scope.cancel = function () {
                        $modalInstance.dismiss('cancel');
                    };
                }
            });

            modalInstance.result.then(function () {
                $log.info('Saved at: ' + new Date());
                $location.path('/registrationSuccess');
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };
    }])
    .controller('ElementDetailCtrl', ['$scope', '$routeParams', 'Item', 'Category', function ($scope, $routeParams, Item, Category) {
        $scope.cart = { name: 'cart', url: 'templates/components/cart.html'};
        $scope.items = Item.query();
        $scope.categories = Category.query();
        $scope.id = $routeParams.id;

        $scope.order = {items:[]}

        $scope.addItem = function(index) {
            $scope.order.items.push({
                qty: 1,
                name: $scope.items[index].name,
                price: $scope.items[index].price
            });
        };
    }])
    .controller('CartCtrl', ['$scope', '$location', '$modal', '$log', function ($scope, $location, $modal, $log) {
        $scope.removeItem = function(index) {
            $scope.order.items.splice(index, 1);
        };

        $scope.total = function() {
            var total = 0;
            angular.forEach($scope.order.items, function(item) {
                total += item.qty * item.price;
            })

            $scope.order.totalPrice = total;
            return total;
        };
        $scope.saveOrder = function() {
            $location.path('/congrats');
        }
    }])
    .controller('OrderCtrl', ['$scope', '$modal', '$log', '$location', function ($scope, $modal, $log, $location) {
        $scope.open = function () {

            var modalInstance = $modal.open({
                templateUrl: 'templates/components/OrderForm.html',
                scope: $scope,
                controller: function ($scope, $modalInstance) {

                    $scope.ok = function () {
                        $modalInstance.close();
                    };

                    $scope.cancel = function () {
                        $modalInstance.dismiss('cancel');
                    };
                }
            });

            modalInstance.result.then(function () {
                $log.info('Saved at: ' + new Date());
                $location.path('/congrats');
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };
    }])
    .controller('RatingDemoCtrl',['$scope', function($scope) {
        $scope.rate = $scope.element.rank;
        $scope.max = 5;
        $scope.isReadonly = false;

        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = 100 * (value / $scope.max);
        };

        $scope.ratingStates = [
            {stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle'},
            {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
            {stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle'},
            {stateOn: 'glyphicon-heart'},
            {stateOff: 'glyphicon-off'}
        ];
    }])
;
