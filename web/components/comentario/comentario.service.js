(function () {
    'use strict';


    var myApp = angular.module('app.comentarios',[]);

    myApp.service('ComentarioService',function($http){
            this.query = function() {
               return $http({method:'GET',url:'http://localhost:8080/WebCommunicationApp/api/aviso'});
            };
            this.update = function(comentario) {
               return $http({method:'POST', url:'http://localhost:8080/WebCommunicationApp/api/comentario',data:comentario});  
            };
    });
    

})();