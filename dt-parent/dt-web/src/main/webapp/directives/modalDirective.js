module.directive('modal',function() {
					return {
						template : '<div class="modal fade">'
								+ '<div class="modal-dialog">'
								+ '<div class="modal-content">'
								+ '<div class="modal-header">'
								+ '<h4 class="modal-title">Confirmation</h4>'
								+ '</div>'
								+ '<div class="modal-body" ng-transclude/>'
								+ '<div class="modal-body" style="width:100%;float:right;background-color:white" >'
								+ '<button style="margin:5px;" type="button" class="btn btn-default btn-sm pull-left" data-dismiss="modal" aria-hidden="true">No</button>'
								+ '<button style="margin:5px;" type="button" class="btn btn-default btn-sm pull-right" data-dismiss="modal" aria-hidden="true">Yes</button>'
								+ '</div>' + '</div>' + '</div>' + '</div>'
								+ '</div>',
						/*template:'<div class="modal fade">'+
						  '<div class="modal-dialog">' + 
						      '<div class="modal-content">' + 
						          '<div class="modal-body" ng-transclude/>' +
						          '</div>' + 
						    '</div>' + 
						          '</div>',*/
						restrict : 'E',
						transclude : true,
						replace : true,
						scope : true,
						link : function postLink(scope, element, attrs) {
							scope.$watch(attrs.visible, function(value) {
								if (value == true)
									$(element).modal('show');
								else
									$(element).modal('hide');
							});

							$(element).on('shown.bs.modal', function() {
								scope.$apply(function() {
									scope.$parent[attrs.visible] = true;
								});
							});

							$(element).on('hidden.bs.modal', function() {
								scope.$apply(function() {
									scope.$parent[attrs.visible] = false;
								});
							});
						}
					};
				});

module.directive('helpmodal',function() {
			return {
				template : '<div class="modal fade">'
						+ '<div class="modal-dialog">'
						+ '<div class="modal-content">'
						+ '<div class="modal-header">'
						+ '<h4 class="modal-title">{{heading}}</h4>'
						+ '</div>'
						+ '<div class="modal-body" ng-transclude/>'
						+ '<div class="modal-body" style="width:100%;float:right;background-color:white" >'
						+ '<button style="margin:5px;" type="button" class="btn btn-default btn-sm pull-right" data-dismiss="modal" aria-hidden="true">Ok</button>'
						+ '</div>' + '</div>' + '</div>' + '</div>'
						+ '</div>',
				/*template:'<div class="modal fade">'+
				  '<div class="modal-dialog">' + 
				      '<div class="modal-content">' + 
				          '<div class="modal-body" ng-transclude/>' +
				          '</div>' + 
				    '</div>' + 
				          '</div>',*/
				restrict : 'E',
				transclude : true,
				replace : true,
				scope : true,
				link : function postLink(scope, element, attrs) {
					scope.$watch(attrs.visible, function(value) {
						if (value == true)
							$(element).modal('show');
						else
							$(element).modal('hide');
					});

					$(element).on('shown.bs.modal', function() {
						scope.$apply(function() {
							scope.$parent[attrs.visible] = true;
						});
					});

					$(element).on('hidden.bs.modal', function() {
						scope.$apply(function() {
							scope.$parent[attrs.visible] = false;
						});
					});
				}
			};
		});
module.directive('editmodal',function() {
	return {
		template : '<div class="modal fade">'
				+ '<div class="modal-dialog">'
				+ '<div class="modal-content">'
				+ '<div class="modal-header">'
				+ '<h4 class="modal-title">{{heading}}</h4>'
				+ '</div>'
				+ '<div class="modal-body" ng-transclude/>'
				+ '<div class="modal-body" style="width:100%;float:right;background-color:white" >'
				+ '<button style="margin:5px;" type="button" class="btn btn-default btn-sm pull-right" data-dismiss="modal" aria-hidden="true">Ok</button>'
				+ '</div>' + '</div>' + '</div>' + '</div>'
				+ '</div>',
		/*template:'<div class="modal fade">'+
		  '<div class="modal-dialog">' + 
		      '<div class="modal-content">' + 
		          '<div class="modal-body" ng-transclude/>' +
		          '</div>' + 
		    '</div>' + 
		          '</div>',*/
		restrict : 'E',
		transclude : true,
		replace : true,
		scope : true,
		link : function postLink(scope, element, attrs) {
			scope.$watch(attrs.visible, function(value) {
				if (value == true)
					$(element).modal('show');
				else
					$(element).modal('hide');
			});

			$(element).on('shown.bs.modal', function() {
				scope.$apply(function() {
					scope.$parent[attrs.visible] = true;
				});
			});

			$(element).on('hidden.bs.modal', function() {
				scope.$apply(function() {
					scope.$parent[attrs.visible] = false;
				});
			});
		}
	};
});
