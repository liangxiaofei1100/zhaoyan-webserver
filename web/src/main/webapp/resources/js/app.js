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
        .state('userinfo',{
            url:"/userinfo",
            templateUrl:"resources/tpls/userinfo.html",
        })
});