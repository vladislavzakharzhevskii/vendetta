angular.module('myApp').factory('DashboardService', ['$http', function ($http) {

    var srvCalls = {};


    srvCalls.getDashboardData = function (successCallback) {
        var req = {
            method: 'GET',
            url: '/dashboard/getDashboardData',
            headers: {
                Accept: 'application/json'
            }
        };

        $http(req).then(successCallback);
    };




    return srvCalls;

}]);
