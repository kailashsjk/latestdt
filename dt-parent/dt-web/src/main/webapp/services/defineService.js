module.service('defineService',function($http,$location){
	
	this.getNeeds=function(projectId,callback){
		var project_id = parseInt(projectId);
		var responsePromise = $http.get('http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/getneedsbydeleteflag/'+project_id);
		responsePromise.success(function(data, status, headers, config) {
		callback(data);
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");
	    });
	}
	
	this.getInsights=function(projectId,callback){
		var project_id = parseInt(projectId);
		var responsePromise = $http.get('http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/getinsightsbydeleteflag/'+project_id);
		responsePromise.success(function(data, status, headers, config) {
		callback(data);
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");
	    });
	}
	
	this.getAllNeeds=function(projectId,callback){
		var project_id = parseInt(projectId);
		var responsePromise = $http.get('http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/getneeds/'+project_id);
		responsePromise.success(function(data, status, headers, config) {
		callback(data);
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");
	    });
	}
	
	this.getAllInsights=function(projectId,callback){
		var project_id = parseInt(projectId);
		var responsePromise = $http.get('http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/getinsights/'+project_id);
		responsePromise.success(function(data, status, headers, config) {
		callback(data);
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");
	    });
	}
	/*Add a new NOI*/
    this.addNewNeedsOrInsightsServ = function(needs,projectId,user,needOrInsight,callback){
    	var needs = {
				"description": needs,
				"needOrInsight": needOrInsight,
				"project":{
					"projectId": projectId
				},
    			"user": user
    			
			};
    	var responsePromise = 	 $http({	
    		url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/createNeedsOrInsights',
			method: "POST", // In this case it is POST
			data: needs,
			headers: { 'Content-Type': 'application/json' }
		 });
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Added Successfully");
    		/*console.log("Updated Data From Service-->"+data.toString());*/
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });
	}
    
  
   /*Edit NOI*/
    this.updateNeedsOrInsights= function(noiId,noiDescription,user,callback){
    	var noi_Id = parseInt(noiId);
    	var needsOrInsights = {
    			"noiId":noiId,
				"description": noiDescription,
				"user" : user
			};
       	var responsePromise = 	 $http({	
       		url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/updateNeedsOrInsights',
			method: "POST", 
			data: needsOrInsights,
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
    
    /*Deactivate NOI*/   
    this.deleteNeedsOrInsightsServ=function(noiId,callback){
       	var responsePromise = 	 $http({	
       		url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/needsorinsightsservice/deletenoi',
			method: "POST", 
			data: noiId,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Deleted Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });
    
    }
    /*Reactivate*/
    this.activateNeedsOrInsightsServ=function(noiId,callback){
       	var responsePromise = 	 $http({	
       		url: 'http://localhost:8080/dt-web/webresources/needsorinsightsservice/activatenoi',
			method: "POST", 
			data: noiId,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Activated Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });
    
    }    
   /* Empathy Mapping*/
    this.getEmpathy = function(mediaId,callbackEmpathy){
		 
    	var media_id = parseInt(mediaId);
    	var responsePromise = 	 $http({	
    		url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/empathyservice/getempathy/'+media_id,
			method: "GET", 
			headers: { 'Content-Type': 'text/plain' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		callbackEmpathy(data);
    	});
		responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		});
		
    }
})