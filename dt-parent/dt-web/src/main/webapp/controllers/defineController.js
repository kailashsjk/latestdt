module.controller('defineController', function($scope,defineService,userService, empathyService, projectService){
	
	var user= userService.getUser();
	$scope.project = projectService.getProject();
	$scope.createNeedError=false;
	$scope.editNeedError=false;
	$scope.createInsightsError=false;
	$scope.editInsightError=false;
	$scope.createPOVError=false;
	$scope.editPOVError=false;
	
	var projectId = projectService.getProject().projectId;
	$scope.showNeedsFlag=false;
	$scope.showInsightsFlag=false;
	
	$scope.getAllNeeds=function(){
		$scope.showNeedsFlag = true;
		defineService.getAllNeeds(projectId,function(data){
			$scope.needs=data;
		});
	}
	$scope.viewpov = false;
	$scope.showView = function(questionDescription){
		$scope.viewpov = true;
		$scope.questionDescription=questionDescription;
	} 	 
	
	
	$scope.getActiveNeeds=function(){
		$scope.showNeedsFlag = false;
		defineService.getNeeds(projectId,function(data){
			$scope.needs=data;
		});
	}
	
	$scope.getAllInsights=function(){
		$scope.showInsightsFlag=true;
		defineService.getAllInsights(projectId,function(data){
			$scope.insights=data;
		});
	}
	
	$scope.getActiveInsights=function(){
		$scope.showInsightsFlag=false;
		defineService.getInsights(projectId,function(data){
			$scope.insights=data;
		});
	}
	
	$scope.showModal = false;
	$scope.toggleModal = function(){
				$scope.heading= 'Empathy';
				$scope.showModal = !$scope.showModal;
				}
	$scope.showModal1 = false;
	$scope.toggleModal1 = function(){
				$scope.heading= 'Needs & Insights';
				$scope.showModal1 = !$scope.showModal1;
				}
	$scope.showModal2 = false;
	$scope.toggleModal2 = function(){
				$scope.showModal2 = !$scope.showModal2;
				}
	
	$scope.createNeeds=function(){
		$scope.show=true;
		$scope.show1=false;
		$scope.show2=false;
		$scope.show3=false;
		$scope.showDeactivatedNeedsFlag=false;
		$scope.showDeactivatedInsightsFlag=false;
	}
	$scope.editNeeds=function(need){
		$scope.show1=true;
		$scope.show=false;
		$scope.show2=false;
		$scope.show3=false;	
		$scope.showDeactivatedNeedsFlag=false;
		$scope.showDeactivatedInsightsFlag=false;
		$scope.need=need;
	}
	$scope.createInsights=function(){
		$scope.show2=true;
		$scope.show=false;
		$scope.show1=false;
		$scope.show3=false;
		$scope.showDeactivatedNeedsFlag=false;
		$scope.showDeactivatedInsightsFlag=false;
	}
	$scope.editInsights=function(insight){
		$scope.show3=true;
		$scope.show=false;
		$scope.show1=false;
		$scope.show2=false;
		$scope.showDeactivatedNeedsFlag=false;
		$scope.showDeactivatedInsightsFlag=false;
		$scope.insight=insight;
	}
	
	$scope.addNewNeeds=function(need){
		if($scope.needsNew != 0 && $scope.needsNew != null){
			defineService.addNewNeedsOrInsightsServ($scope.needsNew,projectId,user,"N",function(){
				$scope.getActiveNeeds();
				$scope.show=false;
				$scope.createNeedError=false;
				$scope.needsNew=" ";
			});	
		}else{
			$scope.createNeedError=true;
		}
	}
	
	$scope.cancelAddNeed=function(){
		$scope.show=false;
		$scope.needsNew=" ";
		$scope.createNeedError=false;
	}
	
	$scope.editANeed=function(need){
		if($scope.need.description != 0 && $scope.need.description !=null){
			if($scope.showNeedsFlag == true){
				defineService.updateNeedsOrInsights(need.noiId,need.description,user,function(){
					$scope.getAllNeeds();
					$scope.show1=false;
				});
			}else{
				defineService.updateNeedsOrInsights(need.noiId,need.description,user,function(){
					$scope.getActiveNeeds();
					$scope.show1=false;
				});
			}
			$scope.editNeedError=false;
		}else{
			$scope.editNeedError=true;
		}
	}
	
	$scope.cancelEditNeed=function(){
		$scope.editNeedError=false;
		$scope.show1=false;
	}
	
	$scope.addNewInsights=function(){
		if($scope.insightsNew != 0 && $scope.insightsNew != null){
			defineService.addNewNeedsOrInsightsServ($scope.insightsNew,projectId,user,"I",function(){
				$scope.getActiveInsights();
				$scope.insightsNew="";
				$scope.show2=false;
				$scope.createInsightsError=false;
			});	
		}else{
			$scope.createInsightsError=true;
		}
	}
	
	$scope.cancelAddInsight=function(){
		$scope.show2=false;
		$scope.insightsNew="";
		$scope.createInsightsError=false;
	}
	
	$scope.editAnInsight=function(insight){
		if($scope.insight.description != 0 && $scope.insight.description !=null){
			if($scope.showInsightsFlag==false){
				defineService.updateNeedsOrInsights(insight.noiId,insight.description,user,function(){
					$scope.getActiveInsights();
					$scope.show3=false;
				});
			}else{
				defineService.updateNeedsOrInsights(insight.noiId,insight.description,user,function(){
					$scope.getAllInsights();
					$scope.show3=false;
				});
			}
			$scope.editInsightError=false;
		}else{
			$scope.editInsightError=true;
		}
	}
	
	$scope.cancelEditInsight=function(){
		$scope.editInsightError=false;
		$scope.show3=false;
	}

	$scope.deleteNeedOrInsight=function(noi){
		if(noi.needOrInsight=="N" && $scope.showNeedsFlag== true){
			defineService.deleteNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getAllNeeds();
			});
		}else if(noi.needOrInsight=="N" && $scope.showNeedsFlag== false){
			defineService.deleteNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getActiveNeeds();
			});
		}else if(noi.needOrInsight=="I" && $scope.showInsightsFlag== true){
			defineService.deleteNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getAllInsights();
			});
		}else if(noi.needOrInsight=="I" && $scope.showInsightsFlag== false){
			defineService.deleteNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getActiveInsights();
			});
		}
	}
	$scope.activateNeedOrInsight=function(noi){
		if(noi.needOrInsight=="N" && $scope.showNeedsFlag== false){
			defineService.activateNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getActiveNeeds();
			});
		}else if(noi.needOrInsight=="N" && $scope.showNeedsFlag== true){
			defineService.activateNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getAllNeeds();
			});
		}else if(noi.needOrInsight=="I" && $scope.showInsightsFlag== false){
			defineService.activateNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getActiveInsights();
			});
		}else if(noi.needOrInsight=="I" && $scope.showInsightsFlag== true){
			defineService.activateNeedsOrInsightsServ(noi.noiId,function(){
				$scope.getAllInsights();
			});
		}
	}
	
	/*Empathy Mapping*/
	$scope.getEmpathy = function() {
		defineService.getEmpathy(projectId,function(data) {
			$scope.doEmpathies = data.doList;
			$scope.sayEmpathies = data.sayList;
			$scope.thinkEmpathies = data.thinkList;
			$scope.feelEmpathies = data.feelList;
		})
	};
	
	// HMW Questions related code
	$scope.showPovFlag = false;
	$scope.showpov = false;
	$scope.editpov = false;
	
	$scope.getQuestions = function() {
		$scope.showPovFlag = true ;
			empathyService.getdata(projectId, function(data) {
			$scope.questions = data;// populates the view
/*			for (var i = 0, length = $scope.questions.length; i < length; i++) {
				$scope.editingData[$scope.questions[i].questionID] = false;
			}*/

		})
	};
	
	$scope.getActiveQuestions = function() {
			var projectId = projectService.getProject().projectId;
			$scope.showPovFlag = false; 
			empathyService.getActivedata(projectId, function(data) {
			$scope.questions = data;// populates the view
/*			for (var i = 0, length = $scope.questions.length; i < length; i++) {
				$scope.editingData[$scope.questions[i].questionID] = false;
			}*/

		})
	};
	
	$scope.addHmwQuestion = function() {
		$scope.showpov = true;
		$scope.editpov = false;
		var projectId = projectService.getProject().projectId;
		
		if($scope.hmwQuestion !=0 && $scope.hmwQuestion != null){
			empathyService.addHmwQuestions($scope.hmwQuestion, projectId, userService.getUser(),
					function(){
						$scope.getActiveQuestions();
						$scope.hmwQuestion = "";
					});
			$scope.createPOVError=false;
		}else{
			$scope.createPOVError=true;
		}
	};
	
	$scope.cancelAddHmw=function(){
		$scope.showpov=false;
		$scope.createPOVError=false;
		$scope.hmwQuestion = "";
	}
	
	$scope.modify = function(question) {
		$scope.showpov = false;
		$scope.editpov = !$scope.editpov;
		$scope.hmwQuestionEditable = question;
	};
	
	$scope.updateQuestion = function(question) {
		if($scope.hmwQuestionEditable.questionDescription != 0 && $scope.hmwQuestionEditable.questionDescription !=null){
			empathyService.updateHmwQuestion(question.questionID,question.questionDescription,user,function(){
				$scope.editpov = false;
				$scope.editPOVError=false;
				if($scope.showPovFlag){
					$scope.getQuestions();
				}else{
					$scope.getActiveQuestions();
				}
			});
			
		}else{
			$scope.editPOVError=true;
		}
	};
	
	$scope.cancelUpdateHmw=function(){
		$scope.editpov = false;
		$scope.editPOVError=false;
	}
	
	$scope.deactivate = function(id) {
		var projectId = projectService.getProject().projectId;
		empathyService.deactivate(id, function(data){
			empathyService.getActivedata(projectId,function(data) {
				$scope.questions = data;
				/*for (var i = 0, length = $scope.questions.length; i < length; i++) {
					$scope.editingData[$scope.questions[i].projectId] = false;
				}*/
			});
			});
	};
	
	
	$scope.deactivate = function(id) {
		/*alert($scope.showPovFlag);*/
		var projectId = projectService.getProject().projectId;
		empathyService.deactivate(id, function(data){
				if($scope.showPovFlag == false){
					/*alert("Inisde if");*/
					empathyService.getActivedata(projectId,function(data) {
					/*alert("Inisde if,after service");*/
					$scope.questions = data;
					/*for (var i = 0, length = $scope.projects.length; i < length; i++) {
						$scope.editingData[$scope.projects[i].projectId] = false;
					}*/
				});
				}
				else if($scope.showPovFlag == true){
					/*alert("Inisde else");*/
					empathyService.getdata(projectId,function(data) {
						/*alert("Inisde else,after service");*/
						$scope.questions = data;
						/*for (var i = 0, length = $scope.projects.length; i < length; i++) {
							$scope.editingData[$scope.projects[i].projectId] = false;
						}*/
					});
					
				}
				});
		}
	
	
	
	
	$scope.activate = function(id) {
		var projectId = projectService.getProject().projectId;
		empathyService.activate(id, function(data){
			empathyService.getActivedata(projectId,function(data) {
				$scope.questions = data;
				/*for (var i = 0, length = $scope.questions.length; i < length; i++) {
					$scope.editingData[$scope.questions[i].projectId] = false;
				}*/
			});
			});
	};
	
	
	$scope.goToIdeate = function(){
		var destinationPage = 'home.projects.details.ideas';
		projectService.setStage(3,destinationPage);
		
	}
	
	$scope.viewDeactivatedNeed=function(need){
		$scope.showDeactivatedNeedsFlag=true;
		$scope.show=false;
		$scope.show1=false;
		$scope.show2=false;
		$scope.show3=false;
		$scope.showDeactivatedInsightsFlag=false;
		$scope.showDeactivatedNeed=need.description;
	}
	$scope.viewDeactivatedInsight=function(insight){
		$scope.showDeactivatedInsightsFlag=true;
		$scope.showDeactivatedNeedsFlag=false;
		$scope.show=false;
		$scope.show1=false;
		$scope.show2=false;
		$scope.show3=false;
		$scope.showDeactivatedInsight=insight.description;
	}
})