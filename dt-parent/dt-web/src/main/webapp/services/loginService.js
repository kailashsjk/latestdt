module.service('loginService',function($http,$location){
	this.authenticate=function(userId,password,callback){
		var user={
				"userId": userId,
				"password": password
		};

		var responsePromise = 	 $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/userauthenticationservice/authenticate",
			method: "POST", // In this case it is POST
			data: user,
			headers: { 'Content-Type': 'application/json' }
		 });

		responsePromise.success(function(data, status, headers, config) {
			//alert("success in service");
			
				callback(data);
			
	        });
		responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		    });

	}

})