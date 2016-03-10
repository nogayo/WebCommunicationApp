(function() {
    'use strict';
    
    var modules = [
        'ngNewRouter',
        'app.welcome',
        'app.sigin',
        'app.register',
        'app.users',
        'app.tasks',
        'app.avisos',
        'app.info'
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
            },
            {
                path: '/register', component: 'register'
            },
            {
                path: '/avisos', component: 'avisos'
            },
            {
                path: '/info', component: 'info'
            }
        ]);
    } 
})();

