var base_url = 'http://localhost:8080/api/v1';
application
    .factory('Auth', function($log) {
        return {
            isLogged : function() {
                return false;
            },
            login: function(username, password) {
                $log.log('Username: ' + username);
                $log.log('Password: ' + password);
            }
        }
    })
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
            },
            delete: function(element, path) {
                element.$delete(
                    function () {
                        $location.path(path);
                    }
                );
            },
            redirect : function(path) {
                $location.path(path);
            }
        }
    })
    .factory('Restaurant', function($resource) {
        return $resource(
            base_url + '/restaurant/:id', {
                id: '@id'
            }
        )
    })
    .factory('User', function($resource) {
        return $resource(
            base_url + '/user/:id', {
                id: '@id'
            }
        )
    })
    .factory('Role', function($resource) {
        return $resource(
            base_url + '/role/:id', {
                id: '@id'
            }
        )
    })
;
