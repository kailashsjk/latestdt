module.controller('roleController', function($scope, projectService, roleService){
	
	$scope.roles = [2,3,4,5,6,7];
	$scope.project= projectService.getProject();
	var pId = projectService.getProject().projectId;
	
	$scope.assignedRoles = function(selected, permissions){
		var found = false;
	        //console.log(selected+" user permission "+permissions);
		
	        angular.forEach(permissions, function(permission, index){
	            if (permission == selected){
	                found = true;
	                return;
	            }                        
	        });
	        return found;
	};
	
	$scope.userRoles = function(){
		roleService.gerUserRoles(pId, function(data){
			//console.log("getting data while page load : "+data);
			$scope.rows = data;
		});
	}
	
	$scope.toggleAssign = function(selected, row){
		var idx = row.indexOf(selected);
		 	
	    // is currently selected
	    if (idx > -1) {
	      row.splice(idx, 1);
	    }

	    // is newly selected
	    else {
	      row.push(selected);
	    }
	   /* console.log(row);*/
	}
	
	$scope.submitAssignRoles = function(rows){
		//console.log("submiting data while press submit : "+rows);
		roleService.submitRoles(pId,angular.toJson(rows), function(data){
			$scope.rows = data;
		})
	}
});