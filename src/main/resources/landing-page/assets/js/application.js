angular.module('landing', [])
    .controller('Subscribe', ['$scope', '$http', function ($scope, $http) {
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
    }])
;