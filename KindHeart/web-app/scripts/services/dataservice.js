'use strict';

/**
 * @ngdoc service
 * @name testApp.dataService
 * @description
 * # dataService
 * Service in the testApp.
 */
angular.module('testApp')
  .service('dataService', ['$http', function ($http) {
/*
  	function errorHandler(data, status, headers, config) {
  		console.log(data);
  		console.log(status);
  	};
*/
  	this.getAll = function(callback) {
       $http.get('records').success(callback);
    };
  }]);
