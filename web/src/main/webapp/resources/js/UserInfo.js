var userInfoModule=angular.module('UserInfoModule',[]);

userInfoModule.controller('UserInfoCtrl', function($scope) {
    $scope.userInfo={
        email:"",
        password:"",
        autoLogin:false
    }
    $scope.getUserInfo=function() {
        console.log($scope.userInfo)
    }
    $scope.resetUserInfo=function() {
        $scope.userInfo={
            email:"",
            password:"",
            autoLogin:false
        }
    }
});