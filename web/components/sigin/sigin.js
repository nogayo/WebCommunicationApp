(function () {
    'use strict';

    angular.module('app.sigin', [])
            .controller('SiginController', SiginController);

    SiginController.$inject = ['UserService'];
    function SiginController(UserService) {
        var vm = this;
    }
})();