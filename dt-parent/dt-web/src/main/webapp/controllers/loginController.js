var g_temp_data = false;
module.controller("loginController", function($scope, $state, userService, loginService){
	$scope.error = false;
	$scope.home = function(){
		loginService.authenticate($scope.userId, $scope.password, function(data){
			//alert("login auth service call"+ data);
			if(data != ""){
				userService.setUser(data);
				$state.go("home");}
			else{
				$scope.error = true;
			}	
		});
		//putting static values for logged in user. As in this case all logged in users are 'Bablu'
		/*var user = { name: "Bablu",
					 projectId: 1,
				     permissions: ['facilitator', 'empathizer']};*/
		
	};
})