var base_url = 'http://localhost:8080/api/v1';
application
    .factory('Element', function($resource) {
        return $resource(
            base_url + '/element/:id', {
                id: '@id'
            }
        )
    });
