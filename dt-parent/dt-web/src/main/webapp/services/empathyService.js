
/**
 * 
 */

module.service('empathyService', function($http,$location){
	
	var questionDescription = "";
	this.setHmwQuestion= function(qname){
		questionDescription = qname;
		
	};
	this.getQuestionDescription = function(){
		
		
	return questionDescription;
	}
    this.getdata = function(projectId, callbackHmwQuestions){
    	{
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/getHmwQuestion/"+projectId);
						responsePromise.success(function(data, status, headers, config) {
						callbackHmwQuestions(data);						
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed in display()! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    this.getActivedata = function(projectId,callbackHmwQuestions){
    	{
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/getActiveHmwQuestion/"+projectId);
						responsePromise.success(function(data, status, headers, config) {
						callbackHmwQuestions(data);						
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed in display()! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    this.getMediaData = function(projectId,callbackMediaName){
    	{ 
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/getAllMediaName/"+projectId);
						
						
						responsePromise.success(function(data, status, headers, config) {
							
							
							callbackMediaName(data);						
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed in mediaName()! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    this.addHmwQuestions = function(question, projectId, user, callback){
    	
    	var hmwQuestions = {
    			"questionDescription":question,
				"project":{"projectId":projectId},
				"user":user
			};
    	
    	var responsePromise = $http({url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/createHmwQuestions", 
			method: "POST", // In this case it is POST
			data: hmwQuestions,
			headers: {'Content-Type':'application/json'}
		 });
    	
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Added Successfully");
    		callback();
    		$scope.getQuestions();
	        });
		    responsePromise.error(function(data, status, headers, config){
	        alert("AJAX failed in create()!Because no webservice is attached yet");      					 
		    });
	}
    
    this.updateHmwQuestion = function(questionID,questionDescription,user,callback){
    	
    	var question={
    			"questionID": questionID,
    			"questionDescription": questionDescription,
    			"user": user
    	}
    	
    	var responsePromise =$http({url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/updateHmwQuestions", 
			method: "POST", // In this case it is POST
			data: question,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Updated Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed in update()! because no webservice is attached yet");      					 
		    });
    } 
    
    this.deactivate = function (id,callbackQuestions){
    	var question_id = parseInt(id);
    	var responsePromise =$http({url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/deleteHmwQuestion",
method: "POST",
data: question_id,
    	headers: { 'Content-Type': 'text/plain' }
    	});
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Deleted Successfully");
    		callbackQuestions();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed in delete()! because no webservice is attached yet");      					 
		    });
    	
    	}
    
    this.activate = function (id,callbackQuestions){
    	var question_id = parseInt(id);
    	var responsePromise =$http({url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/empathyservice/activateHmwQuestion",
method: "POST",
data: question_id,
    	headers: { 'Content-Type': 'text/plain' }
    	});
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Activated Successfully");
    		callbackQuestions();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed in delete()! because no webservice is attached yet");      					 
		    });
    	
    	}
    
    
    	
});