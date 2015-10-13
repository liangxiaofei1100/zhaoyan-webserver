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
    $http({method: 'GET', url: 'product/list'})
        .success(function (data, status, headers, config) {
            // console.log("ProductList, Success:" + JSON.stringify(data));
            $scope.productList = data.productList;

        })
        .error(function (data, status, headers, config) {
            console.log("ProductList, Error:" + data);
        });
    $scope.viewProduct = function(productId) {
        console.log("viewProduct(), productId=" + productId);
        $state.go("product_view", { productId: productId });
    };

    $scope.editProduct = function(productId) {
        console.log("editProduct(), productId=" + productId);
        $state.go("product_edit", { productId: productId });
    };

    $scope.deleteProduct = function(productId) {
        console.log("deleteProduct(), productId=" + productId);
    }
});

// 商品详情
controllers.controller('ProductView', function($scope, $http, $state, $stateParams, $window) {
    var productId = $stateParams.productId;
    console.log("ProductView, productId=" + productId);

    $scope.goBack = function() {
        console.log("goBack()")
        $window.history.back();
    };
});

// 编辑商品
controllers.controller('ProductEdit', function($scope, $http, $stateParams) {
    var productId = $stateParams.productId;
    console.log("ProductEdit, productId=" + productId)

    $scope.productId = productId;
});

// 添加商品
controllers.controller('AddProdcutCtrl', function ($scope, $http) {
    resetFormData();

    $scope.resetFormData = function () {
        console.log("AddProdcutCtrl resetFormData");
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
        console.log($scope.product)

        var addProductRequest = {
            product: $scope.product
        }

        $http.post('product/addProduct', addProductRequest)
            .success(function (data, status, headers, config) {
                console.log(data);
                $scope.greeting = data;
            })
            .error(function (data, status, headers, config) {
                console.log(data)
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
        console.log($scope.userInfo)
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
        name : "Test name",
        message : "Test message"
    }
    var testJsonString = angular.toJson(testJson, false);



    $scope.str = testJsonString;
});
