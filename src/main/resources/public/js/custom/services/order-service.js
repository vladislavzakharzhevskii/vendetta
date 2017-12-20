angular.module('myApp').factory('OrderService', ['$http', function ($http) {

    var srv = {
        controllerPath : '/order'
    };

    srv.submitOrder = function (data, successCallback, errorCallback) {
        var req = {
            method: 'POST',
            url: srv.controllerPath + '/submitComputerOrder',
            params: data,
            headers : {
                Accept: 'text/html'
            }
        };

        $http(req).then(successCallback, errorCallback);
    };

    return srv;
}]);