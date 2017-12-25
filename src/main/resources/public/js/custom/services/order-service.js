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


    srv.getOrders = function (successCallback, errorCallback) {
        var req = {
            method: 'GET',
            url: srv.controllerPath + "/getProductOrders",
            headers: {
                Accept: "application/json"
            }
        };

        $http(req).then(successCallback, errorCallback);
    };

    srv.changeOrderStatus = function (orderId, newStatus, successCallback, errorCallback) {
        var req = {
            method: 'POST',
            url: srv.controllerPath + "/changeOrdersStatus",
            params: {
                pk: orderId,
                newOrderStatus: newStatus
            },
            headers: {
                Accept: "application/json"
            }
        };

        $http(req).then(successCallback, errorCallback);
    };


    return srv;
}]);