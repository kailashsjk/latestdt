module.controller('prototypingController', function($scope, $location, $state, projectService) {
	$scope.showCapturePrototype = false;
	$scope.showPropotypesFlag = true;
	$scope.getActivePrototypes = function(){
		$scope.showPropotypesFlag = !$scope.showPropotypesFlag;
		$scope.prototypings = [ {
			"prototypeId" : 1,
			"questionDescription" : "HMW enable Erica to appear knowledgeable and be Independent to deal with any situation?",
			"ideaDescription" : "Self Care Mobile App",
			"prototypeDescription" : "Mobile App",
			"createdDate" : "2016-07-17",
			"deleteFlag" : 0
		}];
	};
	$scope.getPrototypes = function(){
		$scope.showPropotypesFlag = !$scope.showPropotypesFlag;
		$scope.prototypings = [ {
			"prototypeId" : 1,
			"questionDescription" : "HMW enable Erica to appear knowledgeable and be Independent to deal with any situation?",
			"ideaDescription" : "Self Care Mobile App",
			"prototypeDescription" : "Mobile App",
			"createdDate" : "2016-07-17",
			"deleteFlag" : 0
		}, {
			"prototypeId" : 2,
			"questionDescription" : "HMW enable Erica to appear knowledgeable and be Independent to deal with any situation?",
			"ideaDescription" : "On Call Car Help",
			"prototypeDescription" : "Call service",
			"createdDate" : "2016-07-17",
			"deleteFlag" : 0
		} ];
	};
	$scope.hmws = [ {
		"sno" : 1,
		"question" : "HMW enable Erica to appear knowledgeable Self Help aids to trouble shoot most common vehicle operations and issues"
	}/*, {
		"sno" : 2,
		"question" : "HMW enable Erica to be Independent and deal with any situation"
	}, {
		"sno" : 3,
		"question" : "HMW enable Erica to trust her machinic, how can we help her find the best service place"
	}*/ ];
	
	$scope.ideas = [{
		"ideaId" : 2,
		"questionDescription" : "HMW enable Erica to appear knowledgeable...",
		"ideaDescription" : "Self Care Mobile App",
		"ideaCategoryDescription" : "sample",
		"createDate" : "2016-07-17",
		"finalizeIdea" : "y"
	}, {
		"ideaId" : 3,
		"questionDescription" : "",
		"ideaDescription" : "On Call Car Help",
		"ideaCategoryDescription" : "sample",
		"createDate" : "2016-07-17",
		"finalizeIdea" : "y"
	}];
	
	
	
	
	
	/*$scope.flag = {};
	
	for (var i = 0, length = $scope.prototypings.length; i < length; i++) {
		$scope.flag[$scope.prototypings[i].prototypeId] = false;
	}*/
	
	$scope.show1 = false;
	$scope.showMedia = function(pid){
		$scope.flag[pid] = !$scope.flag[pid];
		if(pid == 1){
			$scope.show3 = false;	
			$scope.show1 = !$scope.show1;			
		}
		else{
			$scope.show1 = false;
			$scope.show3 = !$scope.show3;
		}
					
	}
	$scope.show = false;
	$scope.showPrototype = function(hmw,idea){
		$scope.show = true;
		$scope.hmw = hmw;
		$scope.idea = idea;
	}
	
	$scope.show2 = false;
	$scope.media = false;
	$scope.showImage = function(pic){
		$scope.show2 = true;
		$scope.picurl = pic;
	}
	$scope.show3 = false;
	$scope.show4 = false;
	$scope.showImage1 = function(pic){
		$scope.show4 = true;
		$scope.picurl1 = pic;
	}
	
	$scope.goToTest = function(){
		$state.go('home.projects.details.prototype_Feedback');
		projectService.setStage(5);
	};
	/*$scope.$watch('goToPrototype', function() {
        // do something here
		
       // alert("stage : 5");
    }, true);*/
})