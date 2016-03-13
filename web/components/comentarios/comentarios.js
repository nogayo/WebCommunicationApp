(function(){
    'use strict';
    angular.module('app.comentarios', [])
           //.controller('comentarios', comentarios)

            .controller('listaController',function($scope,ComentarioService){
            ComentarioService.query().success(function (data) {
                    $scope.comentarios=data;
                    });
            })
            
           .controller('controladorP',function($scope,$filter){
                $scope.filteredText = $filter('uppercase')($scope.originalText);
                $scope.example="example";
                $scope.comentarios=[{comentario:"Lorem ipsum dolor sit ing elit.illum odit"},{comentario:"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio voluptates doloremque, aut ut quia quos ratione dolor eius ab cupiditate, nihil tempore non facilis. Vitae, cupiditate, ipsa. Ex, in, sapiente."},{comentario:"Lorem ipsum. Sed natus fugit at harum. Distinctio, minima aperiam. Minima, assumenda dolor, modi quae doloremque dolores laborum reprehenderit mollitia cupiditate sint, labore similique!"},{comentario:"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quas minus incidunt velit laboriosam non tempora nulla, id, corrupti atque, soluta sed nobis quae assumenda doloribus, optio ducimus at veritatis modi!"},{comentario:"Lorem ipsum dolor sit amet, consectetur adipi."}];
                   
            })
            .controller('ComentarioController',function(ComentarioService){
                var vm = this;
                
                vm.comentario;
                
                //var aviso={titulo:"ejem",aviso:"aviso"};
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