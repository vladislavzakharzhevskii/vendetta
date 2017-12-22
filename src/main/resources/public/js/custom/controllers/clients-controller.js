
myApp.controller("ClientsController", ['$scope', '$http', function ($scope, $http) {


    var req = {
        method: 'GET',
        url: '/clients/getClients'
    };

    $http(req).then(function (response) {
        $scope.clients = response.data;
    });

}]);