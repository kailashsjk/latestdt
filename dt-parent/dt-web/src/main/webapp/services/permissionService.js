module.service("Auth", function(userService, $http, $location){
	this.getRoles = function(pId, uId, backtocontroller){
		//alert("pId, uId :"+pId+uId);
		var data1 = {};
			data1 = {
					'project':{'projectId':pId},
					'logInUser':{'id':uId}
						};
		  	var responsePromise = $http({	url: 'http://'+$location.host()+':'+$location.port()+'/dt-web/webresources/rolemanagementservice/getuserwithrolesagnstprjctid', 
				method: "POST", // In this case it is POST
				data: data1,
				headers: { 'Content-Type': 'application/json' }
			 });
		  	responsePromise.success(function(data, status, headers, config) {
		  		/*console.log("authservice : "+data.permissions);*/
		  		backtocontroller(data);
	        });
		    responsePromise.error(function(data, status, headers, config) {
	        alert("AJAX failed! because no webservice is attached yet");      					 
		    });
	}
	
	this.userHasPermission = function(permissions){
         
        var found = false;
       // alert(permissions+" user permission "+userService.getUser().permissions);
        angular.forEach(permissions, function(permission, index){
            if (userService.getUserPermission().permissionsId.indexOf(permission) >= 0){
                found = true;
                /*console.log("in userHasPermission");*/
                return;
            }                        
        });
         
        return found;
    };
});