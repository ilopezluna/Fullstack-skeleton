var base_url = 'http://localhost:8080/api/v1';
application
    .factory('Util', function($location) {
        return {
            canSave : function(form) {
                return form.$dirty && form.$valid;
            },
            save: function(element, path) {
                element.$save(
                    function () {
                        $location.path(path);
                    }
                );
            }
        }
    })
    .factory('Restaurant', function($resource) {
        return $resource(
            base_url + '/restaurant/:id', {
                id: '@Id'
            }
        )
    })
    .factory('Role', function($resource) {
        return $resource(
            base_url + '/role/:id', {
                id: '@Id'
            }
        )
    })
;
