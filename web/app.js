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
        'app.publicar',
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
                path: '/publicar', component: 'publicar'  
            },
            {
                path: '/info', component: 'info'
            }
        ]);
    } 
})();

