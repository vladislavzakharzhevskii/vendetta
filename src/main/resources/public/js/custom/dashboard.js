var myApp = angular.module('myApp',[
    'ui.materialize',
    'ngRoute',
    'ngSanitize'
]);


myApp.controller("CertainPageController", ['$scope', 'dashboardService', function ($scope, dashboardService) {

    $scope.showPreloader = false;
    $scope.computerAssembly = {
        basePart: '',
        additionalPart: []
    };

    $scope.computerAssembly = {};
    dashboardService.getComputerProducts(
        function (result) {
            $scope.showPreloader = false;

            var compData = result.data;
            $scope.decoratorProductsNames = compData['Computer-bases'];

            $scope.hardDisks = [];
            $scope.processors = [];
            $scope.videoCards = [];
            angular.forEach(compData['Computers-parts'], function (value, key) {
                var cType = value.componentType;
                if(cType == 'processor'){
                    $scope.processors.push(value);
                } else {
                    if(cType == 'video-card') {
                        $scope.videoCards.push(value);
                    } else {
                        if(cType == 'hard-disk') {
                            $scope.hardDisks.push(value);
                        }
                    }
                }
            });

        }, function (error) {});


    $scope.doOrder = function () {
        $scope.showPreloader = true;
        $scope.orderingProcess = true;

        //TODO IT"S HACK TO CONVERT KEY-VALUE ARRAY to SIMPLE VALUES ARRAY
        var selectedComponentsIds = [];
        angular.forEach($scope.computerAssembly.additionalPart, function (value, key) {
            selectedComponentsIds.push(value);
        });
        /*send request and create model object on the server*/
        dashboardService.sendComputerOrder($scope.computerAssembly.basePart, selectedComponentsIds,
            function successCallback(response) {
                $scope.showPreloader = false;
                $scope.orderingProcess = false;

                $scope.successOrderState = 'HAS_ORDERED';
                $scope.successOrderInfo = response.data;

            }, function errorCallback(response) {
                $scope.showPreloader = false;
                $scope.orderingProcess = false;
            });

    };

}]);

