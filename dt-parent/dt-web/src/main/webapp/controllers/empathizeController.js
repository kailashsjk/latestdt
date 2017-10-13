module.controller('empathizeController', function($scope, $sce, $state, projectService, observationService, mediaService, userService) {
	//$scope.flag = false;
	$scope.createInputError1=false;
	$scope.createInputError2=false;
	$scope.createInputError3=false;
	$scope.updateMediaError1=false;
	$scope.updateMediaError2=false;
	$scope.updateMediaError3=false;
	$scope.createObservationError1=false;
	$scope.createObservationError2=false;
	$scope.createObservationError3=false;
	$scope.createObservationError4=false;
	$scope.updateObservationError1=false;
	$scope.updateObservationError2=false;
	$scope.uploadPersonaError= false;
	$scope.loading = false;
	$scope.flag = {};
	$scope.showFlag = true;
	$scope.showEdit=false;
	$scope.show=false;
	$scope.project = projectService.getProject();
	$scope.random = "";
	$scope.mediaType=1;
	var url1 = "http://localhost:8080/dt-videos/media/Truck Owner.mp4";
	$scope.videoUrl1 = $sce.trustAsResourceUrl(url1);
	var url2 = "http://localhost:8080/dt-videos/media/Mechanic.mp4";
	$scope.videoUrl2 = $sce.trustAsResourceUrl(url2);
	$scope.techniques = [ {
		techniqId : '1',
		techniqName : 'Interview'
	}, {
		techniqId : '2',
		techniqName : 'Observation'
	}, {
		techniqId : '3',
		techniqName : 'Research'
	}, {
		techniqId : '4',
		techniqName : 'Other'
	} ];
	
	
	$scope.getActiveMedias = function() {
		$scope.showFlag = false;
		mediaService.getActivedata(function(data) {
			$scope.medias = data;
			for (var i = 0, length = $scope.medias.length; i < length; i++) {
				$scope.flag[$scope.medias[i].mediaId] = false;
			}
		})
	};
	
	
	$scope.getMedia = function() {
		$scope.showFlag = true;
		mediaService.getdata(function(data) {
               $scope.medias = data;
               for (var i = 0, length = $scope.medias.length; i < length; i++) {
   				$scope.flag[$scope.medias[i].mediaId] = false;
   			}
        })
	};
	
	$scope.edit = function(media){
		
		   $scope.editMedia = media;
		   $scope.showEdit = true;
		   $scope.show = false;
		   $scope.showFlag = false;
		   $scope.showMediaView=false;
		   $scope.random = Math.random().toString(16).slice(5, 15);
		   $scope.showPersonaDocuments(media.mediaId);
		   $scope.showMediaDocuments(media.mediaId);
	};
	
	
	/** view media **/
	$scope.viewMedia = function(media){
		$scope.showMediaView = true;
		$scope.showAddObservation = false;
		$scope.show=false;
		$scope.showFlag = false;
		$scope.showEdit=false;
		$scope.media = media;
		$scope.showMediaDocuments(media.mediaId);
		$scope.showPersonaDocuments(media.mediaId);
	}
	
	
	$scope.addMedia = function(uploadedPersonaDocuments) {
			var projectId = projectService.getProject().projectId;
			if($scope.intervieweeName != "" && $scope.techniqueUsed != "" && $scope.techniqueUsed != null && $scope.jobType != "" && $scope.jobType !=null && $scope.inputNotes != "" && $scope.inputNotes != null && $scope.uploadedPersonaDocuments != null){
				mediaService.addMedia($scope.intervieweeName, $scope.techniqueUsed,$scope.jobType, $scope.inputNotes,projectId,$scope.random,userService.getUser(),function() {
					$scope.show = !$scope.show;
					$scope.getActiveMedias();
					$scope.intervieweeName="";
					$scope.techiniqueUsed="";
					$scope.jobType = "";
					$scope.inputNotes = "";
					$scope.projectId = "";
					$scope.random = "";
					$scope.uploadedDocuments ="";
					$scope.createInputError1=false;
					$scope.createInputError2=false;
					$scope.createInputError3=false;
					$scope.uploadPersonaError= false;
				});
			}
			if($scope.intervieweeName == "" || $scope.intervieweeName == null ){
				$scope.createInputError0=true;
			}else{
				$scope.createInputError0=false;
			}
			if($scope.techniqueUsed == "" || $scope.techniqueUsed == null ){
				$scope.createInputError1=true;
			}else{
				$scope.createInputError1=false;
			}
			if($scope.jobType == "" || $scope.jobType ==null ){
				$scope.createInputError2=true;
			}else{
				$scope.createInputError2=false;
			}
			if($scope.inputNotes == "" || $scope.inputNotes == null){
				$scope.createInputError3=true;
			}else{
				$scope.createInputError3=false;
			}
			if(uploadedPersonaDocuments == null){
				alert("Please Upload Persona Document");
			}
	}
	
	$scope.createMedia=function(){
		$scope.show=true;
		$scope.showFlag = false;
		$scope.showEdit=false;
		$scope.showMediaView=false;
		$scope.random = Math.random().toString(16).slice(5, 15);
		$scope.uploadedDocuments = "";
	}
	$scope.cancelMedia=function(){
		$scope.show=false;
		$scope.random = "";
		$scope.uploadedDocuments = "";
		$scope.techiniqueUsed="";
		$scope.jobType = "";
		$scope.inputNotes = "";
		$scope.createInputError0=false;
		$scope.createInputError1=false;
		$scope.createInputError2=false;
		$scope.createInputError3=false;
		$scope.uploadPersonaError= false;
	}
	$scope.deactivateMedia = function(id) {
		mediaService.deactivate(id, function(data){
			if($scope.showFlag == false){
				mediaService.getActivedata(function(data) {
					$scope.medias = data;
					for (var i = 0, length = $scope.medias.length; i < length; i++) {
						$scope.editingData[$scope.medias[i].mediaId] = false;
					}
				});
			}
			else if($scope.showFlag == true){
				mediaService.getdata(function(data) {
					$scope.medias = data;
					for (var i = 0, length = $scope.medias.length; i < length; i++) {
						$scope.editingData[$scope.medias[i].mediaId] = false;
					}
				});
				
			}
		});
	}
	
	$scope.activateMedia = function(id) {
		mediaService.activate(id, function(data){
			mediaService.getActivedata(function(data) {
				$scope.medias = data;
				for (var i = 0, length = $scope.medias.length; i < length; i++) {
					$scope.flag[$scope.medias[i].mediaId] = false;
				}				
			});
		});
	};
	
	$scope.updateMedia = function(media) {
		if($scope.editMedia.intervieweeName != 0 && $scope.editMedia.techiniqueUsed != null && $scope.editMedia.jobType !=0 && $scope.editMedia.jobType !=null && $scope.editMedia.inputNotes !=0 && $scope.editMedia.inputNotes !=null){
			mediaService.updateMedia(media,function(){
				if($scope.showFlag){
					$scope.getMedia();
				}else{
					$scope.getActiveMedias();
				}
			});
			$scope.showEdit=false;
			$scope.updateMediaError0=false;
			$scope.updateMediaError1=false;
			$scope.updateMediaError2=false;
			$scope.updateMediaError3=false;
			$scope.uploadPersonaError= false;
		}
		if($scope.editMedia.intervieweeName == 0 || $scope.editMedia.intervieweeName == null ){
			$scope.updateMediaError0=true;
		}else{
			$scope.updateMediaError0=false;
		}
		if($scope.editMedia.techiniqueUsed == 0 || $scope.editMedia.techiniqueUsed == null ){
			$scope.updateMediaError1=true;
		}else{
			$scope.updateMediaError1=false;
		}
		if($scope.editMedia.jobType ==0 || $scope.editMedia.jobType ==null){
			$scope.updateMediaError2=true;
		}else{
			$scope.updateMediaError2=false;
		}
		if($scope.editMedia.inputNotes ==0 || $scope.editMedia.inputNotes == null){
			$scope.updateMediaError3=true;
		}else{
			$scope.updateMediaError3=false;
		}
	};
	
	$scope.cancelUpdateMedia=function(){
		$scope.showEdit=false;
		$scope.updateMediaError1=false;
		$scope.updateMediaError2=false;
		$scope.updateMediaError3=false;
		$scope.random = "";
		$scope.uploadedDocuments = "";
		$scope.techiniqueUsed="";
		$scope.jobType = "";
		$scope.inputNotes = "";
	}
	
	$scope.showAddObservation = false;	   
	$scope.add = function(jobType, mediaInputs, mediaId){
		$scope.showAddObservation = true;
		$scope.viewObsrve = false;
		$scope.showEditObsrve = false;
		$scope.mediaInputs = mediaInputs;
		$scope.jobType = jobType;
		$scope.mediaId = mediaId;
	}
	
	$scope.uploadMedia = function(file, mediaType, mediaId){
		if(file != null){
			var fileName= file.name;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(mediaType == 1 ){
				if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"){
					mediaService.uploadMedia(file, mediaType,mediaId, $scope.random, function(data){
						$scope.uploadedDocuments = data;
					});
				}else{
					alert("Upload Images only");
				}
			}
			else if(mediaType == 2){
				if(ext == "mp3" || ext == "MP3"){
					alert("Success");	
					mediaService.uploadMedia(file, mediaType,mediaId, $scope.random, function(data){
						$scope.uploadedDocuments = data;
					});
				}else{
					alert("Upload mp3s only");
				}
			}
			else if(mediaType == 3){
				if( ext == "mp4" || ext =="MP4" || ext == "wmv" || ext == "WMV"){
					alert("Success!!");
					mediaService.uploadMedia(file, mediaType,mediaId, $scope.random, function(data){
						$scope.uploadedDocuments = data;
					});
				} 
				else{
					alert("Upload Videos only");
				}
			}
		}else{
			alert("Please Upload an media")
		}	
		
	} 
	
/*	$scope.checkPersona= function(file){
		if(file != null){
			var fileName= file.name;
			var uploadedResult= false;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if( ext == "doc" || ext =="DOC" || ext == "pdf" || ext == "PDF" || ext == "docx" || ext == "DOCX"){
				alert("Success!!");
				uploadedResult= true;
			} 
			else{
				alert("Upload Documents only");
				uploadedResult= false;
			}
		}else{
			alert("Please Upload Persona Document");
			uploadedResult= false;
		}
		return uploadedResult;
	}*/
	
	$scope.uploadPersona = function(file, mediaId){
		if(file != null){
			var fileName= file.name;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if( ext == "doc" || ext =="DOC" || ext == "pdf" || ext == "PDF" || ext == "docx" || ext == "DOCX"){
				mediaService.uploadPersona(file, mediaId, $scope.random, function(data){
					$scope.uploadedPersonaDocuments = data;
					$scope.uploadPersonaError= false;
				});	
			} 
			else{
				alert("Upload Documents only");
				$scope.uploadPersonaError= false;
			}
		}else{
			alert("Please select a file first");
			$scope.uploadPersonaError= true;
		}
	} 
	
	$scope.removeDocument = function(document){
		mediaService.removeDocument(document, function(data){
			$scope.uploadedDocuments=data;
		});
	} 
	
	$scope.removePersonaDocument = function(personaDocument){
		mediaService.removePersonaDocument(personaDocument, function(data){
			$scope.uploadedPersonaDocuments=data;
			$scope.uploadPersonaError= false;
		});
	} 
	
	$scope.showMediaDocuments = function(mediaId) {
		mediaService.showMediaDocuments(mediaId, function(data) {
			$scope.uploadedDocuments = data;
		})
	};

	$scope.showPersonaDocuments = function(mediaId) {
		mediaService.showPersonaDocuments(mediaId, function(data) {
			$scope.uploadedPersonaDocuments = data;
			$scope.uploadPersonaError= false;
		})
	};
	
	$scope.showDocument = function(personaDocument){
		mediaService.downloadAttachements(personaDocument, function(url){
			$scope.docurl= $sce.trustAsResourceUrl(url);
		});
	};
	
	$scope.downloadTemplate = function(){
		mediaService.downloadTemplates( function(url){
			//$scope.templateurl= $sce.trustAsResourceUrl(url);
			$scope.templateurl = url;
		});
	};
	//...................................Observations ..............................
	$scope.showFlagObserve = false;
	$scope.getObservations = function() {
		$scope.showFlagObserve =false;
			observationService.getdata(function(data) {
				$scope.observations = data;// populates the view
			})
		};
		/*** show all observation  **/
		$scope.getAllObservations = function() {
			$scope.showFlagObserve = true;
			observationService.getAlldata(function(data) {
				$scope.observations = data;// populates the view
			})
		};
		
		$scope.getObsCategory=function(){
			observationService.getObsCategory(function(data) {
				$scope.categories = data;
			})
		};
		
		$scope.deactivate = function(observationID) {
			observationService.deleteObservation(observationID, function(){
				if($scope.showFlagObserve == false){
					observationService.getdata(function(data) {
						$scope.observations = data;
						for (var i = 0, length = $scope.observations.length; i < length; i++) {
							$scope.editingData[$scope.observations[i].observationID] = false;
						}
					});
				}
				else if($scope.showFlagObserve == true){
					observationService.getAlldata(function(data) {
						$scope.observations = data;
						for (var i = 0, length = $scope.observations.length; i < length; i++) {
							$scope.editingData[$scope.observations[i].observationID] = false;
						}
					});
				}
			});
		}
			
		/*** activate observation **/
		$scope.activate = function(observationID) {
			observationService.activateObservation(observationID,function(){
				observationService.getdata(function(data) {
					$scope.observations = data;// populates the view
					for (var i = 0, length = $scope.observations.length; i < length; i++) {
						$scope.editingData[$scope.observations[i].observationID] = false;
					}
				});
				});
		};
		
		/** Add Observation**/
		$scope.showAddObservation = false;
		$scope.addObservation = function(mediaId) {
			if($scope.jobType != 0 && $scope.jobType != null && $scope.mediaInputs != 0 && $scope.mediaInputs != null && $scope.observationCategoryID != 0 && $scope.observationCategoryID != null && $scope.observationNotes != 0 && $scope.observationNotes != null){
				observationService.addObservation($scope.mediaName,$scope.observationCategoryID,$scope.observationNotes, mediaId,userService.getUser(),function() {	
					$scope.showAddObservation = !$scope.showAddObservation;
					$scope.showEditObsrve = false;
			        $scope.getObservations();
			        $scope.mediaName = "";
			        $scope.observationCategoryID = "";
			    	$scope.observationNotes = "";
			    	$scope.createObservationError1=false;
			    	$scope.createObservationError2=false;
			    	$scope.createObservationError3=false;
			    	$scope.createObservationError4=false;
			    	//$scope.showAddObservation=false;
				});
			}
			if($scope.jobType == 0 || $scope.jobType == null){
				$scope.createObservationError1=true;
			}else{
				$scope.createObservationError1=false;
			}
		    if($scope.mediaInputs == 0 || $scope.mediaInputs == null){
		    	$scope.createObservationError2=true;
		    }else{
		    	$scope.createObservationError2=false;
		    }
		    if($scope.observationCategoryID == 0 || $scope.observationCategoryID == null){
		    	$scope.createObservationError3=true;	
		    }else{
		    	$scope.createObservationError3=false;
		    }
		    if($scope.observationNotes == 0 || $scope.observationNotes == null){
		    	$scope.createObservationError4=true;	
		    }else{
		    	$scope.createObservationError4=false;
		    }
		}
		
		$scope.cancelAddObservation=function(){
			$scope.showAddObservation= false;
			$scope.createObservationError1=false;
	    	$scope.createObservationError2=false;
	    	$scope.createObservationError3=false;
	    	$scope.createObservationError4=false;
		}
		
		$scope.showEditObsrve = false;
		$scope.editObservation = function(observation){
			$scope.showEditObsrve = true;
			$scope.showAddObservation = false;
			$scope.viewObsrve = false;
			$scope.showAddObservation = false;
			$scope.editObservationDtls = observation;
		}
		
		$scope.update = function(observation) {
			if($scope.editObservationDtls.observationCategoryID != 0 && $scope.editObservationDtls.observationCategoryID !=null && $scope.editObservationDtls.observationNotes != 0 && $scope.editObservationDtls.observationNotes !=null){
				observationService.updateObservation(observation, function(){
					observationService.getdata(function(data) {
						$scope.observations = data;// populates the view
						$scope.showEditObsrve=false;
						$scope.updateObservationError1=false;
						$scope.updateObservationError2=false;
					})
				});	
			}
			if($scope.editObservationDtls.observationCategoryID == 0 || $scope.editObservationDtls.observationCategoryID ==null){
				$scope.updateObservationError1=true;
			}else{
				$scope.updateObservationError1=false;
			}
			if($scope.editObservationDtls.observationNotes == 0 || $scope.editObservationDtls.observationNotes ==null){
				$scope.updateObservationError2=true;
			}else{
				$scope.updateObservationError2=false;
			}
		};
		
		$scope.cancelUpdate=function(){
			$scope.showEditObsrve=false;
			$scope.updateObservationError1=false;
			$scope.updateObservationError2=false;
		}

		$scope.viewObservation = false;
		$scope.view = function(observation){
			$scope.viewObsrve = true;
			$scope.showAddObservation = false;
			$scope.showEditObsrve = false;
			$scope.viewObservationDtls = observation;
		}
	
		// Show Images and vedios
		
		//$scope.flag = {};
		$scope.show1 = false;
		$scope.show2 = false;
		$scope.showvedio = false;
		
		$scope.showMedia = function(mid){
			$scope.showMediaDocuments(mid);
			var video = angular.element("#video");
			video[0].pause();
			for(var i = 0; i < $scope.medias.length; i++){
				var media = $scope.medias[i];
				if($scope.medias[i].mediaId == mid){
					$scope.flag[$scope.medias[i].mediaId] = true;
				}
				else{
					$scope.flag[$scope.medias[i].mediaId] = false;
				}
			}
			$scope.show2=false;
			$scope.showvedio=false;
			$scope.show1 = true;
		}
		$scope.hideMedia = function(mid){
			$scope.flag[mid] = false;
			$scope.show1 = false;
			var video = angular.element("#video");
			video[0].pause();
			$scope.show2=false;
			$scope.showvedio=false;
		}

		$scope.showImage = function(document){
			mediaService.downloadDocument(document, function(url){
				$scope.picurl=url;
				$scope.show2 = true;
			});
		}
		
		$scope.launchMedia = function(ele, document){
			$scope.show2 = false;
			$scope.showvedio = true;
			$scope.loading = true;
			mediaService.downloadDocument(document, function(url){
				$scope.loading = false;
				$scope.picurl= $sce.trustAsResourceUrl(url);
				var video = angular.element("#video");				
			});
		}; 	
		
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
		   
	$scope.goToDefine = function(){
		var destinationPage = 'home.projects.details.empathy';
		projectService.setStage(2,destinationPage);
		
	}

})