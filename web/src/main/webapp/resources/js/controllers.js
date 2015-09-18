var controllers = angular.module('Controllers', []);

controllers.controller('GreetingController', function ($scope, $http) {
        $http({method: 'GET', url: 'common/greeting'}).
            success(function (data, status, headers, config) {
                // alert("Success:"+JSON.stringify(data));
                $scope.greeting = data;
            }).
            error(function (data, status, headers, config) {
                // alert("Error:"+data);
            });
    }
)