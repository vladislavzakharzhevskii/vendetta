myApp.controller("ProductController", ['$rootScope', '$scope', 'ProductService',
    function ($rootScope, $scope, service) {

        $scope.products = [];
        $scope.productValidation = {};
        $scope.productModel = {
            productImages: []
        };


        $scope.getComputers = function () {

            service.getComputers(function (response) {
                $scope.products = response.data;
                $scope.openModal = true;
            }, function (response) {});
        };

        // INIT call
        $scope.getComputers();



        $scope.addEditProduct = function (editableProduct) {
            //clear model when opens after product was added
            $scope.productModel = {}; $scope.previewImages = [];

            /*init*/
            $('#modal1').modal({
                dismissible: false,
                opacity: .5
            });
            /*open*/
            $('#modal1').modal('open');


            if(editableProduct) {

                $scope.productModel = {
                    pk: editableProduct.pk,
                    name: editableProduct.name,
                    type: editableProduct.type,
                    description: editableProduct.description,
                    cost: editableProduct.cost,
                    productImages: editableProduct.productImages
                };

                $scope.previewImages = editableProduct.productImages;
            }
        };


        $scope.saveProduct = function () {


            $scope.formData = new FormData();

            //add productImages to FormData
            for(var i = 0; i < $scope.productModel.productImages.length; i++) {
                $scope.formData.append("files[]", $scope.productModel.productImages[i], $scope.productModel.productImages[i].name);
            }

            //add product data to FormData
            if(angular.isDefined($scope.productModel.pk))
                $scope.formData.set("productPk", $scope.productModel.pk);
            $scope.formData.set("productName", $scope.productModel.name);
            $scope.formData.set("productDescription", $scope.productModel.description);
            $scope.formData.set("productCost", $scope.productModel.cost);


            service.saveProduct($scope.formData, function () {
                $scope.productModel = {};

                /*clear value in text*/
                $('#files-name-holder').val('');

                $('#modal1').modal('close');
                //update view
                $scope.getComputers();
            },function () {});


        };


        $scope.deleteProduct = function (productPK, productName) {
            service.deleteProduct(productPK, function () {
                Materialize.toast("Product: '" + productName + "' has deleted." , 6000);
                $scope.getComputers();
            }, function (response) {

            });
        };

        $scope.deleteProductImage = function (image) {
            service.deleteProductImage(image.pk, function successCallback() {
                Materialize.toast("Product Image Has Deleted." , 6000);
                var popupImageIdx = $scope.previewImages.indexOf(image);
                $scope.previewImages.splice(popupImageIdx, 1);
            }, function failure() {

            });
        };


    }]);
