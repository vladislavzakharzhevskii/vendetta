myApp.config(['$routeProvider',
    function($routeProvider) {

        $routeProvider
            .when("/dashboard", {
                templateUrl: "mainPage.html"
            })
            .when("/computer-management", {
                templateUrl: "computer-management.html"
            })
            .otherwise({
                redirectTo: "/"
            });

}]);