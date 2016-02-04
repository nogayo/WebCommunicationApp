(function() {
    'use strict';
    
    var modules = [
        'ngNewRouter',
        'app.welcome',
        'app.sigin'
    ];
    
    angular.module('app', modules)
           .controller('AppController', AppController);
    
    AppController.$inject = ['$router'];
    
    function AppController($router) {
        $router.config([
            {
                path: '/', redirectTo: '/sigin'
            },
            {
                path: '/sigin', component: 'sigin'
            }
        ]);
    } 
})();

