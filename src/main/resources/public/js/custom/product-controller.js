myApp.controller("ProductController", ['$rootScope', '$scope', 'ProductService',
    function ($rootScope, $scope, service) {

        $scope.computers = [];
        $scope.computerModel = {};



        $scope.getComputers = function () {
            $rootScope.general.showPreloader = true;

            service.getComputers(function (response) {
                $rootScope.general.showPreloader = false;
                $scope.computers = response.data;
                $scope.openModal = true;
            }, function (response) {});
        };

        // INIT call
        $scope.getComputers();



        $scope.addEditProduct = function (editableProduct) {
            /*clean model*/
            $scope.computerModel = {};

            /*init*/
            $('#modal1').modal({
                dismissible: false,
                opacity: .5
            });
            /*open*/
            $('#modal1').modal('open');


            if(editableProduct) {

                $scope.computerModel = {
                    pk: editableProduct.pk,
                    name: editableProduct.name,
                    type: editableProduct.type,
                    description: editableProduct.description,
                    cost: editableProduct.cost
                };
            }
        };





        $scope.saveProduct = function () {
            $rootScope.general.showPreloader = true;



            service.saveComputer($scope.computerModel, function (response) {
                $rootScope.general.showPreloader = false;
                $scope.computerModel = {};
                $('#modal1').modal('close');
                //update view
                $scope.getComputers();

            }, function (response) {
                $rootScope.general.showPreloader = false;
            });
        };


        $scope.deleteProduct = function (productPK, productName) {
            service.deleteProduct(productPK, function (response) {
                Materialize.toast("Product: '" + productName + "' has deleted." , 6000);
                $scope.getComputers();
            }, function (response) {

            });
        };


    }]);
