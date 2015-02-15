'use strict';

/**
 * @ngdoc function
 * @name testApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the testApp
 */
angular.module('testApp')
  .controller('MainCtrl', function ($scope) {
    $scope.posts = [
    	{
			msg: "sdfsdlfjsdlkj sdflkjd slkfjsdlkfjsldf jsdlfjsd lkfjsds",
			hashTags: ['#tag', '#tag2'],
		},
		{
			msg: "hello world",
			hashTags: ['#tag', '#tag2'],
		},
		{
			msg: "hello world sdfsdjfsldkfj lkdjflk sjdfs sfdsdfs ",
			hashTags: ['#tag', '#tag2'],
		},
		{
			msg: "hello world",
			hashTags: ['#tag', '#tag2'],
		},
		{
			msg: "hello world sdfjkfs j ljfedlkhj sldkfj slkjs ",
			hashTags: ['#tag', '#tag2'],
		},
		{
			msg: "hello world",
			hashTags: ['#tag', '#tag2'],
		},
		]
  });
