module.controller('mediaController', function($scope, mediaService) {

	$scope.editingData = {};

	$scope.getMedia = function() {

		mediaService.getdata(function(data) {
			// alert(data);
			/*alert("media data");*/
			$scope.medias = data;
			for (var i = 0, length = $scope.medias.length; i < length; i++) {
				$scope.editingData[$scope.medias[i].mediaId] = false;
			}
		})
	}

	$scope.addMedia = function() {
		mediaService.addMedia($scope.jobType, $scope.intervieweeName,
				function() {
					$scope.getMedia();
					$scope.jobType = "";
					$scope.intervieweeName = "";
					
				});
		
	}

	$scope.modify = function(media) {
		$scope.editingData[media.mediaId] = true;
	};

	$scope.update = function(media) {
		$scope.editingData[media.mediaId] = false;
		//update project
		/*alert("updated value: "+ media.intervieweeName);*/
		mediaService.updateMedia(media.mediaId, media.intervieweeName);

	};
	
	
	$scope.selectMedia = function(media){
		/*alert(media.intervieweeName);*/
		mediaService.setIntervieweeName(media.intervieweeName);
	};
	
	 /*$scope.deleteMedia = function(media){
		 alert("Delete Data" +media.mediaId);    	
	    	mediaService.deleteMedia(media.mediaId);
	    	alert("After Delete Data" +media.mediaId);
	    };*/
	    $scope.deleteMedia = function(media){
			/*alert(media.mediaId);*/
			mediaService.deleteMedia(media.mediaId);
		};



})