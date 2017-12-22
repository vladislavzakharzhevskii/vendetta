angular.module('myApp').factory('ProductService', ['$http', function ($http) {

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

    srv.getParsedComputers = function (successCallback, failureCallback) {

        var req = {
            method: 'POST',
            url: '/getParsedComputerParts',
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