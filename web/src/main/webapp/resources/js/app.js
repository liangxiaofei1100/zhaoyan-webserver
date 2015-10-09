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
        .state('product',{
            url:"/product",
            templateUrl:"resources/tpls/product.html"
        })
        .state('product_detail',{
            url:"/product_detail",
            templateUrl:"resources/tpls/product_detail.html"
        })
        .state('userinfo',{
            url:"/userinfo",
            templateUrl:"resources/tpls/userinfo.html",
        })
        .state('add_product', {
            url: '/add_product',
            templateUrl: 'resources/tpls/add_product.html'
        })
        .state('test', {
            url:'/test',
            templateUrl: 'resources/tpls/test.html'
        })
});