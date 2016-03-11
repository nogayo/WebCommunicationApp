(function () {
    'use strict';


    var myApp = angular.module('app.tasks',[]);

    myApp.service('AvisoService',function($http){
            this.query = function() {
               return $http({method:'GET',url:'http://localhost:8080/WebCommunicationApp/api/aviso'});
            };
            this.update = function(aviso) {
               return $http({method:'POST', url:'http://localhost:8080/WebCommunicationApp/api/aviso',data:aviso});  
            };
    });
    

})();