var base_url = 'http://localhost:8080/api/v1';
application
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
