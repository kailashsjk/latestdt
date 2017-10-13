module.service('userService', function($timeout){

	var allAccess = false;
	
	this.resetRole = function(){
		allAccess = false;
	}
	
	var user = {};
	this.setUser = function(loginUser){
		user = loginUser;
	}
	this.getUser = function(){
		//debugger;
		return user;
	}
	
	var userPermission = {};
	this.setUserPermission = function(userWithPermission){
		/*console.log(userWithPermission.toString());*/
		userPermission = userWithPermission;
	};
	this.getUserPermission = function(){
		/*$timeout(console.log("get UserPermission : "+userPermission),5000);*/
		return userPermission;
	}
	
	this.setAllAccess = function(found){
		/*console.log("set allaccess : "+found);*/
		allAccess = found;
	}
	this.getAllAccess = function(callback){
		//$timeout(console.log("get allAccess : "+allAccess),5000);
		//callback(allAccess);
		return allAccess;
	}

})