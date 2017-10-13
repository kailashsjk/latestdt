module.service('registrationService',function($http,$location,$state){
	this.addUser=function(userId,phoneNumber,email,address,lastName,firstName,password){
		var user = {
				"userId": userId,
				"phoneNumber": phoneNumber,
				"eMail":email,
				"address":address,
				"lastName":lastName,
				"firstName":firstName,
				"password":password,
			};
		var responsePromise = 	 $http({	url: "http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/userauthenticationservice/createUser", 
			method: "POST", // In this case it is POST
			data: user,
			headers: { 'Content-Type': 'application/json' }
		 });
    		responsePromise.success(function(data, status, headers, config) {
    		alert("Added Successfully");
    		$state.go('login');
    		});
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
	
	this.checkAvailability=function(userId,callback){
		var responsePromise = $http.get("http://"+$location.host()+":"+$location.port()+"/dt-web/webresources/userauthenticationservice/checkusername/"+userId);
		
		responsePromise.success(function(data, status, headers, config) {
			callback(data);
        });
	    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");
		});
	}
	
})