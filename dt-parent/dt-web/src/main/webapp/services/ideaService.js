module
		.service(
				'ideaService',
				function($http,$location,projectService) {

					
					 this.getdata = function(callbackIdea){
					        {
											var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideaservice/activeOnly/"+projectService.getProject().projectId); 
					        	
					        	
											responsePromise.success(function(data, status, headers, config) {
												
											callbackIdea(data);
									        });
										    responsePromise.error(function(data, status, headers, config) {
									        alert("AJAX failed! because no webservice is attached yet");      					 
										    });
						   };
					    }
					 
					 this.getalldata = function(callbackIdea){
					        {
											var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideaservice/showAll/"+projectService.getProject().projectId); 
					        	
					        	
											responsePromise.success(function(data, status, headers, config) {
												
											callbackIdea(data);
									        });
										    responsePromise.error(function(data, status, headers, config) {
									        alert("AJAX failed! because no webservice is attached yet");      					 
										    });
						   };
					    }
					 
					   
					   
					    this.addIdea = function( idea, projectId,user, callback){
					    	var Project_ID=projectService.getProject().projectId;
					    	var idea = {
					    			
					    			"project":{"projectId":Project_ID},
					    			"ideaDescription":  idea,
					    			"user" : user
								};
					    	
					    
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideaservice/createIdea', 
								method: "POST", // In this case it is POST
								data: idea,
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
					    
					    this.deactivate=function(ideaId, callbackDelete){
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideaservice/delete', 
								method: "POST", // In this case it is POST
								data: ideaId,
								headers: { 'Content-Type': 'application/json' }
							 });
					    		responsePromise.success(function(data, status, headers, config) {
					    			alert("Deactivated Successfully");
					    			callbackDelete();
					    		});
							    responsePromise.error(function(data, status, headers, config) {
						        alert("AJAX failed! because no webservice is attached yet");      					 
							    });
					    }
					    
					    
					    this.activate=function(ideaId, callbackDelete){
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideaservice/activate', 
								method: "POST", // In this case it is POST
								data: ideaId,
								headers: { 'Content-Type': 'application/json' }
							 });
					    		responsePromise.success(function(data, status, headers, config) {
					    			alert("Activated Successfully");
					    			callbackDelete();
					    		});
							    responsePromise.error(function(data, status, headers, config) {
						        alert("AJAX failed! because no webservice is attached yet");      					 
							    });
					    }
					    
					    this.updateIdeas = function(ideaDesc,ideaid,user,callback){
					    	
					    	var idea={
					    			
					    			"ideaId":ideaid,
					    			"ideaDescription":ideaDesc,
					    			"user" : user
					    	};
					    	var responsePromise = 	 $http({	url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideaservice/updateIdea", 
								method: "POST", // In this case it is POST
								data: idea,
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
					    	
					    
					this.getIdeaFeedbackdata = function(callbackIdeaFeedback) {
						{
							var responsePromise = $http
									.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideafeedbackservice/getAll/"+projectService.getProject().projectId); 
							responsePromise.success(function(data, status,
									headers, config) {
								callbackIdeaFeedback(data);
							});
							responsePromise
									.error(function(data, status, headers,
											config) {
										alert("AJAX failed! because no webservice is attached yet");
									});
						}
						;
					}

			
					this.getIdeaCategoryData = function(callbackIdeaCategory) {
						{
							var responsePromise = $http
									.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideafeedbackservice/getAllCategory");
							responsePromise.success(function(data, status,
									headers, config) {
								callbackIdeaCategory(data);
							});
							responsePromise
									.error(function(data, status, headers,
											config) {
										alert("AJAX failed! because no webservice is attached yet");
									});
						}
						;
					}

this.addIdeaFeedback = function(ideaFeedbackDescription,ideaCategoryId,ideaId,check,user,callback) {

						

						var ideaFeedback = {

							"ideaCategory":{"ideaCategoryId":ideaCategoryId},
							"ideaFeedbackDescription":ideaFeedbackDescription,
							"idea":{ "ideaId":ideaId },
							"deleteFlag":check,
							"user" : user

						};
		
						var responsePromise = $http({
							url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideafeedbackservice/createIdeaFeedback',
							method : "POST", // In this case it is POST
							data : ideaFeedback,
							headers : {
								'Content-Type' : 'application/json'
							}

						});

						responsePromise.success(function(data, status, headers,config) {
							alert("Added Successfully");
							callback();
						});
						responsePromise.error(function(data, status, headers, config) {
									alert("AJAX failed! because no webservice is attached yet");
								});
					}

					
					
					
					//idea group 
					
					 this.getIdeaGroupData = function(callbackIdeaGroup){
					        {
											var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideagroupservice/getIdeaGroup/"+projectService.getProject().projectId); 
					        	
					        	
											responsePromise.success(function(data, status, headers, config) {
											
											callbackIdeaGroup(data);
									        });
										    responsePromise.error(function(data, status, headers, config) {
									        alert("AJAX failed! because no webservice is attached yet");      					 
										    });
						   };
					    }
					 
					 this.getAllIdeaGroupData = function(callbackIdeaGroup){
					        {
											var responsePromise = $http.get("http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideagroupservice/getAllIdeaGroup/"+projectService.getProject().projectId); 
					        	
					        	
											responsePromise.success(function(data, status, headers, config) {
											
											callbackIdeaGroup(data);
									        });
										    responsePromise.error(function(data, status, headers, config) {
									        alert("AJAX failed! because no webservice is attached yet");      					 
										    });
						   };
					    }
					 
					 
					  this.addIdeaGroup = function( ideagname,projectId,user,callback){
					    	var Project_ID=projectService.getProject().projectId;
					    	var idea = {
					    			
					    			"project":{"projectId":Project_ID},
					    			"igname":  ideagname,
					    			"user":user
								};
					    	
					    
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideagroupservice/createIdeaGroup', 
								method: "POST", // In this case it is POST
								data: idea,
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
					  
					  this.updateIdeaGroups = function(igname,igid,callback){
					    	var idea={
					       			"igid":igid,
					    			"igname":igname
					    	};
					    	var responsePromise = 	 $http({	url: "http://"+$location.host()+':'+$location.port()+"/dt-web/webresources/ideagroupservice/updateIdeaGroup", 
								method: "POST", // In this case it is POST
								data: idea,
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
					  
					  this.deactivateIdeaGroup=function(igid, callbackDelete){
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideagroupservice/deleteIdeaGroup', 
								method: "POST", // In this case it is POST
								data: igid,
								headers: { 'Content-Type': 'application/json' }
							 });
					    		responsePromise.success(function(data, status, headers, config) {
					    			alert("Deactivated Successfully");
					    			callbackDelete();
					    		});
							    responsePromise.error(function(data, status, headers, config) {
						        alert("AJAX failed! because no webservice is attached yet");      					 
							    });
					    }

					  this.activateIdeaGroup=function(igid, callbackDelete){
					    	var responsePromise = 	 $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/ideagroupservice/activateIdeaGroup', 
								method: "POST", // In this case it is POST
								data: igid,
								headers: { 'Content-Type': 'application/json' }
							 });
					    		responsePromise.success(function(data, status, headers, config) {
					    			alert("Activated Successfully");
					    			callbackDelete();
					    		});
							    responsePromise.error(function(data, status, headers, config) {
						        alert("AJAX failed! because no webservice is attached yet");      					 
							    });
					    }
					 // FETCH ALL AVAILABLE IDEAS 
					  this.getAvailableIdeasServ=function(projectId,igid,callback){
						  var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignideagroupservice/getAllAvailableIdeas/'+projectId+'/'+igid,
								method : "POST", // In this case it is POST
								headers : {'Content-Type' : 'application/json'}
							});
							responsePromise.success(function(data, status, headers,config) {
								callback(data);
							});
							
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
						}
					  //FETCH ASSIGNED IDEAS
					  this.getAssignedIdeasServ=function(ideaGroupId,callback){
							var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignideagroupservice/retrieveassignideagroup',
								method : "POST", // In this case it is POST
								data : ideaGroupId,
								headers : {'Content-Type' : 'application/json'}
							});

							responsePromise.success(function(data, status, headers,config) {
								callback(data);
							});
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
					}
					//SUBMIT of ASSIGN IDEAS  
					  this.updateIdeaGroupServ=function(igid,ideaIds,callback){
						 
							var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignideagroupservice/updateassignideagroup/'+igid+"/"+ideaIds,
								method : "GET", // In this case it is POST
								headers : {'Content-Type' : 'application/json'}
							});

							responsePromise.success(function(data, status, headers,config) {
								alert("Added Successfully");
								callback();
							});
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
						}
					//FETCHING AVAILABLE HMWs  
					  this.getAvailablePOVsServ=function(projectId,igid,callback){
							var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignhmwservice/getallavailablehmws/'+projectId+'/'+igid,
								method : "POST", // In this case it is POST
								headers : {'Content-Type' : 'application/json'}
							});
							responsePromise.success(function(data, status, headers,config) {
								callback(data);
							});
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
						}
					//FETCH ASSIGNED HMWs
					  this.getAssignedHmwServ=function(ideaGroupId,callback){
							var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignhmwservice/getassignedhmw',
								method : "POST", // In this case it is POST
								data : ideaGroupId,
								headers : {'Content-Type' : 'application/json'}
							});

							responsePromise.success(function(data, status, headers,config) {
								callback(data);
							});
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
					}
				//SUBMIT of ASSIGN IDEAS  
					  this.updateHMWGroupServ=function(igid,questionIds,callback){
						 
						  var responsePromise = $http({
								url : 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/assignhmwservice/updatehmwgroup/'+igid+"/"+questionIds,
								method : "GET", // In this case it is POST
								headers : {'Content-Type' : 'application/json'}
							});

							responsePromise.success(function(data, status, headers,config) {
								alert("Added Successfully");
								callback();
							});
							responsePromise.error(function(data, status, headers, config) {
								alert("AJAX failed! because no webservice is attached yet");
							});
						}

				});