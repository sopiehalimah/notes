angular.module("aplikasiSpringboot")
        .controller('navbarController', function ($scope, homeService) {
            homeService.getLoggedIn().success(function (data) {
                $scope.user = data;
            });
          });