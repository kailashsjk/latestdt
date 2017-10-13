module.service('observationService', function($http,$location,projectService){
	
	var mediaId = "";
	this.setObservationName = function(oname){
		mediaId = oname;
		//alert(mediaId);
	};
	this.getObservationName = function(){//alert("in get mediaID : "+ mediaId);
		return mediaId;
	}
	
	this.getProject = function(){
		return project;
	}
	
	
    this.getdata = function(callbackObservation){//alert("in obs service");
        {        	
        	//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/observationservice/getAll/1");
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/observationservice/getAll/"+projectService.getProject().projectId);
						responsePromise.success(function(data, status, headers, config) {
							callbackObservation(data);
				        });
						responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    this.getAlldata = function(callbackObservation){
        {        	
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/observationservice/getAllObservations/"+projectService.getProject().projectId);
        	//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/observationservice/getAllObservations/1");
        	responsePromise.success(function(data, status, headers, config) {
							callbackObservation(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    this.getdata1 = function(callbackMedia){
        
        {
                                         var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediaservice/getAll/"+g_project_id);
                                         responsePromise.success(function(data, status, headers, config) {
                                               // alert("data in service "+data);
                                                callbackMedia(data);
                                   });
                                      responsePromise.error(function(data, status, headers, config) {
                                   alert("AJAX failed! because no webservice is attached yet");                    
 

              
                                      });
          };
    }
    
    this.getActivedata = function(callbackObservation){
        {
        	var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/observationservice/getAllObservations/"+projectService.getProject().projectId);
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/projectservice/getAll");
						responsePromise.success(function(data, status, headers, config) {
							callbackObservation(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    

/**retrieving all observationCategory**/
    
    this.getObsCategory = function(callObsCat){
	//alert('calling getObservationCategory')
    	//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/observationservice/getObsCategory");
    	var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/observationservice/getObsCategory");
	responsePromise.success(function(data, status, headers, config) {
		callObsCat(data);
    });
	responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");      					 
	    });
}; 
    
/**inserting observation**/

    this.addObservation = function(mediaId,observationCategoryID,observationNotes,mediaId,user,callbackObservation){
    	var observation = {
    			"media":{ "mediaId":mediaId},
       			"observationCategory":{ "observationCategoryID":observationCategoryID },
       			"observationNotes":observationNotes,
       			"user":user
			};
    	//alert("observation before Created");
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/observationservice/createObservations',
    		//var responsePromise = 	 $http({	url: 'http://localhost:18080/dt-web/webresources/observationservice/createObservations',
			method: "POST", // In this case it is POST
			data: observation,
			headers: { 'Content-Type': 'application/json' }
		 });
    	//alert("observation after Created");
    		responsePromise.success(function(data, status, headers, config) {
    			//alert("In data Observaton service" + data)
    		callbackObservation();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
    
/**modifying observation**/
    
    this.updateObservation = function(observation, callback){//alert("in update project");
    		var responsePromise = 	 $http({	url:'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/observationservice/updateObservations', 
    		//var responsePromise = 	 $http({	url:'http://localhost:18080/dt-web/webresources/observationservice/updateObservations',
    		method: "POST", // In this case it is POST
			data: observation,
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
    
/**deleting observation**/
    
    this.deleteObservation = function(observation,callback){
	var oID = parseInt(observation);	
	
	//alert("in delete observations ",+oID	);
	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/observationservice/deleteObservations', 
		method: "POST", // In this case it is POST
		data: oID,
		headers: { 'Content-Type': 'application/json' }
	 });
	responsePromise.success(function(data, status, headers, config) {
	
		callback();
		alert("Deleted Successfully");
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");      					 
	    });
}
    
/**activate observation**/
    
    this.activateObservation = function(observation,callback){
	var oID = parseInt(observation);	
	
	//alert("in delete observations ",+oID	);
	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/observationservice/activateObservations', 
		method: "POST", // In this case it is POST
		data: oID,
		headers: { 'Content-Type': 'application/json' }
	 });
	responsePromise.success(function(data, status, headers, config) {
	
		callback();
		alert("Activated Successfully");
        });
	    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed! because no webservice is attached yet");      					 
	    });
}
    
    
});