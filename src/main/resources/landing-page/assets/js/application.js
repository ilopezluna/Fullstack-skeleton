angular.module('landing', [])
    .controller('Subscribe', ['$scope', '$http', '$location', function ($scope, $http, $location) {

        $scope.message = '';
        $scope.send = function() {
            if ( $scope.subscriber != null)
            {
                $http.post('/api/v1/subscriber', $scope.subscriber)
                    .success(function() {
                        $scope.message = '¡Te has subscrito correctamente! Te avisaremos cuando empecemos';
                    });
            }
            else {
                $scope.message = 'La dirección de correo introducida no es válida';
            }

        }
        $scope.isDevice = function () {
            var isDevice = navigator.userAgent.match(/Android/i)
                || navigator.userAgent.match(/webOS/i)
                || navigator.userAgent.match(/iPhone/i)
                || navigator.userAgent.match(/iPad/i)
                || navigator.userAgent.match(/iPod/i)
                || navigator.userAgent.match(/BlackBerry/i)
                || navigator.userAgent.match(/Windows Phone/i);

            if (isDevice === null) {
                return false;
            }
            else {
                return true;
            }
        };
    }])
;