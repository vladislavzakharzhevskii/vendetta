

myApp.controller("OrderController", ['$rootScope', '$scope', 'Utils', 'ProductService', '$filter', 'OrderService', 'OrderServiceUtil',
    function ($rootScope, $scope, appUtils, productService, $filter, orderService, orderServiceUtil) {

        var currentTimeDate = new Date();
        $scope.order = {
            selectedProducts: [],
            temp: {}
        };

        var getOrders = function () {

            orderService.getOrders(function (response) {

                $scope.orders = response.data.orders;

                var receiveRequests = response.data.receiveRequests;
                if (receiveRequests) {
                    checkOrdersReceiveFromClient(receiveRequests);
                }


            }, function (response) {});
        };



        getOrders();




        var checkOrdersReceiveFromClient = function (receiveRequests) {

            orderServiceUtil.confirmReceive(receiveRequests, Object.keys(receiveRequests), 0,
                function changeStatusToComplete(orderId) {
                    var complete_status = 'COMPLETED';
                    orderService.changeOrderStatus(orderId, complete_status);
                    $filter('filter')($scope.orders, {pk: orderId})[0].orderStatus = complete_status;
                },
                function changeStatusToDisrupted(orderId) {
                    var disrupted_status = 'DISRUPTED';
                    orderService.changeOrderStatus(orderId, disrupted_status);
                    $filter('filter')($scope.orders, {pk: orderId})[0].orderStatus = disrupted_status;

                }
            );
        };




        $scope.showOrderPopup = function () {

            $('#orderModal').modal({
                dismissible: false,
                opacity: .5
            });

            /*get products to show into modal*/
            /*todo rename method*/
            productService.getComputers(function (response) {

                /*Set Up Delivery Time and Date*/
                var current = new Date();
                $scope.order.deliveryDate = new Date(current.getFullYear(), current.getMonth(), current.getDate());
                current.setTime(current.getTime() + (60 * 60 * 1000));
                $scope.order.temp = {deliveryTime: appUtils.formatAMPM(current)};


                $scope.orderProductData = response.data;
                $('#orderModal').modal('open');
            }, function (response) {});

        };







        $scope.getTotalCost = function () {
            var cost = 0;

            angular.forEach($scope.order.selectedProducts, function (selectedItem) {
                cost = cost + selectedItem.cost;
            });

            return cost;
        };

        /* SUBMIT FUNCTION */
        $scope.submitOrder = function () {

            var preparedOrderData = angular.copy($scope.order);

            preparedOrderData.products = [];

            /*copy products pk's into array*/
            angular.forEach($scope.order.selectedProducts, function (product) {
                preparedOrderData.products.push(product.pk);
            });
            delete preparedOrderData['selectedProducts'];


            preparedOrderData.deliveryDate = getDateWithTime($scope.order.deliveryDate, $scope.order.temp.deliveryTime);
            delete preparedOrderData['temp'];


            orderService.submitOrder(preparedOrderData, function () {
                $('#orderModal').modal('close');
                $scope.order = {};
                getOrders();
            }, function () {
                $scope.order = {};

            });
        };


        var getDateWithTime = function (date, PMAMTimeValue) {

            var convertedTime = appUtils.convertTimeTo24Hour(PMAMTimeValue);

            date.setTime(date.getTime() + (convertedTime.hours * 60 * 60 * 1000) + (convertedTime.minutes * 60 * 1000));

            return date.getTime();
        };


        $scope.defineDelivery = function (orderPk) {

            orderService.changeOrderStatus(orderPk, 'IN_DELIVERING',
                function successCallback() {
                    $filter('filter')($scope.orders, {pk: orderPk})[0].orderStatus = 'IN_DELIVERING';},
                function errorCallback(response) {});
        };




}]);
