angular.module('myApp').factory('dashboardService', ['$http', function ($http) {

    var srv = {};

    srv.getComputerProducts = function (successCallback, errorCallback) {
        $http({
            method: "GET",
            url: "get-computers-data"
        }).then(successCallback, errorCallback);

    };





    return srv;
}]);