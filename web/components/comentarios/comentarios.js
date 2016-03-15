(function(){
    'use strict';
    angular.module('app.comentarios', [])
           //.controller('comentarios', comentarios)

            .controller('listaController',function($scope,ComentarioService){
                ComentarioService.query().success(function (data) {
                          $scope.comentarios=data;
                });
            })
    
            .controller('ComentarioController',function(ComentarioService){
                var vm = this;
                
                vm.comentario;
                
                //var aviso={titulo:"ejem",comentario:"comentario"};
                vm.saveComentario = function(){
                    if((vm.comentario).length>0){
                        var comentario={comentario:vm.comentario};
                        ComentarioService.update(comentario).success(function (data) {
                        //$scope.publicaciones=data;
                        });  
                        vm.comentario='';
                    }
                };
            
            });
})();