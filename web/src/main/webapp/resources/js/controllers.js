var controllers = angular.module('Controllers', []);

// 首页
controllers.controller('GreetingController', function ($scope, $http) {
    $http({method: 'GET', url: 'common/greeting'})
        .success(function (data, status, headers, config) {
            // alert("Success:"+JSON.stringify(data));
            $scope.greeting = data;
        })
        .error(function (data, status, headers, config) {
            // alert("Error:"+data);
        });
});

controllers.controller('TimeController', function ($scope) {
    $scope.clock = {
        now: new Date()
    };
    var updateClock = function () {
        $scope.clock.now = new Date();
    };
    setInterval(function () {
        $scope.$apply(updateClock);
    }, 1000);

    updateClock();
});

// 商品列表
controllers.controller('ProductList', function ($scope, $http, $state) {
    getProductList();

    // 查看商品详情
    $scope.viewProduct = function (productId) {
        log("viewProduct(), productId=" + productId)
        $state.go("product_view", {productId: productId});
    };
    // 编辑商品
    $scope.editProduct = function (productId) {
        log("editProduct(), productId=" + productId)
        $state.go("product_edit", {productId: productId});
    };
    // 删除商品
    $scope.deleteProduct = function (productId) {
        log("deleteProduct(), productId=" + productId);

        //confirm("删除商品, ID: " + productId)
        deleteProduct(productId);
    }

    /**
     * 发送请求，获得商品列表
     */
    function getProductList() {
        $http({method: 'GET', url: 'product/list'})
            .success(function (data, status, headers, config) {
                // console.log("ProductList, Success:" + JSON.stringify(data));
                $scope.productList = data.productList;

            })
            .error(function (data, status, headers, config) {
                log("ProductList, Error:" + data)
            });
    }

    /**
     * 发送请求，删除商品
     * @param productId
     */
    function deleteProduct(productId) {
        var deleteProductRequest = {
            productId : productId
        }
        $http.post('product/delete', deleteProductRequest)
            .success(function (data, status, headers, config) {
                log(data);
                // 重新加载数据
                getProductList();
            })
            .error(function (data, status, headers, config) {
                log(data)
            });
    }
});

// 商品详情
controllers.controller('ProductView', function ($scope, $http, $state, $stateParams, $window) {
    var productId = $stateParams.productId;
    console.log("ProductView, productId=" + productId);

    $http.get('product/view/' + productId)
        .success(function (data, status, headers, config) {
            log(data);
            $scope.product = data.product;
        })
        .error(function (data, status, headers, config) {
            log(data)
        });

    $scope.goBack = function () {
        $window.history.back();
    };
});

// 编辑商品
controllers.controller('ProductEdit', function ($scope, $http, $stateParams) {
    var productId = $stateParams.productId;
    log("ProductEdit, productId=" + productId)

    $scope.productId = productId;
});

// 添加商品
controllers.controller('AddProdcutCtrl', function ($scope, $http) {
    resetFormData();

    $scope.resetFormData = function () {
        log("AddProdcutCtrl resetFormData");
        resetFormData();
    }

    function resetFormData() {
        $scope.product = {
            name: "",
            description: "",
            number: ""
        }
    }

    $scope.commit = function () {
        log($scope.product)

        var addProductRequest = {
            product: $scope.product
        }

        $http.post('product/addProduct', addProductRequest)
            .success(function (data, status, headers, config) {
                log(data);
                $scope.greeting = data;
            })
            .error(function (data, status, headers, config) {
                log(data)
            });
    }
});


// 用户信息
controllers.controller('UserInfoCtrl', function ($scope) {
    $scope.userInfo = {
        email: "",
        password: "",
        autoLogin: false
    }
    $scope.getUserInfo = function () {
        log($scope.userInfo)
    }
    $scope.resetUserInfo = function () {
        $scope.userInfo = {
            email: "",
            password: "",
            autoLogin: false
        }
    }
});

// 测试
controllers.controller('Test', function ($scope) {
    var testJson = {
        name: "Test name",
        message: "Test message"
    }
    var testJsonString = angular.toJson(testJson, false);

    $scope.str = testJsonString;
});

function log(msg) {
    console.log(msg)
}