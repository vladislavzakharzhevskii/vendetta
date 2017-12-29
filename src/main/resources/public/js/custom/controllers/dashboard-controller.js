
angular.module("myApp").controller('DashboardController', ['$rootScope', '$scope', '$timeout', 'DashboardService',
    function ($rootScope, $scope, $timeout, dashboardService) {

        $scope.page = {
            selectedStatus: '',
            selectedClient: ''
        };


        dashboardService.getDashboardData(function success(response) {
            $scope.baseData = response.data;

            $scope.ordersStatuses = response.data.statuses.allStatuses;
            $scope.clients = response.data.clients.allClients;

            $scope.page.selectedStatus = angular.isDefined($scope.ordersStatuses) ? $scope.ordersStatuses[0] : '';
            $scope.page.selectedClient = angular.isDefined($scope.clients) ? $scope.clients[0] : '';

            //init by default with name $scope.orders;
            $scope.orders_status = response.data[$scope.page.selectedStatus];
            $scope.orders_client = response.data[$scope.page.selectedStatus];

        });

        $scope.$watch('page.selectedStatus', function (newOrderStatus) {
            if (newOrderStatus) {
                $rootScope.general.showPreloader = true;

                $scope.orders_status = null;
                /*recreate content table*/
                $timeout(function () {
                    $rootScope.general.showPreloader = false;
                    $scope.orders_status = $scope.baseData.statuses[newOrderStatus];
                }, 500);
            }
        });

        $scope.$watch('page.selectedClient', function (newClient) {
            if (newClient) {
                $rootScope.general.showPreloader = true;

                $scope.orders_client = null;
                /*recreate content table*/
                $timeout(function () {
                    $rootScope.general.showPreloader = false;
                    $scope.orders_client = $scope.baseData.clients[newClient];
                }, 500);
            }
        });

}]);