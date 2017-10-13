module.controller('projectController', function($scope, projectService, $state, userService, Auth) {
	
	var userId= userService.getUser().id;
	$scope.projectCreateError1=false;
	$scope.projectCreateError2=false;
	$scope.projectCreateError3=false;
	$scope.projectCreateError4=false;
	$scope.projectUpdateError1=false;
	$scope.projectUpdateError2=false;
	$scope.projectUpdateError3=false;
	$scope.projectUpdateError4=false;
	$scope.projId = "";
	
	$scope.hasRole = function(anyRole){
		var user = userService.getUser();
		//alert(user.id+" $$ "+project.user.id);
		if(anyRole == true){
			return true;
		}
		else{
			return false;
		}
	};
	$scope.isFacilitator = function(facilitator){
		var user = userService.getUser();
		//alert(user.id+" $$ "+project.user.id);
		if(facilitator == true){
			return true;
		}
		else{
			return false;
		}
	};
	$scope.editingData = {};
	$scope.editProject = {};
	$scope.showFlag = true;
	$scope.getProjects = function() {
		$scope.showFlag = !$scope.showFlag;
		projectService.getdata(userId,function(data) {
			$scope.allProjects = data;
			for (var i = 0, length = $scope.allProjects.length; i < length; i++) {
				$scope.editingData[$scope.allProjects[i].projectId] = false;
			}
		})
	};

	$scope.getActiveProjects = function() {
		$scope.showFlag = !$scope.showFlag;
		projectService.getActivedata(userId,function(data) {
			$scope.allProjects = data;
			for (var i = 0, length = $scope.allProjects.length; i < length; i++) {
				$scope.editingData[$scope.allProjects[i].projectId] = false;
			}
		})
	};
	$scope.addProject = function() {
		if($scope.projectName != "" && $scope.projectName != null && $scope.ibuName != "" && $scope.ibuName != null && $scope.accountName != "" && $scope.accountName != null && $scope.researchtAgenda != "" && $scope.researchtAgenda != null){
			projectService.addProject($scope.projectName,$scope.projId,$scope.ibuName,$scope.accountName,$scope.researchtAgenda,userService.getUser(),
					function() {
						$scope.show = !$scope.show;
						$scope.getActiveProjects();
						$scope.projectName = "";
						$scope.researchtAgenda = "";
						$scope.ibuName="";
						$scope.accountName="";
						$scope.projId = "";
						$scope.projectCreateError1=false;
						$scope.projectCreateError2=false;
						$scope.projectCreateError3=false;
						$scope.projectCreateError4=false;
					});
		}
		
		if($scope.projectName == "" || $scope.projectName == null){
			$scope.projectCreateError1=true;
		}else{
			$scope.projectCreateError1=false;
		}
		if($scope.ibuName == "" || $scope.ibuName == null){
			$scope.projectCreateError2=true;
		}else{
			$scope.projectCreateError2=false;
		}
		if($scope.accountName == "" || $scope.accountName == null){
			$scope.projectCreateError3=true;
		}else{
			$scope.projectCreateError3=false;
		}
		if($scope.researchtAgenda == "" || $scope.researchtAgenda == null){
			$scope.projectCreateError4=true;
		}else{
			$scope.projectCreateError4=false;
		}
	};

	$scope.cancelCreateProject=function(){
		$scope.show= false;
		$scope.projectCreateError1=false;
		$scope.projectCreateError2=false;
		$scope.projectCreateError3=false;
		$scope.projectCreateError4=false;
		$scope.projectName = "";
		$scope.researchtAgenda = "";
		$scope.ibuName="";
		$scope.accountName="";
		$scope.projId = "";
	}

	$scope.modify = function(project) {
		$scope.editingData[project.projectId] = true;
	};
/*	$scope.deactivate = function(id) {
		projectService.deactivate(id, function(data){
			projectService.getdata(function(data) {
				$scope.projects = data;
				for (var i = 0, length = $scope.projects.length; i < length; i++) {
					$scope.editingData[$scope.projects[i].projectId] = false;
				}
			});
			});
	};*/
	
	$scope.deactivate = function(id) {
		//alert($scope.showFlag);
			
			projectService.deactivate(id, function(){
				if($scope.showFlag == false){
					//alert("Inisde if");
				projectService.getActivedata(userId,function(data) {
					//alert("Inisde if,after service");
					$scope.allProjects = data;
					for (var i = 0, length = $scope.projects.length; i < length; i++) {
						$scope.editingData[$scope.projects[i].projectId] = false;
					}
				});
				}
				else if($scope.showFlag == true){
					//alert("Inisde else");
					projectService.getdata(userId,function(data) {
						//alert("Inisde else,after service");
						$scope.allProjects = data;
						for (var i = 0, length = $scope.projects.length; i < length; i++) {
							$scope.editingData[$scope.projects[i].projectId] = false;
						}
					});
					
				}
				});
		}
	
	
	
	$scope.updateProject = function(project) {
		$scope.editingData[project.projectId] = false;
		
		if($scope.editProject.projectName != "" && $scope.editProject.projectName != null && $scope.editProject.ibuName != "" && $scope.editProject.ibuName != null && $scope.editProject.accountName != "" && $scope.editProject.accountName != null && $scope.editProject.researchAgenda != "" && $scope.editProject.researchAgenda != null){
			projectService.updateProject(project, function(data){
				$scope.getActiveProjects();
			});
			$scope.showEdit=false;
			$scope.projectUpdateError1=false;
			$scope.projectUpdateError2=false;
			$scope.projectUpdateError3=false;
			$scope.projectUpdateError4=false;
		}
		if($scope.editProject.projectName == "" || $scope.editProject.projectName == null){
			$scope.projectUpdateError1=true;
		}else{
			$scope.projectUpdateError1=false;
			}
		if($scope.editProject.ibuName == "" || $scope.editProject.ibuName == null){
			$scope.projectUpdateError2=true;
		}else{
			$scope.projectUpdateError2=false;
			}
		if($scope.editProject.accountName == "" || $scope.editProject.accountName == null){
			$scope.projectUpdateError3=true;
		}else{
			$scope.projectUpdateError3=false;
			}
		if($scope.editProject.researchAgenda == "" || $scope.editProject.researchAgenda == null){
			$scope.projectUpdateError4=true;
		}else{
			$scope.projectUpdateError4=false;
			}
	};
	
	$scope.cancelUpdate=function(){
		$scope.showEdit=false;
		$scope.projectUpdateError1=false;
		$scope.projectUpdateError2=false;
		$scope.projectUpdateError3=false;
		$scope.projectUpdateError4=false;
	}
	
	$scope.edit=function(project){
		var temp = {};
		$scope.showEdit=true;
		$scope.show=false;
		temp = project;
		$scope.editProject = temp;
	};
	
	$scope.addProjectButton=function(){
		$scope.show=true;
		$scope.showEdit=false;
		$scope.projId = "PR"+ Math.random().toString().slice(5, 10);
	}
	
	
	$scope.selectProject = function(project){
		//alert(project.projectName);
		userService.resetRole();
		projectService.setProject(project);
		Auth.getRoles(project.projectId, userService.getUser().id, function(data){
			//alert("roledata : "+data);
			userService.setUserPermission(data);
			var found = false;
			//$scope.isFacilitator = found;
			if(userService.getUserPermission() != undefined){
				/*console.log("some permissions are there for this user");*/
				var roles = userService.getUserPermission().permissions;
			
		    	
	    	//$scope.isFacilitator = found;
		        //alert(" user permission "+roles);
		        angular.forEach(roles, function(role, index){
		            if (role.indexOf('Facilitator') >= 0){
		                found = true;
		                /*console.log("permission checking");*/
		                userService.setAllAccess(found);
		                //$scope.isFacilitator = found;
		                return;
		            }                        
		        });
		        userService.setAllAccess(found);
		} 
			//$scope.isFacilitator = found;
			var stage = projectService.getStage();
			if(stage.projectStageID == 0)
				$state.go("home.projects.details");
			else if(stage.projectStageID == 1)
				$state.go("home.projects.details.media");
			else if(stage.projectStageID == 2)
				$state.go("home.projects.details.empathy");
			else if(stage.projectStageID == 3)
				$state.go("home.projects.details.ideas");
			else if(stage.projectStageID == 4)
				$state.go("home.projects.details.prototype");
			else if(stage.projectStageID == 5)
				$state.go("home.projects.details.prototype_Feedback");
		});
	};
	/*
	 * resizing the table according to device size
	 * */
	$scope.tableSize = false;
	$scope.resize = 'hidden-xs';
	$scope.expand = function(){
		$scope.resize = "visible-xs";
		$scope.tableSize = !$scope.tableSize;
	};
	$scope.collapse = function(){
		$scope.resize = "hidden-xs";
		$scope.tableSize = !$scope.tableSize;
	}
})