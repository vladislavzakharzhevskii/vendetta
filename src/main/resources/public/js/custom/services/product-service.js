angular.module('myApp').factory('ProductService', ['$http', function ($http) {

    var srv = {};

    srv.getComputers = function (successCallback, failureCallback) {

        var req = {
            method: 'GET',
            url: '/getProducts',
            headers: {
                Accept: 'application/json'
            }
        };

        $http(req).then(successCallback, failureCallback);
    };


    srv.saveProduct = function (data, successCallback, failureCallback) {
        var req = {
            method: 'POST',
            url: '/saveProduct',
            params: data
        };

        $http(req).then(successCallback, failureCallback);
    };


    srv.deleteProduct = function (productId, successCallback, errorCallback) {
        var req = {
            method: 'POST',
            url: '/deleteProduct',
            params: {productPk: productId},
            headers: {
                Access: 'text/html'
            }
        };

        $http(req).then(successCallback, errorCallback);
    };




    return srv;
}]);