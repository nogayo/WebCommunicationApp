(function() {
    'use strict';
    
    var modules = [
        'ngNewRouter',
        'app.welcome'
    ];
    
    angular.module('app', modules)
           .controller('AppController', AppController);
    
    AppController.$inject = ['$router'];
    
    function AppController($router) {
        $router.config([
            {
                path: '/', redirectTo: '/welcome'
            },
            {
                path: '/welcome', component: 'welcome'
            }
        ]);
    } 
})();

