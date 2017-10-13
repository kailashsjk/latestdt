module.service('prototypingService', function($http,$location){
	
	var projectName = "";
	this.setProjectName = function(pname){
		projectName = pname;
		//alert(projectName);
	};
	this.getProjectName = function(){/*alert("in get projctname : "+ projectName);*/
		return projectName;
	}
	this.getdata = function(callbackPrototype){
        {
        	            var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/get/"+g_project_id);
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/prototypeservice/get/3");
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    this.getdataID = function(callbackPrototype1){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/getAllHmwQuestionsByMediaId");
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype1(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    this.getdataIdeaID = function(callbackPrototype2){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/getAllIdeaByHMWQuestion");
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype2(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    
    
    this.addPrototype = function(ideaId,prototypeDescription,callback){
  
    	var prototype = {

			    "prototypeDescription": prototypeDescription,
				"idea":{"ideaId":ideaId}
				
			};
    	//
    	//alert("project Created00kguli");
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/createPrototype', 
			method: "POST", // In this case it is POST
			
			data: prototype,
			headers: { 'Content-Type': 'application/json' }
    	
		 });
    	//alert("project Created00126");
    		responsePromise.success(function(data, status, headers, config) {
    		alert("prototype Created");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
    

    this.updatePrototyping = function(prototypeId, prototypeDescription){
    	var p_id =parseInt(prototypeId);
    	var p_description = prototypeDescription;

            var prototype1 = {
    			
			    "prototypeId":p_id,
			    "prototypeDescription": p_description
				
				
			};
           // alert("project update00kguli"+ pid);
        	//alert("project update00kguli"+ pdescription);
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/updatePrototypeDescription' , 
			method: "POST", // In this case it is POST
			data: prototype1,
			headers: { 'Content-Type': 'application/json' }
		 });
    	//alert("project updated");
    	responsePromise.success(function(data, status, headers, config) {
    		alert("project updated");
    		//callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
    }
    
    this.deletePrototype = function(prototyping,callback){
    	var pID = parseInt(prototyping);	
 

    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/deletePrototype', 
    		method: "POST", // In this case it is POST
    		data: pID,
    		headers: { 'Content-Type': 'application/json' }
    	 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Prototype deleted");
    		callback();
            });
    	    responsePromise.error(function(data, status, headers, config) {
            alert("AJAX failed! because no webservice is attached yet");      					 
    	    });

    
    }
    
this.addPrototypeFeedback = function(prototypeFeedback, ideaId,prototypeId){
    	
    	var idea1= ideaId; 
       	var hmw = prototypeFeedback;
       	var prototypeFeedback = {
     			
       			"prototyping":{ "prototypeId":prototypeId }	
    			};
       	
       
       	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeFeedback/createPrototypeFeedback', 
    			method: "POST", // In this case it is POST
    			data: prototypeFeedback,
    			headers: { 'Content-Type': 'application/json' }
       	
       
    		 });
       	
       
       		responsePromise.success(function(data, status, headers, config) {
       			alert("PrototypeFeedback Created");
    	        });
    		    responsePromise.error(function(data, status, headers, config) {
    	        alert("AJAX failed! because no webservice is attached yet");      					 
    		    });
    	}
    
    
    
});