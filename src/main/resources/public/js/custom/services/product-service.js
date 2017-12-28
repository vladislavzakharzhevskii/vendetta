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


    srv.saveProduct = function (formData, sCallback, eCallback) {
        var req = {
            method: 'POST',
            url: '/saveProduct',
            data: formData,
            headers: {
                'Content-Type': undefined
            },
            transformRequest: angular.identity         /*prevent Serialization data by Angular*/
        };

        $http(req).then(sCallback, eCallback);
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


    srv.deleteProductImage = function (pk, successCallback, failureCallback) {
        var req = {
            method: 'GET',
            url: '/deleteProductImage',
            params: {productImagePk: pk}
        };

        $http(req).then(successCallback, failureCallback);
    };


    return srv;
}]);