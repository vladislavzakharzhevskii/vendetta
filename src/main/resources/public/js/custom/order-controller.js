

myApp.controller("OrderController", ['$rootScope', '$scope', 'computerService', '$filter', 'OrderService',
    function ($rootScope, $scope, computerService, $filter, orderService) {

        $scope.order = {
            user: {},
            base: {},
            additional: []
        };


        $scope.showOrderPopup = function () {
            $('#orderModal').modal({
                dismissible: false,
                opacity: .5
            });
            $('#orderModal').modal('open');
        };

        /* declare method to get data to order popup*/
        $scope.getOrderPopupData = function () {
            computerService.getParsedComputers(function (response) {
                $scope.parsedComputersData = response.data;
            }, function (response) {});
        };

        /*get popup data*/
        $scope.getOrderPopupData();





        $scope.getTotalCost = function () {
            var cost = 0;

            angular.forEach($scope.order.additional, function (part, idx) {
                cost = cost + part.cost;
            });

            cost = cost + $scope.order.base.cost || 0;

            return cost;
        };

        /* SUBMIT FUNCTION */
        $scope.submitOrder = function () {
            var preparedOrderData = {
                user: $scope.order.user,
                baseComponentId: $scope.order.base.pk,
            };

            /*get additional parts id's*/
            var addPks = [];
            angular.forEach($scope.order.additional, function (value, key) {
                addPks.push(value.pk);
            });

            preparedOrderData.additionalComponentsIds = addPks;

            orderService.submitOrder(preparedOrderData, function (response) {
                $('#orderModal').modal('close');
            }, function (response) {


            });
        };


}]);
