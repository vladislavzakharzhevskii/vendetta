var myApp = angular.module('myApp',['ui.materialize']);


myApp.controller("CertainPageController", ['$scope', 'dashboardService', function ($scope, dashboardService) {

    $scope.showPreloader = true;
    $scope.certainPage = "Angular Has Passed to Page.";

    $scope.computerAssembly = {};
    dashboardService.getComputerProducts(
        function (result) {
            $scope.showPreloader = false;

            var compData = result.data;
            $scope.decoratorProductsNames = compData['Computer-bases'];

            $scope.hardDisks = [];
            $scope.processors = [];
            $scope.videoCards = [];
            angular.forEach(compData['Computers-parts'], function (vdalue, key) {
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
        /*send request and create model object*/

    };

}]);

