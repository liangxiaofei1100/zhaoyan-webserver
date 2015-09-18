// 作为启动点的js
var zhaoyanApp = angular.module('ZhaoyanApp', ['Controllers', 'ui.router']);

zhaoyanApp.config(function ($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /home
    $urlRouterProvider.otherwise("/home");

    // Now set up the states
    $stateProvider
        .state('home', {
            url:"/home",
            templateUrl:"resources/tpls/home.html"
        })
        .state('home.list', {
            url:"/list",
            templateUrl:"resources/tpls/home.list.html",
            controller: function($scope) {
                $scope.items = ["A", "List", "Of", "Items"];
            }
        })
        .state('product',{
            url:"/product",
            templateUrl:"resources/tpls/product.html"
        })
        .state('product.list',{
            url:"list",
            templateUrl:"resources/tpls/product.list.html",
            controller: function($scope) {
                $scope.things = ["A", "Set", "Of", "Things"];
            }
        })
});