module.service("roleService", function($http, $location){
	this.gerUserRoles = function(pid, backtocontroller){
		var user = {};
		user={'project':{'projectId': pid}};
		var responsePromise = 	 $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/rolemanagementservice/getuserwithroles",
			method: "POST", // In this case it is POST
			data: user,
			headers: { 'Content-Type': 'application/json' }
		 });

		responsePromise.success(function(data, status, headers, config) {
			//alert("success in service");
			if(!angular.equals(data,null) ){
				backtocontroller(data);
			}
	        });
		responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });

	}
	
	this.submitRoles = function(pid, rows, backtocontroller){

		var responsePromise = 	 $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/rolemanagementservice/updateRoles/"+pid,
			method: "POST", // In this case it is POST
			data: rows,
			headers: { 'Content-Type': 'application/json' }
		 });

		responsePromise.success(function(data, status, headers, config) {
			//alert("success in service");
			if(!angular.equals(data,null) ){
				alert("Updated Successfully");
				backtocontroller(data);
			}
	        });
		responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });

	}
		
})