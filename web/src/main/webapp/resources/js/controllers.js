var controllers = angular.module('Controllers', []);

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

controllers.controller('ProductList', function ($scope, $http) {
    $http({method: 'GET', url: 'product/list'})
        .success(function (data, status, headers, config) {
            //alert("Success:" + JSON.stringify(data));
            $scope.productList = data.productList;

        })
        .error(function (data, status, headers, config) {
            //alert("Error:" + data);
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

controllers.controller('Test', function ($scope) {
    var testJson = {
        name : "Test name",
        message : "Test message"
    }
    var testJsonString = angular.toJson(testJson, false);



    $scope.str = testJsonString;
});
