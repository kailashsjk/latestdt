module.controller('ideasController', function($scope, ideaService, $state,projectService,userService){
	$scope.showIdeaFlag = false;
	$scope.showEditIdea = false;
	$scope.createIdeaError= false;
	$scope.showViewIdea=false;
	$scope.updateIdeaError=false;
	$scope.createFeedbackError1=false;
	$scope.createFeedbackError2=false;
	$scope.createIGError=false;
	$scope.updateIGError=false;
	$scope.check=1
	
	$scope.project = projectService.getProject();
	var projectId=projectService.getProject().projectId;
	var user=userService.getUser();
	$scope.getIdeaFeedback = function(){
		if(g_temp_data){
				$scope.ideaFeedbacks = temp_ideas_feedbacks_list_all;			
			}else{
				ideaService.getIdeaFeedbackdata(function(data) {
					$scope.ideaFeedbacks = data;			
				})
			}
	}

	$scope.addIdeaFeedbacks = function(ideaId) {
		if($scope.ideaCategoryId != 0 && $scope.ideaCategoryId != null && $scope.ideaFeedbackDescription != 0 && $scope.ideaFeedbackDescription != null){
				ideaService.addIdeaFeedback( $scope.ideaFeedbackDescription,$scope.ideaCategoryId,$scope.ideaId,$scope.check,user, function() {
					$scope.getIdeaFeedback();
					$scope.ideaFeedbackDescription = "";
					$scope.ideaCategoryId="";
					$scope.ideaId="";
					$scope.check="";
					$scope.createFeedbackError1=false;
					$scope.createFeedbackError2=false;
					$scope.show1=false;
				});	
		}
		if($scope.ideaCategoryId == 0 || $scope.ideaCategoryId == null ){
			$scope.createFeedbackError1=true;
		}else{
			$scope.createFeedbackError1=false;
		}
		if($scope.ideaFeedbackDescription == 0 || $scope.ideaFeedbackDescription == null){
			$scope.createFeedbackError2=true;
		}else{
			$scope.createFeedbackError2=false;
		}
	}
	
	$scope.cancelAddIdeaFeedback=function(){
		$scope.ideaFeedbackDescription = "";
		$scope.ideaCategoryId="";
		$scope.ideaId="";
		$scope.check="";
		$scope.createFeedbackError1=false;
		$scope.createFeedbackError2=false;
		$scope.show1=false;
	}

	$scope.getIdeaCategory = function() {  
	    if(g_temp_data){
	           $scope.ideaCategory = temp_ideas_category_list_all;                  
	    }else {
	    	ideaService.getIdeaCategoryData(function(data){               
	                  $scope.ideaCategory = data;              
	    	})
	    }
	}

	$scope.showView = function( ideaDescription){
		//$scope.show1 = true;
	$scope.showViewIdea=true;
		$scope.ideaDescription = ideaDescription;
	
		//$scope.ideaId = ideaId;
	}	
	
	$scope.activeIdeas = function(){
		$scope.showIdeaFlag = false;
		if(g_temp_data){
			$scope.ideas = temp_ideas_list_active;
		}else{
				ideaService.getdata(function(data) {
					$scope.ideas = data;// populates the view
					/*for (var i = 0, length = $scope.ideas.length; i < length; i++) {
						$scope.editingData[$scope.ideas[i].ideaId] = false;
					}*/
				})			
		}
	};
	
	$scope.addIdea = function() {
		if($scope.idea != 0 && $scope.idea != null){
			ideaService.addIdea($scope.idea,$scope.projectId,user,function() {
		        $scope.show = false;
				$scope.activeIdeas();
				$scope.show=false;
				$scope.idea = "";
				$scope.createIdeaError= false;
			});
		}else{
			$scope.createIdeaError= true;
		}
	};
	
	$scope.cancelAddIdea=function(){
		$scope.show=false;
		$scope.idea = "";
		$scope.createIdeaError= false;
	}
	
	$scope.allIdeas = function(){
		$scope.showIdeaFlag = true;
		if(g_temp_data){
			$scope.ideas = temp_ideas_list_all;
		}else{
			ideaService.getalldata(function(data) {
				$scope.ideas = data;// populates the view
				/*for (var i = 0, length = $scope.ideas.length; i < length; i++) {
					$scope.editingData[$scope.ideas[i].ideaId] = false;
				}*/
			})
		}
	};

	//Deavtivate Ideas	
	$scope.deactivate = function(ideaId){
		if($scope.showIdeaFlag == true){
			ideaService.deactivate(ideaId,function(){
				$scope.allIdeas();
			});
		}else if($scope.showIdeaFlag == false){
			ideaService.deactivate(ideaId,function(){
				$scope.activeIdeas();
			});
		}
	};
	
	
	$scope.activate = function(ideaId){
			/*ideaService.activate(ideaId,function(){
				$scope.activeIdeas();
			});*/
		ideaService.activate(ideaId,function(){
			if($scope.showIdeaFlag == true){
				$scope.allIdeas();	
			}
		})
	};
	
	$scope.updateIdea = function(idea) {
		if($scope.ideaEdit.ideaDescription != 0 && $scope.ideaEdit.ideaDescription != null){
			ideaService.updateIdeas(idea.ideaDescription,idea.ideaId,user,function(){
				$scope.showEditIdea =false;
				$scope.updateIdeaError=false;
				if($scope.showIdeaFlag){
					$scope.allIdeas();
				}else{
					$scope.activeIdeas();
				}
			});
			
		}else{
			$scope.updateIdeaError=true;
		}
	};
	
	$scope.cancelUpdateIdea=function(ideaEdit){
		$ideaEdit = 
		$scope.showEditIdea =false;
		$scope.updateIdeaError=false;
	}
	
	$scope.editIdea = function(idea){
		$scope.showEditIdea = true;
		$scope.ideaEdit = idea;
	};
	
	$scope.show1 = false;
	$scope.showFeedback = function( ideaDescription,ideaId){
		$scope.show1 = true;
	
		$scope.ideaDesc = ideaDescription;
		$scope.ideaId = ideaId;
	}
	$scope.goToPrototype = function(){
		var destinationPage = 'home.projects.details.prototype';
		projectService.setStage(4,destinationPage);
	};
	/*$scope.$watch('goToPrototype', function() {
        // do something here
		
        //alert("stage : 4");
    }, true);*/
	//................................Idea group related functions......................................

	$scope.showIdeaGroupFlag = false;
	$scope.showEditIdeaGroup = false;
	
	$scope.allIdeaGroups = function(){
		$scope.showIdeaGroupFlag = true;
		
		if(g_temp_data){
			$scope.ideaGroupLists = temp_ideas_group_list_all;
		}else{
			$scope.ideaGroupLists = temp_ideas_group_list_all;
		}		
	};
	$scope.activeIdeaGroups = function(){
		$scope.showIdeaGroupFlag = false;
/*		if(g_temp_data)
		{
			$scope.ideaGroupLists = temp_ideas_group_list_active;
		}
		else*/
		{
			//alert("In controller");
			ideaService.getIdeaGroupData(function(data) {
				$scope.ideaGroupLists = data;
				//alert(ideaGroupLists);
				/*for (var i = 0, length = $scope.ideaGroupLists.length; i < length; i++) {
					$scope.editingData[$scope.ideaGroupLists[i].igid] = false;
				}*/
			})		
		}	
	};
	
	
	$scope.allIdeaGroups = function(){
		$scope.showIdeaGroupFlag = true;
		if(g_temp_data){
			$scope.ideaGroupLists = temp_ideas_group_list_active;
		}else{
			//alert("In controller");
			ideaService.getAllIdeaGroupData(function(data) {
				$scope.ideaGroupLists = data;
				//alert(ideaGroupLists);
				/*for (var i = 0, length = $scope.ideaGroupLists.length; i < length; i++) {
					$scope.editingData[$scope.ideaGroupLists[i].igid] = false;
				}
			*/
			})		
		}	
	};
	
	$scope.addIdeaGroup = function() {
		if($scope.ideagname != 0 && $scope.ideagname != null){
			ideaService.addIdeaGroup($scope.ideagname,$scope.projectId, user, function() {
		        $scope.show = !$scope.show;
				$scope.activeIdeaGroups();
			    $scope.ideagname = "";
				$scope.showCreateIdeaGroup=false;
				$scope.show=false;
				$scope.show1=false;
				$scope.createIGError=false;
	});
		}else{
			$scope.createIGError=true;
		}
	};
	
	$scope.cancelAddIdeaGroup=function(){
			$scope.ideagname = "";
			$scope.showCreateIdeaGroup=false;
			$scope.createIGError=false;
	}

	$scope.updateIdeaGroups = function(ideaGroup) {
		if($scope.ideaGroupEdit.igname != 0 && $scope.ideaGroupEdit.igname != null){
			ideaService.updateIdeaGroups(ideaGroup.igname,ideaGroup.igid,function(){
				$scope.showEditIdeaGroup = false;
				$scope.updateIGError=false;
				if($scope.showIdeaGroupFlag){
					$scope.allIdeaGroups();
				}else{
					$scope.activeIdeaGroups();
				}
			});
			
		}else{
			$scope.updateIGError=true;
		}
	};
	
	$scope.cancelUpdateIdeaGroup=function(){
		$scope.showEditIdeaGroup = false;
		$scope.updateIGError=false;
	}

	$scope.editIdeaGroup = function(ideaGroup){
		$scope.showEditIdeaGroup = true;
		$scope.ideaGroupEdit = ideaGroup;
	}
	
	$scope.deactivateIdeaGroup = function(igid){
		if($scope.showIdeaGroupFlag == true){
			ideaService.deactivateIdeaGroup(igid,function(){
				$scope.allIdeaGroups();
			});
		}else if($scope.showIdeaGroupFlag == false){
			ideaService.deactivateIdeaGroup(igid,function(){
				$scope.activeIdeaGroups();
			});
		}	
	};

$scope.activateIdeaGroup = function(igid){		
		ideaService.activateIdeaGroup(igid,function(){
			if($scope.showIdeaGroupFlag == true){
				$scope.allIdeaGroups();
			}
		})
	};
	
	
	$scope.viewIdeaGroup = function( igname){
		//$scope.show1 = true;
	$scope.showViewIdeaGroup=true;
		$scope.igname = igname;
	
		//$scope.ideaId = ideaId;
	}	
	
	var ideaGroupSelected={};	
	
	
	$scope.showAssignIdea = false;
	$scope.assignIdeas = function(ideaGroup){
		$scope.showAssignIdea = !$scope.showAssignIdea;
		 ideaService.getAvailableIdeasServ(projectId,ideaGroup.igid, function (data) {
             $scope.ideas4Group = data;
         })
		ideaService.getAssignedIdeasServ(ideaGroup.igid, function (data) {
	         $scope.ideasGroup = data;
	    })
		$scope.ideaGroupName = ideaGroup.igname;
		ideaGroupSelected=ideaGroup;
	};
	
	$scope.showAssignPovs = false;
	$scope.assignPovs =function(ideaGroup){
		$scope.showAssignPovs = !$scope.showAssignPovs;
		$scope.ideaGroupName = ideaGroup.igname;
		ideaGroupSelected=ideaGroup;
		ideaService.getAvailablePOVsServ(projectId,ideaGroup.igid,function(data){
    		$scope.povs4Group=data;
    	});
		ideaService.getAssignedHmwServ(ideaGroup.igid,function(data){
			$scope.povsGroup=data;
		})
	}
	
	$scope.dropSuccessHandler = function($event,index,array){
        //alert("dropsuccess handler"+array);
        array.splice(index,1);
    };     
    $scope.onDrop = function($event,$data,array){
        //alert("drop"+array);
        array.push($data);
    };
    
    $scope.ideasGroup = [];    
    $scope.available = [];
    $scope.selected = [];

    $scope.availablepovs = [];
    $scope.selectedpovs = [];
    $scope.povsGroup = [];
    
    $scope.moveItem = function (item, from, to) {
       /* console.log('Move item   Item: ' + item + ' From:: ' + from + ' To:: ' + to);*/
        //Here from is returned as blank and to as undefined
        var idx = from.indexOf(item);
        if (idx != -1) {
            from.splice(idx, 1);
            to.push(item);
        }
    };
    $scope.moveAll = function (item, from, to) {
       /* console.log('Move item   Item: ' + item + ' From:: ' + from + ' To:: ' + to);*/
        //Here from is returned as blank and to as undefined
        for (var i = 0; i < item.length; i++) {
            var idx = from.indexOf(item[i]);
            if (idx != -1) {
                from.splice(idx, 1);
                to.push(item[i]);
            }
        }
    };
   //Assign Ideas
    $scope.updateIdeaGroup = function (ideasGroup) {
    	var igid=ideaGroupSelected.igid;
    	var ideaIds = "";
    	for (var i = 0; i < $scope.ideasGroup.length; i++) {
    		if(i == eval($scope.ideasGroup.length - 1) ){
    			ideaIds = ideaIds+$scope.ideasGroup[i].ideaId;
    		}else{
    			ideaIds = ideaIds+$scope.ideasGroup[i].ideaId+",";
    		}
    	}
    	 ideaService.updateIdeaGroupServ(igid,ideaIds,function(){
    		$scope.showAssignIdea = !$scope.showAssignIdea;
    	});
    }
    //Update POVs
    $scope.updatePOVs=function(povsGroup){
   	var igid=ideaGroupSelected.igid;
    	var questionIds="";
    	for (var i = 0; i < $scope.povsGroup.length; i++){
    		if(i== eval($scope.povsGroup.length - 1)){
    			questionIds= questionIds+$scope.povsGroup[i].questionID;
    		}else{
    			questionIds=questionIds+$scope.povsGroup[i].questionID+",";
    		}
    	}
    	ideaService.updateHMWGroupServ(igid,questionIds,function(){
    		$scope.showAssignPovs = !$scope.showAssignPovs;
    	});
    }
    $scope.tableSize1 = false;
	$scope.resize1 = 'hidden-xs';
	$scope.expand1 = function(){
		$scope.resize1 = "visible-xs";
		$scope.tableSize1 = !$scope.tableSize1;
	};
	$scope.collapse1 = function(){
		$scope.resize1 = "hidden-xs";
		$scope.tableSize1 = !$scope.tableSize1;
	}
	$scope.tableSize2 = false;
	$scope.resize2 = 'hidden-xs';
	$scope.expand2 = function(){
		$scope.resize2 = "visible-xs";
		$scope.tableSize2 = !$scope.tableSize2;
	};
	$scope.collapse2 = function(){
		$scope.resize2 = "hidden-xs";
		$scope.tableSize2 = !$scope.tableSize2;
	}
	$scope.tableSize3 = false;
	$scope.resize3 = 'hidden-xs';
	$scope.expand3 = function(){
		$scope.resize3 = "visible-xs";
		$scope.tableSize3 = !$scope.tableSize3;
	};
	$scope.collapse3 = function(){
		$scope.resize3 = "hidden-xs";
		$scope.tableSize3 = !$scope.tableSize3;
	}
    
});