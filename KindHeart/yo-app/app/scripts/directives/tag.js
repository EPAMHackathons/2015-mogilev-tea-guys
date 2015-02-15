'use strict';

/**
 * @ngdoc directive
 * @name testApp.directive:tag
 * @description
 * # tag
 */
angular.module('testApp')
  .directive('tag', function () {
    return {
      template: '<div>{{tag.name}}</div>',
      restrict: 'E',
      scope: {
      	tag: '=model'
      },
      link: function postLink(scope, element, attrs) {
      }
    };
  });
