module.controller('modalController',function($scope){
	$scope.showModal = false;
	$scope.toggleModal = function(){
				//$scope.buttonClicked = 'buttonClicked';
				$scope.showModal = !$scope.showModal;
				}
})