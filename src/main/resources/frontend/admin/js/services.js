var base_url = 'http://localhost:8080/api/v1';
application
    .factory('Auth', ['Base64', '$http', '$location', function (Base64, $http, $location) {

        var authenticated = false;
        var user = {};

        return {
            isLogged : function() {
                return authenticated;
            },
            logout : function()
            {
                authenticated = false;
                user = {}
            },
            login: function(username, password, path) {

                var encoded = Base64.encode(username + ':' + password);
                $http.defaults.headers.common['Authorization'] = 'Basic ' + encoded;

                $http.post(base_url + '/login')
                    .success(
                        function () {
                            authenticated = true;
                            user = { 'username' : username, 'password' : password };
                            $location.path(path);
                        })
                    .error(
                        function () {
                            authenticated = false;
                            user = {}
                        }
                    );
            }
        }
    }])
    .factory('Util', ['$location', function($location) {
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
    }])
    .factory('Restaurant', ['$resource', function($resource) {
        return $resource(
            base_url + '/restaurant/:id', {
                id: '@id'
            }
        )
    }])
    .factory('User', ['$resource', function($resource) {
        return $resource(
            base_url + '/user/:id', {
                id: '@id'
            }
        )
    }])
    .factory('Role', ['$resource', function($resource) {
        return $resource(
            base_url + '/role/:id', {
                id: '@id'
            }
        )
    }])
    .factory('Base64', function() {
        var keyStr = 'ABCDEFGHIJKLMNOP' +
            'QRSTUVWXYZabcdef' +
            'ghijklmnopqrstuv' +
            'wxyz0123456789+/' +
            '=';
        return {
            encode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                do {
                    chr1 = input.charCodeAt(i++);
                    chr2 = input.charCodeAt(i++);
                    chr3 = input.charCodeAt(i++);

                    enc1 = chr1 >> 2;
                    enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                    enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                    enc4 = chr3 & 63;

                    if (isNaN(chr2)) {
                        enc3 = enc4 = 64;
                    } else if (isNaN(chr3)) {
                        enc4 = 64;
                    }

                    output = output +
                        keyStr.charAt(enc1) +
                        keyStr.charAt(enc2) +
                        keyStr.charAt(enc3) +
                        keyStr.charAt(enc4);
                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";
                } while (i < input.length);

                return output;
            },

            decode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
                var base64test = /[^A-Za-z0-9\+\/\=]/g;
                if (base64test.exec(input)) {
                    alert("There were invalid base64 characters in the input text.\n" +
                        "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                        "Expect errors in decoding.");
                }
                input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

                do {
                    enc1 = keyStr.indexOf(input.charAt(i++));
                    enc2 = keyStr.indexOf(input.charAt(i++));
                    enc3 = keyStr.indexOf(input.charAt(i++));
                    enc4 = keyStr.indexOf(input.charAt(i++));

                    chr1 = (enc1 << 2) | (enc2 >> 4);
                    chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                    chr3 = ((enc3 & 3) << 6) | enc4;

                    output = output + String.fromCharCode(chr1);

                    if (enc3 != 64) {
                        output = output + String.fromCharCode(chr2);
                    }
                    if (enc4 != 64) {
                        output = output + String.fromCharCode(chr3);
                    }

                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";

                } while (i < input.length);

                return output;
            }
        };
    });