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
    this.getByTags = function(tags, callback) {
       var names = [];
       for (var i=0, max=tags.length; i<max; i++) {
        names.push(tags[i].name);
       }
       $http.post('records/tags', {'names':names}).success(callback);
    };
    this.getTags = function(callback) {
       $http.get('records/toptags').success(callback);
    }
  }]);
