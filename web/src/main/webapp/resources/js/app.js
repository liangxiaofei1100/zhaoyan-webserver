// 作为启动点的js
var zhaoyanApp = angular.module('ZhaoyanApp', ['Controllers', 'ui.router']);

// ui router config.
zhaoyanApp.config(function ($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /home
    $urlRouterProvider.otherwise("/home");

    // Now set up the states
    $stateProvider
        .state('home', {
            url: "/home",
            templateUrl: "resources/tpls/home.html"
        })
        .state('product', {
            url: "/product",
            templateUrl: "resources/tpls/product.html"
        })
        .state('product_view', {
            url: "/product_view/:productId",
            templateUrl: "resources/tpls/product_view.html"
        })
        .state('product_add', {
            url: '/product_add',
            templateUrl: 'resources/tpls/product_add.html'
        })
        .state('userinfo', {
            url: "/userinfo",
            templateUrl: "resources/tpls/userinfo.html",
        })
        .state('test', {
            url: '/test',
            templateUrl: 'resources/tpls/test.html'
        })
});