angular.module('myApp').factory('OrderServiceUtil', ['$http', 'SweetAlert', '$timeout',
    function ($http, SweetAlert, $timeout) {

    var utilsData = {};




    utilsData.confirmReceive = function (receiveRequests, keys, index, callback, callback2) {

        var receiveRequest = receiveRequests[keys[index]];
        if(!receiveRequest) { return; }



        var items = "";
        angular.forEach(receiveRequest.products, function (product) {
            items += product.name + '; ';
        });

        $timeout(function () {

            SweetAlert.swal({
                    title: "Have you got this Order?",
                    text: items,
                    type: "success",
                    showCancelButton: true,
                    confirmButtonColor: "#33dd59",
                    confirmButtonText: "Yes. It is.",
                    cancelButtonText: "No. Get Take my Payment back!",
                    closeOnConfirm: true,
                    closeOnCancel: false
                },
                function(isConfirm){
                    if (isConfirm) {
                        utilsData.confirmReceive(receiveRequests, keys, index + 1, callback, callback2);
                        //send request to change status via callback
                        callback(receiveRequest.pk);
                    } else {
                        SweetAlert.swal({
                            title: "Your Complaint will be considered.",
                            text: "Sorry!",
                            type: "error"
                            },
                            function () {
                                utilsData.confirmReceive(receiveRequests, keys, index + 1, callback, callback2);
                                //send request to change status via callback
                                callback2(receiveRequest.pk);
                            });
                    }
                });
        }, 2000);


    };




        return utilsData;
    }]);






