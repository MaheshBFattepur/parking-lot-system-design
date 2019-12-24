'use strict'

var demoApp = angular.module('parking', [ 'ui.bootstrap', 'parking.controller',
		'parking.services' ]);
demoApp.constant("CONSTANTS", {
	createTicket : "/api/createTicket",
	generatePrice : "/api/generatePrice/"
});