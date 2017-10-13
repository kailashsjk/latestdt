module.controller('ideaFeedbackController', function($scope, $location){
    $scope.items = [{
	        id: 'id-1',
	        name: 'Mr'},
	    {
	        id: 'id-2',
	        name: 'Mrs'},
	    {
	        id: 'id-3',
            name: 'Ms'}];
    $scope.prototyping = function(){
        $location.path("/prototyping");
    }
});