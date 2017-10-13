module.service('projectService', function($http, $location, $state){
	var project = {};
    //var stage = 2;
	this.setProject = function(selectedProject){
		project = selectedProject;
	};
	this.getProject = function(){
		return project;
	};
    this.setStage = function(num, destinationPage){
		//alert(stage+" [num : "+num);
    	
		if(num > project.projectStage.projectStageID){
	    	var updatedProject = {
	    			"projectId":project.projectId,
					"projectName": project.projectName,
					"ibuName": project.ibuName,
					"accountName": project.accountName,
					"researchAgenda": project.researchtAgenda,
					"projectStage":{"projectStageID":num}
				};
	    	//alert(updatedProject);
	    	/*console.log(updatedProject);*/
			var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/projectservice/updateProjectStage', 
				method: "POST", // In this case it is POST
				data: updatedProject,
				headers: { 'Content-Type': 'application/json' }
			 });
	    	responsePromise.success(function(data, status, headers, config) {
	    		//alert("project updated");
	    		project = data;
	    		$state.go(destinationPage);	
		        });
			    responsePromise.error(function(data, status, headers, config) {
		        alert("AJAX failed! because no webservice is attached yet");      					 
			    });
		}else{
			$state.go(destinationPage);	
		}
	};
	
	this.setStageByForcebly = function(num, destinationPage){
		var updatedProject = {
    			"projectId":project.projectId,
				"projectName": project.projectName,
				"ibuName": project.ibuName,
				"accountName": project.accountName,
				"researchAgenda": project.researchtAgenda,
				"projectStage":{"projectStageID":num}
		};
    	/*console.log(updatedProject);*/
		var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/projectservice/updateProjectStage', 
			method: "POST", // In this case it is POST
			data: updatedProject,
			headers: { 'Content-Type': 'application/json' }
		});
    	responsePromise.success(function(data, status, headers, config) {
    		//alert("project updated");
    		project = data;
    		$state.go(destinationPage);	
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		});
		$state.go(destinationPage);	
	};
	this.getStage = function(){
		return project.projectStage;
	};
    this.getActivedata = function(userId,callbackProject){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/projectservice/getActive/"+userId);
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/projectservice/getAll");
						responsePromise.success(function(data, status, headers, config) {
						callbackProject(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    this.deactivate=function(id, callbackProject){
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/projectservice/delete', 
			method: "POST", // In this case it is POST
			data: id,
			headers: { 'Content-Type': 'application/json' }
		 });
    		responsePromise.success(function(data, status, headers, config) {
    		callbackProject();
    		});
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
    }
    this.getdata = function(userId,callbackProject){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/projectservice/getAll/"+userId);
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/projectservice/getAll");
						responsePromise.success(function(data, status, headers, config) {
						callbackProject(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    this.addProject = function(projectName,projId,ibuName,accountName,researchtAgenda,user,callback){
    	var project = {
				"projectName": projectName,
				"projId": projId,
				"ibuName": ibuName,
				"accountName": accountName,
				"researchAgenda": researchtAgenda,
				"user":user
			};
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/projectservice/createProject', 
			method: "POST", // In this case it is POST
			data: project,
			headers: { 'Content-Type': 'application/json' }
		 });
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Added Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
    
    this.updateProject = function(project, callback){//alert("in update project");
    	/*var p_id = parseInt(pid);
    	var p_name = pname;*/
    	//alert("in update project "+p_id+" "+p_name);
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/projectservice/updateProject', 
			method: "POST", // In this case it is POST
			data: project,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Updated Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
    }
    
    this.getProjectStages = function(callbackProjectStage){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/projectservice/getProjectStages");
						responsePromise.success(function(data, status, headers, config) {
							callbackProjectStage(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }    
});