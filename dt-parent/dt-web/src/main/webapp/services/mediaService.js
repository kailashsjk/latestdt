/*module.service('mediaService', function($http,$location,projectService){
	alert(projectService.getProject().projectId);
	var mediaName = "";
	this.setMediaName = function(pname){
		mediaName = pname;
	};
	this.getMediaName= function(){//alert("in get projctname : "+ mediaName);
		return mediaName;
	}
    this.getdata = function(callbackMedia){
    	
        {
        	var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediaservice/getAll/"+projectService.getProject().projectId);
						responsePromise.success(function(data, status, headers, config) {
							//alert("data in service "+data);
							callbackMedia(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      			

		 
					    });
	   };
    }
    
    this.addMedia= function(jobType,intervieweeName,projectId,callback){
    	var jType = jobType;
    	var iName = intervieweeName;
    	var projectId=1;
    	var media = {
    			"project":{"projectId":g_project_id},
				"jobType": jType,
				"intervieweeName": iName
				
			};
    	//alert("media before Created");
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/createMedia', 
			method: "POST", // In this case it is POST
			data: media,
			headers: { 'Content-Type': 'application/json' }
		 });
		 //alert("Media after Created");
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Media Created");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
    this.updateMedia = function(mid, iname){alert("in update project");
    	var m_id = parseInt(mid);
    	var i_name = iname;
    	var media={
    			"mediaId":m_id,
        		"intervieweeName":i_name
    			
    	};
    	//alert("in update project "+p_id+" "+p_name);
    	var responsePromise = 	 $http({	url: 'http://localhost:18080/dt-web/webresources/mediaservice/updateMedia',
			method: "POST", // In this case it is POST
			data: media,
			headers: { 'Content-Type': 'text/plain' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Media updated");
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
    }
    
    this.updateMedia = function(mid, iname){//alert("in update project");
    	var m_id = parseInt(mid);
    	var i_name = iname;
    	var media={
    			"mediaId":m_id,
        		"intervieweeName":i_name
    			
    	};
    	//alert("in update project "+p_id+" "+p_name);
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/updateMedia',
			method: "POST", // In this case it is POST
			data: media,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		alert("Media updated");
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
		    
		    
		    
    }
    
    
    this.deleteMedia = function(media,callback){//alert("in update project");
    	var m_id = parseInt(media);
    	
    	//alert("in update project "+p_id+" "+p_name);
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/deleteMedia',
			method: "POST", // In this case it is POST
			data: m_id,
			headers: { 'Content-Type': 'application/json' }
		 });
    	responsePromise.success(function(data, status, headers, config) {
    		
    		callback();
    		alert("Media deleted");
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
		    
		    
		    
    }
    
    
    
});
*/
module.service('mediaService', function($http,$location,projectService,$window){
	
	var mediaName = "";
	this.setMediaName = function(pname){
		mediaName = pname;
		//alert(mediaName);
	};
	this.getMediaName= function(){//alert("in get projctname : "+ mediaName);
		return mediaName;
	}
	
    this.getdata = function(callbackMedia){
    	
        {
        	
        	var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediaservice/getAll/"+projectService.getProject().projectId);
        	
						responsePromise.success(function(data, status, headers, config) {
						
							callbackMedia(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      			

		 
					    });
	   };
    }
    
    this.getActivedata = function(callbackMedia){
        {
        
        	//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/mediaservice/getActive/1");
						var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediaservice/getActive/"+projectService.getProject().projectId); 
						//var responsePromise = $http.get("http://localhost:18080/dt-web/webresources/mediaservice/getActive/"+projectService.getProject().projectId); 
						responsePromise.success(function(data, status, headers, config) {
							callbackMedia(data);
				        });
					    responsePromise.error(function(data, status, headers, config) {
				        alert("AJAX failed! because no webservice is attached yet");      					 
					    });
	   };
    }
    
    this.showMediaDocuments = function(mediaId, callbackMedia){
        {
			var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediadocumentsservice/getMediaDocuments/"+mediaId); 
			responsePromise.success(function(data, status, headers, config) {
				callbackMedia(data);
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	   };
    }
    this.addMedia= function(intervieweeName, techiniqueUsed,jobType,inputNotes,projectId,uid,user, callback){
    	var media = {
    			"intervieweeName":intervieweeName,
    			"techiniqueUsed":techiniqueUsed,
    			"jobType": jobType,
    			"inputNotes": inputNotes,
    			"project":{"projectId":projectId},
				"user":user		
			};
    	//alert("media before Created");
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/createMedia/'+uid, 
			method: "POST", // In this case it is POST
			data: media,
			headers: { 'Content-Type': 'application/json' }
		 });
		 //alert("Media after Created");
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Added Successfully");
    		callback();
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
      
    this.updateMedia = function(media,callback){//alert("in update project");

    	//alert("Media update");
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/updateMedia',
			method: "POST", // In this case it is POST
			data: media,
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
    
    
    this.deactivate = function(id,callback){
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/deleteMedia',
			method: "POST", // In this case it is POST
			data: id,
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
    
    this.activate = function(id,callback){
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/mediaservice/activateMedia',
			method: "POST", // In this case it is POST
			data: id,
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
    
    this.uploadMedia = function (file, mediaType, mediaId, uid, callback){
    	var fd = new FormData();
        fd.append('file', file);
		var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/uploadMediaFile/"+mediaType+"/"+mediaId+"/"+uid, 
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
    
    this.uploadPersona = function (file, mediaId, uid, callback){
    	var fd = new FormData();
        fd.append('file', file);
		var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/uploadPersonaFile/"+mediaId+"/"+uid, 
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
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/file/deleteMediaDocument',
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
    
    this.removePersonaDocument = function(document,callback){
    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/file/deletePersonaDocument',
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
    
    this.showPersonaDocuments = function(mediaId, callbackPersonaMedia){
        {
			var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/mediaservice/getPersonaDocument/"+mediaId); 
			responsePromise.success(function(data, status, headers, config) {
				callbackPersonaMedia(data);
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	   };
    }    
    this.downloadDocument= function(documentData, callback){
    	var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/downloadFile/"+documentData.mediaName+"/"+documentData.documentID, 
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
    
    this.downloadAttachements= function(documentData, callback){
    	var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/downloadFile/"+documentData.documentName+"/"+documentData.documentId, 
			method: "POST" ,// In this case it is POST
			headers: { 'Content-Type': 'application/json' },
			responseType: 'arraybuffer'
		});
		responsePromise.success(function(data, status, headers, config) {
			var blob = new Blob([data], {type: "application/octate-stream"});
			saveAs(blob, documentData.documentName);
		});
		responsePromise.error(function(data, status, headers, config) {
		alert("AJAX failed! because no webservice is attached yet");      					 
		});
    }
    
    this.downloadTemplates= function(callback){
			var templateUrl = "http://"+$location.host()+":"+$location.port()+"/dt-web/templates/Persona Template.docx";
			callback(templateUrl);
	};
	
});
