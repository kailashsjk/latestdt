module.controller('menuController', function($scope, $state, $timeout, projectService, userService){
    //var val = "";
	//$scope.isFacilitator = true;
	$scope.isActive = function(viewLocation){
        return $state.is(viewLocation);
    };
    
    var stage = projectService.getStage();
    
    $scope.isDisable = function(number){
    	var diff = stage.projectStageID-number;
    	if(diff < 0)
    		return true;
    	else
    		return false;
    };
    
    $scope.isFacilitator = false;
    $scope.initFacilitator = function(){
    	/*console.log("init facilitator : "+userService.getUserPermission()[0]);
    	
    	if(userService.getUserPermission() != null){
    		var permissionData = userService.getUserPermission()[0].permissions;
    		angular.forEach(permissionData, function(permission, index){
    			if (permission.indexOf('Facilitator') >= 0){
                   // found = true;
    				$scope.isFacilitator = true;
                    return;
                }
    		});
    	}*/	
    	
    	/*if(userService.getAllAccess()== null){
    		$scope.initFacilitator();
    	}
    	else if(userService.getAllAccess() == true){
    		$scope.isFacilitator = userService.getAllAccess();
    	}*/
    	
    		$scope.isFacilitator = userService.getAllAccess();
    	
    }
   
    /*$scope.isFacilitator = function(){//alert("in facilitator");
    	var roles = userService.getUserPermission()[0].permissions;
    	var found = false;
	        alert(" user permission "+roles);
	        angular.forEach(roles, function(role, index){
	            if (role.indexOf('Facilitator') >= 0){
	                found = true;
	                return;
	            }                        
	        });
	        return found;
    }*/
})