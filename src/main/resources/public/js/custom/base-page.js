

myApp.controller("CertainPageController", ['$scope', 'dashboardService', function ($scope, dashboardService) {

    $scope.showPreloader = false;

    $scope.page = {htmlPage: 'dashboard'};

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

    $scope.threadTimes = [3,5,10,30,60];
    $scope.thread = {simpleThreadWorkingTime: ''};


    $scope.startSimpleThread = function () {
        $scope.thread.showThreadPreLoader = true;
        $scope.thread.message = '';

        dashboardService.startSimpleThreadRequest($scope.thread.simpleThreadWorkingTime, function successCallback(response) {
            $scope.thread.showThreadPreLoader = false;
            $scope.thread.message = "<br><span><i class='material-icons'>check</i></span><span>Take a look into server console.</span>"
        },function errorCallback(response) {
            $scope.thread.showThreadPreLoader = false;
            $scope.thread.message = "<br><span class='new badge red' data-badge-caption=''>Error</span><span>Check Browser and Server logs.</span>"

        });
    };


}]);

