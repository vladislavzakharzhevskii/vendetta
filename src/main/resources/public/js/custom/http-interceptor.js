myApp.factory('http-Interceptor', ['$rootScope', '$log', '$timeout', '$q',
    function ($rootScope, $log, $timeout, $q) {

        return {
            // On request success
            request: function (config) {
                //prevent call for ng-include='.html'
                if(config.url.indexOf('.html') === -1) {
                    console.log(config); // Contains the data about the request before it is sent.
                    $rootScope.general.showPreloader = true;
                }
                // Return the config or wrap it in a promise if blank.
                return config || $q.when(config);
            },

            // On request failure
            requestError: function (rejection) {
                console.log(rejection); // Contains the data about the error on the request.
                $rootScope.general.showPreloader = true;
                Materialize.toast("Request Error has occurred", 8000);
                // Return the promise rejection.
                return $q.reject(rejection);
            },

            // On response success
            response: function (response) {
                if(response.config.url.indexOf('.html') === -1) {
                    console.log(response); // Contains the data from the response.
                    //keep pre-loader state during 1sec.
                    $timeout(function () {
                        $rootScope.general.showPreloader = false;
                    }, 1000);
                }
                // Return the response or promise.
                return response || $q.when(response);
            },

            // On response failure
            responseError: function (rejection) {
                console.log(rejection); // Contains the data about the error.
                $rootScope.general.showPreloader = true;
                Materialize.toast("Some Error occurred on the Server Side. CHECK IT?", 2000);
                // Return the promise rejection.
                return $q.reject(rejection);
            }
        };
    }]);