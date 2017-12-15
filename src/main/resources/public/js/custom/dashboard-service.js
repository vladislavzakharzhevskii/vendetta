angular.module('myApp').factory('dashboardService', ['$http', function ($http) {

    var srv = {};

    srv.getComputerProducts = function (successCallback, errorCallback) {
        $http({
            method: "GET",
            url: "get-computers-data"
        }).then(successCallback, errorCallback);

    };

    srv.sendComputerOrder = function (baseId, componentsIds, successCallback, errorCallback) {
        var req = {
            method: "POST",
            url: "process-order",
            params: {
                baseComponentId: baseId,
                additionalComponentsIds: componentsIds
            }
        };

        $http(req).then(successCallback, errorCallback);
    };

    srv.startSimpleThreadRequest = function (threadWorkingTime, successCallback, errorCallback) {
        var req = {
            method: 'POST',
            url: 'start-single-multithreads',
            headers: { 'Accept': 'text/plain' },
            params: {
                workingTime: threadWorkingTime
            }
        };

        $http(req).then(successCallback, errorCallback);
    };




    return srv;
}]);