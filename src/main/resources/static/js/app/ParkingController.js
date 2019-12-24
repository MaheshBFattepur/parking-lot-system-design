'use strict'

var module = angular.module('parking.controller', []);
module.controller("ParkingController", [
		"$scope",
		"ParkingService",
		function($scope, ParkingService) {

			$scope.vehicleNumber = null;
			$scope.vehicleType = null;
			$scope.ticketId = null;

			$scope.generatePrice = function() {
				var Favs = ParkingService.generatePrice($scope.ticketId)
				Favs.then(function() {

					$scope.price_res_data = JSON
							.stringify(Favs.$$state.value[0].data);

					console.log("W: "
							+ JSON.stringify(Favs.$$state.value[0].data));

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.generateTicket = function() {
				var Favs = ParkingService.generateTicket($scope.vehicleNumber,
						$scope.vehicleType)
				Favs.then(function() {

					$scope.res_data = JSON
							.stringify(Favs.$$state.value[0].data);
					console.log("W: "
							+ JSON.stringify(Favs.$$state.value[0].data));

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);