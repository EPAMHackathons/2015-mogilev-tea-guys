'use strict';

/**
 * @ngdoc directive
 * @name testApp.directive:tile
 * @description
 * # tile
 */
angular.module('testApp')
  .directive('tile', function () {
    return {
      template: '<div class="tile">' + 
      			'<div class="head">' + 
              '<a href="{{data.userProfileUrl}}">{{data.userName}}</a></div>' +
            '<div class="content">' + 
              '<img class="usr img-circle" ng-src="{{data.userPhotoUrl}}"/>' +
      				'<p class="msg">{{data.message}}</p>' +
      				'<div ng-show="data.imageUrl"><img ng-src="{{data.imageUrl}}"/>{{data.imageUrl}}</div>' + 
      			'</div></div></div>',
      restrict: 'E',
      scope: {
      	data: '=model',
      },
      link: function postLink(scope, element, attrs) {
      }
    };
  });
