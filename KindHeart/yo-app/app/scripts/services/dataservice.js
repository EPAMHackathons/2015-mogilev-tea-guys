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
  	this.getAll = function(callback) {
       $http.get('records').success(callback);
    };
    this.getByTags = function(callback) {
       $http.get('tags').success(callback);
    }
  }]);
