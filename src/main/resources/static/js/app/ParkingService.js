'use strict'

angular.module('parking.services', [])
		.factory(
				'ParkingService',
				[
						"$http",
						"$q",
						"CONSTANTS",
						function($http, $q, CONSTANTS) {
							var service = {};
							service.generatePrice = function(ticketId) {
								var url = CONSTANTS.generatePrice + ticketId;

								var promise1 = $http.get(url);
								var deferred = $q.defer();
								return $q.all([ promise1 ]).then(
										function(response) {
											// promise is fulfilled
											deferred.resolve(response);
											// promise is returned
											return deferred.promise;
										}, function(response) {
											// the following line rejects the
											// promise
											deferred.reject(response);
											// promise is returned
											return deferred.promise;
										});

							}
							service.generateTicket = function(vehicleNumber,
									vehicleType) {
								console.log(vehicleNumber + ", " + vehicleType)
								var url = CONSTANTS.createTicket
										+ "?vehicleNumber=" + vehicleNumber
										+ "&vehicleType=" + vehicleType;

								var promise1 = $http.post(url);
								var deferred = $q.defer();
								return $q.all([ promise1 ]).then(
										function(response) {
											// promise is fulfilled
											deferred.resolve(response);
											// promise is returned
											return deferred.promise;
										}, function(response) {
											// the following line rejects the
											// promise
											deferred.reject(response);
											// promise is returned
											return deferred.promise;
										});
							}
							return service;
						} ]);