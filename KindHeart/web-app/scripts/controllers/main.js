'use strict';

/**
 * @ngdoc function
 * @name testApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the testApp
 */
angular.module('testApp')
  .controller('MainCtrl', ['$scope', '$controller', 'dataService', function ($scope,  $controller, dataService) {

  	$.extend(this, $controller('BaseCtrl', {$scope: $scope}));

  	dataService.getAll(function(data) {
  		$scope.posts = data;
  	});

/*
	$scope.posts = [
		{
			msg: "sdfsdlfjsdlkj sdflkjd slkfjsdlkfjsldf jsdlfjsd lkfjsds",
			hashTags: ['#tag', '#tag2'],
			imageUrl: 'http://parikmaherov.net/upload/blogs/c382f3a82f299f64d591d01f900a2a87.jpg'
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
		}
	];

	if ($scope.tags) {}
*/
  }]);
