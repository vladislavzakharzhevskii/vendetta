

myApp.controller("OrderController", ['$rootScope', '$scope', 'ProductService', '$filter', 'OrderService',
    function ($rootScope, $scope, productService, $filter, orderService) {

        $scope.order = {
            base: {},
            additional: []
        };

        var getOrders = function () {
            orderService.getOrders(function (response) {
                $scope.orders = response.data;
            }, function (response) {});
        };

        getOrders();

        $scope.showOrderPopup = function () {
            $('#orderModal').modal({
                dismissible: false,
                opacity: .5
            });
            $('#orderModal').modal('open');
        };

        /* declare method to get data to order popup*/
        $scope.getOrderPopupData = function () {
            productService.getParsedComputers(function (response) {
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

            var preparedOrderData = angular.copy($scope.order);

            preparedOrderData.products = [];

            /*get base part id*/
            preparedOrderData.products.push($scope.order.base.pk);
            delete preparedOrderData['base'];


            /*get additional parts id's*/

            angular.forEach($scope.order.additional, function (value, key) {
                preparedOrderData.products.push(value.pk);
            });
            delete preparedOrderData['additional'];

            preparedOrderData.deliveryDate = getDateWithTime(preparedOrderData.deliveryDate, preparedOrderData.temp.deliveryTime);
            delete preparedOrderData['temp'];


            orderService.submitOrder(preparedOrderData, function (response) {
                $('#orderModal').modal('close');
                getOrders();
            }, function (response) {


            });
        };


        var getDateWithTime = function (dateAsString, timeAsString) {

            var resStringFullDate = dateAsString + 'T' + timeAsString + ":00";/*TODO FIND MORE CONVENIENT WAY*/

            var date = new Date(resStringFullDate);

            date.setTime(date.getTime() + (date.getTimezoneOffset() * 60 * 1000)); /*TODO IS IT TO MORE CONVENIENT WAY TO SET TimeZone*/

            return date.getTime();
        };


}]);
