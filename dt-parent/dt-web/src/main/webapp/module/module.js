var module = angular.module('designThinking', ['ui.router', 'angularUtils.directives.uiBreadcrumbs', 'ngDragDrop']);

/*module.run(['$rootScope', '$state', function ($rootScope, $state) {
   //Auth.init();
     
    $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
       console.log("toState :"+toState+ ". toParams :"+toParams+ ". fromState :" +fromState+". fromParams :"+fromParams);
       //event.preventDefault();
       if(angular.equals(toState.name, fromState.name)){
    	   $state.go('login');
       }
    });
  }]);*/

module.config(function($stateProvider, $locationProvider,$compileProvider) {
    //$locationProvider.html5Mode(true);
    /*$locationProvider.html5Mode({
    	  enabled: true,
    	  requireBase: false
    	});*/
	$compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension):/);
    
    $stateProvider
    .state('login', {
        url: '^',
        views: {
        'main@': {
            templateUrl: 'partials/login.html',
            controller: 'loginController'
            }
        }
    })
    .state('registration', {
        url: '^',
        views: {
        'main@': {
            templateUrl: 'partials/registration.html',
            controller: 'registrationController'
            }
        }
    })
        .state('home', {
        url: 'home/',
        views: {
        	'head@': {
                templateUrl: 'partials/heading.html'
                },
        'main@': {
            templateUrl: 'partials/home.html',
            controller: 'homeController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Home'
      }
    })
    .state('home.projects', {
        url: 'projects/',
        views: {
        	'head@': {
                templateUrl: 'partials/heading.html'
                },
        'main@': {
            templateUrl: 'partials/projects.html',
            controller: 'projectController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Projects'
      }
    })
    .state('home.projects.details', {
        url: 'details/',
        views: {
        	'head@': {
                templateUrl: 'partials/heading.html'
                },
        'main@': {
            templateUrl: 'partials/details.html',
            controller: 'menuController'
            },
        'details@': {
            templateUrl: 'partials/selectProject.html',
            controller: 'selectProjectController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Project'
      }
    })
    .state('home.projects.details.media', {
        url: 'empathize/',
        views: {
        	'main@': {
                templateUrl: 'partials/details.html',
                controller: 'menuController'
                },
            'details@': {
            templateUrl: 'partials/media.html',
            controller: 'empathizeController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Empathize'
      }
    })
    .state('home.projects.details.empathy', {
        url: 'define/',
        views: {
        	'main@': {
                templateUrl: 'partials/details.html',
                controller: 'menuController'
                },
            'details@': {
            templateUrl: 'partials/empathy.html',
            controller: 'defineController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Define'
      }
    })
    .state('home.projects.details.ideas', {
        url: 'ideate/',
        views: {
        	'main@': {
                templateUrl: 'partials/details.html',
                controller: 'menuController'
                },
            'details@': {
            templateUrl: 'partials/ideas.html',
            controller: 'ideasController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Ideate'
      }
    })
    .state('home.projects.details.prototype', {
        url: 'prototype/',
        views: {
        	'main@': {
                templateUrl: 'partials/details.html',
                controller: 'menuController'
                },
            'details@': {
            templateUrl: 'partials/prototype.html',
            controller: 'prototypeController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Prototype'
      }
    })
    .state('home.projects.details.prototype_Feedback', {
        url: 'test/',
        views: {
        	'main@': {
                templateUrl: 'partials/details.html',
                controller: 'menuController'
                },
            'details@': {
            templateUrl: 'partials/prototypeFeedback.html',
            controller:'prototypeFeedbackController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Test'
      }
    })
    .state('home.projects.details.roles', {
        url: 'roles/',
        views: {
        	'head@': {
                templateUrl: 'partials/heading.html'
                },
        'main@': {
            templateUrl: 'partials/details.html',
            controller: 'menuController'
            },
        'details@': {
            templateUrl: 'partials/roles.html',
            controller: 'roleController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'User Role Management'
      }
    })
    .state('home.projects.details.summary', {
        url: 'summary/',
        views: {
        	'head@': {
                templateUrl: 'partials/heading.html'
                },
        'main@': {
            templateUrl: 'partials/details.html',
            controller: 'menuController'
            },
        'details@': {
            templateUrl: 'partials/summary.html',
            controller: 'summaryController'
            }
        },
      data: {// This data is breadcrumbs properties
        displayName: 'Summary'
      }
    })
});


 /* module.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/', {
                    templateUrl: 'partials/home.html',
                    controller: 'homeController'
                }).
                when('/brainStorm', {
                    templateUrl: 'partials/brainStorm.html',
                    controller: 'brainStormController'
                }).
                when('/ideas', {
                    templateUrl: 'partials/ideas.html',
                    controller: 'ideasController'
                }).
                when('/ideaFeedback', {
                    templateUrl: 'partials/ideaFeedback.html',
                    controller: 'ideaFeedbackController'
                }).
                when('/prototyping', {
                    templateUrl: 'partials/prototyping.html',
                    controller: 'prototypingController'
                }). 
                when('/prototypeFeedback', {
                    templateUrl: 'partials/prototypeFeedback.html',
                    controller: 'prototypeFeedbackController'
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
        */