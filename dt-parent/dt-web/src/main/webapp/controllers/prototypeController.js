module.controller('prototypeController', function($scope, $sce, prototypeService, $state,userService, projectService) {
	
	$scope.loading = false;
	$scope.showCapturePrototype = false;
	$scope.project = projectService.getProject();
	$scope.editingData = {};
	$scope.showFlag = true;
	$scope.random = "";
	$scope.mediaType=1;
	$scope.createPrototypeError1=false;
	$scope.createPrototypeError2=false;
	
    $scope.getActivePrototypes = function() {
    	$scope.showFlag = false;
		prototypeService.getdata(function(data) {
			$scope.prototyping = data;
			for (var i = 0, length = $scope.prototyping.length; i < length; i++) {
				$scope.flag[$scope.prototyping[i].prototypeId] = false;
			}
		})
	}; 
	
	
	$scope.getAllPrototype = function() {
	$scope.showFlag = true;
		prototypeService.getAlldata(function(data) {
			$scope.prototyping = data;
			for (var i = 0, length = $scope.prototyping.length; i < length; i++) {
				$scope.flag[$scope.prototyping[i].prototypeId] = false;
			}
		})
	}; 

	$scope.getIGID = function() {
		prototypeService.getdataIGID(function(data) {
			$scope.ideaGroup = data;// populates the view
		});
	}
	
	$scope.createPrototype=function(){
		$scope.showCapturePrototype=true;
		$scope.showEdit=false
		$scope.showView=false;
		$scope.random = Math.random().toString(16).slice(5, 15);
	}
	
	$scope.cancelPrototype=function(){
		$scope.showCapturePrototype=false;
		$scope.random = "";
		$scope.createPrototypeError1=false;
		$scope.createPrototypeError2=false;
	}
	
	$scope.addPrototype = function(data) {
		if($scope.data.igroup1 != 0 && $scope.data.igroup1 != null && $scope.data.proDescription !=0 && $scope.data.proDescription != null){
			prototypeService.addPrototype(data.igroup1,data.proDescription,userService.getUser(),$scope.random,
					function() {
				$scope.showCapturePrototype = !$scope.showCapturePrototype;
				$scope.getActivePrototypes();
				$scope.ideaGroup = "";
				$scope.proDescription = "";
				$scope.showCapturePrototype=false;
				$scope.random = "";
				$scope.createPrototypeError1=false;
				$scope.createPrototypeError2=false;
			});
		}
		if($scope.data.igroup1 == 0 || $scope.data.igroup1 == null){
			$scope.createPrototypeError1=true;
		}else{
			$scope.createPrototypeError1=false;
		}if($scope.data.proDescription ==0 || $scope.data.proDescription == null){
			$scope.createPrototypeError2=true;
		}else{
			$scope.createPrototypeError2=false;
		}
	}
	

	$scope.modify = function(prototyping) {
		$scope.editingData[prototyping.prototypeId] = true;
		$scope.random = Math.random().toString(16).slice(5, 15);
	};
	

	$scope.update= function(prototyping) {
		if($scope.readyForTest){
			prototyping.test = 1;
		}else{
			prototyping.test = 0;
		}
		prototypeService.updatePrototype(prototyping.prototypeId,prototyping.prototypeDescription,prototyping.test,
			function() {
	            if(prototyping.test == 1){
	            	var destinationPage = "home.projects.details.prototype_Feedback";
	            	projectService.setStage(5,destinationPage);
	            }
				$scope.getActivePrototypes();
                $scope.showEdit=false;
        	});
	};
	
	$scope.setTest= function(prototyping) {
		prototypeService.setTest(prototyping.prototypeId,
				function() {
						$scope.getActivePrototypes();
	        });
		
	};
	
	
	$scope.editPrototype={};
	
	$scope.editPrototype=false;
	$scope.edit = function(prototype){
		$scope.showEdit = true;
		$scope.showView=false;
		$scope.showCapturePrototype=false;
		$scope.readyForTest = false;
		$scope.editPrototype=prototype;
		if($scope.editPrototype.test == 1){
			$scope.readyForTest = true;
		}
		$scope.igname =prototype.igname;
		$scope.random = Math.random().toString(16).slice(5, 15);
		$scope.showPrototypeDocuments(prototype.prototypeId);
	}
	
	$scope.showEdit = false;
	$scope.showPrototype = function(igname,prototypeDescription){
		$scope.showEdit = true;
		$scope.showCapturePrototype=false;
		$scope.showView=false;
		$scope.prototypeDescription=prototypeDescription;
		$scope.igname = igname;
	}
	
		
	$scope.deletePrototype = function(prototypeId) {
		prototypeService.deletePrototype(prototypeId, function(){
			if($scope.showFlag == false){
				 $scope.getActivePrototypes();
			}
			else if($scope.showFlag == true){
				$scope.getAllPrototype();
				
			}
		});
	}
	
    $scope.activatePrototype = function(prototypeId){
		prototypeService.activatePrototype(prototypeId,function() {
		     $scope.getActivePrototypes();
		});
	};
		
    $scope.addPrototypeFeedback = function(ideaId,prototypeId) {
		prototypeService.addPrototypeFeedback($scope.prototypeFeedback,$scope.ideaId,$scope.prototypeId);
    	$scope.showFB=false;
	}
	
    $scope.uploadMedia = function(file, mediaType, prototypeId){
    	if(file != null){
			var fileName= file.name;
			var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
			if(mediaType == 1 ){
				if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"){
					prototypeService.uploadMedia(file, mediaType, prototypeId, $scope.random, function(data){
						$scope.uploadedDocuments = data;
					});
				}else{
					alert("Upload Images only");
				}
			}
			else if(mediaType == 2){
				if(ext == "mp3" || ext == "MP3"){
					alert("Success");	
					prototypeService.uploadMedia(file, mediaType, prototypeId, $scope.random, function(data){
						$scope.uploadedDocuments = data;
					});
				}else{
					alert("Upload mp3s only");
				}
			}
			else if(mediaType == 3){
				if( ext == "mp4" || ext =="MP4" || ext == "wmv" || ext == "WMV"){
					alert("Success!!");
					prototypeService.uploadMedia(file, mediaType, prototypeId, $scope.random, function(data){
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
	
	$scope.removeDocument = function(document){
		/*alert(document.mediaName+","+document.mdId);*/
		prototypeService.removeDocument(document, function(data){
			$scope.uploadedDocuments=data;
		});
	} 
	
	$scope.showPrototypeDocuments = function(prototypeId) {
		prototypeService.showPrototypeDocuments(prototypeId, function(data) {
			$scope.uploadedDocuments = data;
		})
	};
    
    /** view media **/
	$scope.view = function(prototype){
		$scope.showView = true;
		$scope.show1 = false;
		$scope.showCapturePrototype=false;
		$scope.showEdit=false;
		$scope.viewPrototype = prototype;
		$scope.showPrototypeDocuments(prototype.prototypeId);
	}
	
	$scope.setTest= function(prototyping) {
		prototypeService.setTest(prototyping.prototypeId,function() {
				$scope.getActivePrototypes();
	        });
	};
	
	$scope.flag = {};
	$scope.show1 = false;
	$scope.show2 = false;
	$scope.showvedio = false;
	
	$scope.showMedia = function(pid){
		$scope.showPrototypeDocuments(pid);
		var video = angular.element("#video");
		video[0].pause();
		for(var i = 0; i < $scope.prototyping.length; i++){
			if($scope.prototyping[i].prototypeId == pid){
				$scope.flag[$scope.prototyping[i].prototypeId] = true;
			}
			else{
				$scope.flag[$scope.prototyping[i].prototypeId] = false;
			}
		}
		$scope.show2=false;
		$scope.showvedio=false;
		$scope.show1 = true;					
	}
	$scope.hideMedia = function(pid){
		$scope.flag[pid] = false;
		$scope.show1 = false;
		var video = angular.element("#video");
		video[0].pause();
		$scope.show2=false;
		$scope.showvedio=false;
	}

	$scope.showImage = function(document){
		$scope.show2 = true;
		$scope.loading = true;
		prototypeService.downloadDocument(document, function(url){
			$scope.picurl=url;
			$scope.loading = false;
		});
	}
	
	$scope.launchMedia = function(ele, document){
		$scope.loading = true;
		$scope.show2 = false;
		$scope.showvedio = true;
		prototypeService.downloadDocument(document, function(url){
			$scope.loading = false;
			$scope.picurl= $sce.trustAsResourceUrl(url);
			
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
	
	$scope.goToTest = function(){
		$state.go('home.projects.details.prototype_Feedback');
		projectService.setStage(5);
	};
})