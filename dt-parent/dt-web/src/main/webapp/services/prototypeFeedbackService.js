module.service('prototypeFeedbackService', function($http,$location,projectService){
	
	
	
	this.getPrototypeData = function(callbackPrototype){
		
		
        {
        	
        	            var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeFeedback/getActive/"+projectService.getProject().projectId);
						
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
	
	
    this.getdata = function(callbackPrototypeFeedback){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeFeedback/getAll/"+projectService.getProject().projectId);
						responsePromise.success(function(data, status, headers, config) {
						callbackPrototypeFeedback(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
 
   
   this.addPrototypeFeedback = function(prototypeFeedbackDescription,prototypeId,checkSelection,projectStage,project, user,callback){

	   	var prototypeFeedback = {
	   			"prototypeFeedbackDescription":prototypeFeedbackDescription,
	   			"prototype":{ "prototypeId":prototypeId },
	   			"deleteFlag":checkSelection,
	   			"user": user
		};

	   	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeFeedback/createPrototypeFeedback', 
			method: "POST", // In this case it is POST
			data: prototypeFeedback,
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
   
});