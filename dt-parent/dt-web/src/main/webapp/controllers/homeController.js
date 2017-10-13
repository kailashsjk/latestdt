module.controller('homeController', function($scope, $state) {
	$scope.goToProjects = function() {
		$state.go('home.projects');
		//$state.reload();
	}
	$scope.tabs = [ {
		title : 'Understand',
		url : 'one.tpl.html'
	}, {
		title : 'Ideate',
		url : 'two.tpl.html'
	}, {
		title : 'Experiment',
		url : 'three.tpl.html'
	} ];

	$scope.currentTab = 'one.tpl.html';

	$scope.onClickTab = function(tab) {
		$scope.currentTab = tab.url;
	}

	$scope.isActiveTab = function(tabUrl) {
		return tabUrl == $scope.currentTab;
	}
	$scope.showModal = false;
	$scope.toggleModal = function(){
		//$scope.buttonClicked = 'buttonClicked';
		$scope.heading = "Understand";
		$scope.showModal = !$scope.showModal;
		}
	$scope.showModal1 = false;
	$scope.toggleModal1 = function(){
		//$scope.buttonClicked = 'buttonClicked';
		$scope.heading = "Ideate";
		$scope.showModal1 = !$scope.showModal1;
		}
	$scope.showModal2 = false;
	$scope.toggleModal2 = function(){
		//$scope.buttonClicked = 'buttonClicked';
		$scope.heading = "Experiment";
		$scope.showModal2 = !$scope.showModal2;
		}
})