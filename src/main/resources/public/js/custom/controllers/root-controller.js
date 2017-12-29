
/*USE THIS CONTROLLER TO EXECUTE COMMON PART*/


myApp.controller("RootController", ['$scope', 'ProductService', function ($scope, service) {




        $scope.getOrderStatusColor = function (status) {
            if (status === 'NEW') {
                return "blue";
            } else {
                if (status === 'COMPLETED') {
                    return "green";
                }
                else {
                    if (status === 'IN_DELIVERING') {
                        return 'yellow';
                    } else {
                        if (status === 'EXPIRED' || status === 'DISRUPTED') {
                            return 'red';
                        }

                    }
                }
            }
        };




    }
]);