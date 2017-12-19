angular.module('myApp').factory('computerService', ['$http', function ($http) {

    var srv = {};

    srv.getComputers = function (successCallback, failureCallback) {
        var req = {
            method: 'GET',
            url: '/getComputers',
            headers: {
                Accept: 'application/json'
            }
        };

        $http(req).then(successCallback, failureCallback);
    };


    srv.saveComputer = function (compData, successCallback, failureCallback) {
        var req = {
            method: 'POST',
            url: '/saveComputerPart',
            params: compData
        };

        $http(req).then(successCallback, failureCallback);
    };




    return srv;
}]);