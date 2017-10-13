module.service('prototypeService', function($http,$location,projectService){
	
	var projectName = "";
	this.setProjectName = function(pname){
		projectName = pname;
		/*alert(projectName);*/
	};
	this.getProjectName = function(){/*alert("in get projctname : "+ projectName);*/
		return projectName;
	}
	this.getdata = function(callbackPrototype){
		
        {
        	            var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/get/"+projectService.getProject().projectId);
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    
    
    
    this.getdataIGID = function(callbackPrototype2){
        {
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/getIdeaGroup/"+projectService.getProject().projectId);
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype2(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    this.getAlldata = function(callbackPrototype){
    
        {
        	            var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/getAll/"+projectService.getProject().projectId);
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/prototypeservice/get/3");
						responsePromise.success(function(data, status, headers, config) {
							callbackPrototype(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    
    this.addPrototype = function(igroup1,proDescription,user,uid, callback){
    	var prototype = {
			    "prototypeDescription": proDescription,
				"ideaGroup":{"igid":igroup1},
				"user":user
    	};
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/createPrototype/'+uid, 
			method: "POST", // In this case it is POST
			data: prototype,
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
    

    this.updatePrototype = function(prototypeId,prototypeDescription,test,callback){
    	//alert("service id"+ prototypeId);
    	//alert("service desc"+ prototypeDescription);
    	var prototyping={
    			"prototypeId":prototypeId,
        		"prototypeDescription":prototypeDescription,
        		"test":test
        };
        var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/updatePrototypeDescription' , 
			method: "POST", // In this case it is POST
			data: prototyping,
			headers: { 'Content-Type': 'application/json' }
        });
    	
    	responsePromise.success(function(data, status, headers, config) {
    	callback();
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
    		alert("Deactivated Successfully");
    		callback();
            });
    	    responsePromise.error(function(data, status, headers, config) {
            alert("AJAX failed! because no webservice is attached yet");      					 
    	    });
    }
    
    
    this.activatePrototype = function(prototyping,callback){
    	var pID = parseInt(prototyping);	
 

    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/ActivatePrototype', 
    		method: "POST", // In this case it is POST
    		data: pID,
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
    
    this.setTest = function(prototypeId,callback){
    	//alert("service id"+ prototypeId);
    	//alert("service desc");
    	var prototyping={
    			"prototypeId":prototypeId,
        		"test":1,
        		"prototypeStatus":"test"
        };
        var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/prototypeservice/setTest' , 
			method: "POST", // In this case it is POST
			data: prototyping,
			headers: { 'Content-Type': 'application/json' }
        });
    	
    	responsePromise.success(function(data, status, headers, config) {
    	alert("Prototype is send to Test ");
    	callback();
        });
    	responsePromise.error(function(data, status, headers, config) {
	    alert("AJAX failed! because no webservice is attached yet");      					 
	    });
    }
    
    this.uploadMedia = function (file, mediaType, prototypeId, uid, callback){
    	var fd = new FormData();
        fd.append('file', file);
		var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/uploadPrototypeFile/"+mediaType+"/"+prototypeId+"/"+uid, 
										method: "POST" ,// In this case it is POST
										headers: { 'Content-Type': undefined },
										transformRequest: angular.identity,
										data: fd
		 		});
				responsePromise.success(function(data, status, headers, config) {
					callback(data);
				});
				responsePromise.error(function(data, status, headers, config) {
					alert("AJAX failed! because no webservice is attached yet");      					 
				});
    }
    
    this.removeDocument = function(document,callback){
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/file/deletePrototypeDocument',
			method: "POST", // In this case it is POST
			data: document,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		
    		callback(data);
    		alert("Deleted Successfully");
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
		    
    }
    
    this.showPrototypeDocuments = function(prototypeId, callbackMedia){
        {
			var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/prototypeservice/getPrototypeDocuments/"+prototypeId); 
			responsePromise.success(function(data, status, headers, config) {
				callbackMedia(data);
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	   };
    }
    
    this.downloadDocument= function(documentData, callback){
		var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/downloadFile/"+documentData.documentName+"/"+documentData.documentId, 
			method: "POST" ,// In this case it is POST
			headers: { 'Content-Type': 'application/json' },
			responseType: 'arraybuffer'
			//data: documentData
		});
		responsePromise.success(function(data, status, headers, config) {
			//alert("Download success");
			var blob = new Blob([data], {type: "vedio"});
			var objectUrl = URL.createObjectURL(blob);
			callback(objectUrl);
			//window.open(objectUrl);
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