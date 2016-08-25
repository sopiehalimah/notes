angular.module('aplikasiSpringboot', ['ngRoute'])
	.config(function($routeProvider){
		$routeProvider
                        .when('/dashboard',{
				'templateUrl': 'views/dashboard.html',
				'controller': 'homeController'
			})
			.when('/home',{
				'templateUrl': 'views/home.html',
				'controller': 'homeController'
			})
                        .when('/admin',{
				'templateUrl': 'views/admin.html',
				'controller': 'homeController'
			});
                        
	});
