module.service('myService', function(){
	var temp = "";
	this.setData = function(str){
		
		temp = str;
		//alert('temp... ' + temp);
	};
	this.getData = function(){
		return temp;
	}
	
})