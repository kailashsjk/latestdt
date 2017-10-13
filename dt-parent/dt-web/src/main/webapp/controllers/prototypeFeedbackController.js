module.controller('prototypeFeedbackController', function($scope,$sce,$state,prototypeFeedbackService, userService,prototypeService,projectService){
	var user= userService.getUser();
	$scope.project = projectService.getProject();
	$scope.prototypeFeedbackError=false;
    $scope.getActivePrototypes = function() {  
    	
		if(g_temp_data)
		{
			$scope.prototypeDatas = temp_prototype_feedback_list_active;			
		}
		else
		{
	    	prototypeFeedbackService.getPrototypeData(function(data) {			
				$scope.prototypeDatas = data;
				for (var i = 0, length = $scope.prototypeDatas.length; i < length; i++) {
					$scope.flag[$scope.prototypeDatas[i].prototypeId] = false;
				}
			})
		}
	}; 
	
	$scope.addPrototypeFeedback = function(prototypeId) {		
		
		/*alert($scope.projectStageVal);*/
		if($scope.prototypeFeedbackDescription != 0 && $scope.prototypeFeedbackDescription != null){
			prototypeFeedbackService.addPrototypeFeedback($scope.prototypeFeedbackDescription,$scope.prototypeId,$scope.check,$scope.projectStageVal,projectService.getProject(),user,
					function() {			
						$scope.getActivePrototypes();
						$scope.prototypeFeedbackDescription = "";				
						$scope.prototypeId="";
						$scope.check="";
						$scope.projectStageVal="";
						$scope.show = false;
					});	
			$scope.prototypeFeedbackError=false;
		}else{
			$scope.prototypeFeedbackError=true;
		}	
	}

	$scope.cancelAddPrototypeFeedback=function(){
		$scope.prototypeFeedbackDescription = "";				
		$scope.prototypeId="";
		$scope.check="";
		$scope.projectStageVal="";
		$scope.show = false;
		$scope.prototypeFeedbackError=false;
	}
     
    $scope.flag = {};
    $scope.showModal = false;
 	$scope.toggleModal = function(){
		$scope.showModal = !$scope.showModal;
 	}
 	 
 	$scope.accept=false;
 	$scope.reject=false;
 	$scope.show = false;
 	
	$scope.showFeedback = function(igname,prototypeDescription,prototypeId,prototypeFeedbackDescription,feedbackStatus){
		$scope.show = true;
		$scope.igname = igname;
		$scope.prototypeFeedbackDescription=prototypeFeedbackDescription;
		$scope.prototypeDescription = prototypeDescription;
		$scope.prototypeId = prototypeId;
		$scope.check = feedbackStatus;
		$scope.projectStageVal = 1;
		if(feedbackStatus==1){
			$scope.accept = true;
			$scope.reject = false;
		}else{
			$scope.reject = true;
			$scope.accept = false;
		}
		
	} 	
	
	$scope.getProjectStages = function() {
		projectService.getProjectStages(function(data) {
			$scope.projectStages = data;
		})
	};	
	$scope.showPrototypeDocuments = function(prototypeId) {
		prototypeService.showPrototypeDocuments(prototypeId, function(data) {
			$scope.uploadedDocuments = data;
		})
	};
	
	$scope.show1 = false;
	$scope.show2 = false;
	$scope.showvedio = false;
	$scope.loading = false;
	$scope.showMedia = function(pfid,pid){
		$scope.showPrototypeDocuments(pid);
		for(var i = 0; i < $scope.prototypeDatas.length; i++){
			if($scope.prototypeDatas[i].prototypeFeedbackID == pfid){
				$scope.flag[$scope.prototypeDatas[i].prototypeFeedbackID] = true;
			}
			else{
				$scope.flag[$scope.prototypeDatas[i].prototypeFeedbackID] = false;
			}
		}
		$scope.show2=false;
		$scope.showvedio=false;
		$scope.show1 = true;				
	}
	$scope.hideMedia = function(pid){
		$scope.flag[pid] = !$scope.flag[pid];
		$scope.show1 = !$scope.show1;
	}

	$scope.showImage = function(document){
		$scope.loading = true;
		prototypeService.downloadDocument(document, function(url){
			$scope.picurl=url;
			$scope.show2 = true;
			$scope.loading = false;
		});
	}
	
	$scope.launchMedia = function(ele, document){
		$scope.show2 = false;
		$scope.showvedio = true;
		$scope.loading = true;
		prototypeService.downloadDocument(document, function(url){
			$scope.loading = false;
			$scope.picurl= $sce.trustAsResourceUrl(url);
			var video = angular.element("#video");
			video[0].play();
		});
	}; 
	
	$scope.updateProjectStage= function(){
		//$state.go('home.projects.details.prototype_Feedback');
		var destinationPage;
		/*alert($scope.projectStageVal);*/
		if($scope.projectStageVal == 0)
			destinationPage = "home.projects.details";
		else if($scope.projectStageVal == 1)
			destinationPage = "home.projects.details.media";
		else if($scope.projectStageVal == 2)
			destinationPage = "home.projects.details.empathy";
		else if($scope.projectStageVal == 3)
			destinationPage = "home.projects.details.ideas";
		else if($scope.projectStageVal == 4)
			destinationPage = "home.projects.details.prototype";
		else if($scope.projectStageVal == 5)
			destinationPage = "home.projects.details.prototype_Feedback";
		projectService.setStageByForcebly($scope.projectStageVal, destinationPage);
	}
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
	
	$scope.view=function(prototypeFeedback){
		$scope.showview=true;
		$scope.prototypeFeedbackView=prototypeFeedback;
	}
	$scope.closeProject = function(){
		if(confirm("Are you sure, you want to close the Project?")){
			projectService.deactivate(projectService.getProject().projectId, function(){
				alert("Project closed successfully.");
				$state.go("home.projects");				
			});
		}
	}
})