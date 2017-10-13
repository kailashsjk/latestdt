module.controller('registrationController',function($scope,registrationService,$location){
	$scope.showError=false;
	$scope.userIdAvailabilityFlag=false;
	var availabilityCheckFlag=true;
	
	$scope.checkUserNameAvailability=function(){
		registrationService.checkAvailability($scope.userId,function(data){
			availabilityCheckFlag=data;
			if(data === false){
				$scope.userIdAvailabilityFlag=true;
				$scope.form.$invalid=true;
			}else{
				$scope.userIdAvailabilityFlag=false;
			}
		})
	}
	
	$scope.doInvalidForm=function(){
		if(!availabilityCheckFlag){
			$scope.form.$invalid=true;
		}
	}
	
	$scope.register=function(){
		var userId=$scope.userId;
		var phoneNumber=$scope.phoneNumber;
		var email=$scope.email;
		var address=$scope.address;
		var lastName=$scope.lastName;
		var firstName=$scope.firstName;
		var password=$scope.password;
	
		registrationService.addUser(userId,phoneNumber,email,address,lastName,firstName,password);
		
	}
	$scope.checkPwd=function(){
		if($scope.password!=$scope.password_c){
			$scope.showError=true;
			$scope.form.$invalid=true;
		}
		else if($scope.password==$scope.password_c){
			$scope.showError=false;
		}
		
		if(!availabilityCheckFlag){
			$scope.form.$invalid=true;
		}
	}
	
})