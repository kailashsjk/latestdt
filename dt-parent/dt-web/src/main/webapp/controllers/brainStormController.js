module.controller('brainStormController', function($scope, $location){
    $scope.goToIdeas = function(){
        $location.path('/ideas');
    }
})