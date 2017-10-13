module.controller('uploadController', function($scope, $http, $location, $window){

	$scope.show = false;
	//var documentDataFiles[];
	$scope.uploadFile = function(file){
		
		var fd = new FormData();
        fd.append('file', file);
			var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/uploadFile/1", 
											method: "POST" ,// In this case it is POST
											headers: { 'Content-Type': undefined },
											transformRequest: angular.identity,
											data: fd
			 		});
					responsePromise.success(function(data, status, headers, config) {
						$scope.documentData = data;
					});
					responsePromise.error(function(data, status, headers, config) {
						alert("AJAX failed! because no webservice is attached yet");      					 
					});
	};

$scope.download = function(documentData){
		
			var responsePromise = $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/file/downloadFile", 
											method: "POST" ,// In this case it is POST
											headers: { 'Content-Type': 'application/json' },
											responseType: 'arraybuffer',
											data: documentData
			 		});
					responsePromise.success(function(data, status, headers, config) {
						alert("Download success");
						var blob = new Blob([data], {type: "image/jpeg"});
			            var objectUrl = URL.createObjectURL(blob);
			            window.open(objectUrl);
					});
					responsePromise.error(function(data, status, headers, config) {
						alert("AJAX failed! because no webservice is attached yet");      					 
					});
	};
});