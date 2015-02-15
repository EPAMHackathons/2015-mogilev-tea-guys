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
      			'<div class="head">Tile Head</div>' +
      				'<p class="msg">{{data.msg}}</p>' +
      			'</div></div>',
      restrict: 'E',
      scope: {
      	data: '=model',
      },
      link: function postLink(scope, element, attrs) {
      }
    };
  });
