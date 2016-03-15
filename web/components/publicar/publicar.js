(function(){
    'use strict';
    
    angular.module('app.publicar', [])
           .controller('PublicarController', PublicarController)
           .controller('PublicaDocenteController',function($scope,AvisoService){
                var vm = this;
                $scope.content=vm;
                vm.titulo;
                vm.aviso;
                vm.saveAviso = function(){
                    if((vm.titulo).length>0 && (vm.aviso).length>0){
                        var aviso={titulo:vm.titulo,aviso:vm.aviso};
                        AvisoService.update(aviso).success(function (data) {
                        });
                        vm.aviso='';
                        vm.titulo='';
                    }
                };
            
            });
    
    function PublicarController() {
        var vm = this;
    }
})();