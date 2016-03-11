(function () {
    'use strict';
    angular.module('app.sigin', [])
            .controller('SiginController', SiginController);
    SiginController.$inject = ['UserService', '$location'];
    function SiginController(UserService, $location) {
        var vm = this;
        vm.ussername;
        vm.password;

        vm.session = {};

        vm.login = function () {
            var user = {
                ussername: vm.ussername,
                password: vm.password,
                name: "",
                email: "",
                lastname: ""
            };
            UserService.login(onSuccess, onError, user);
        };

        function onSuccess(data) {
            if (data.data.loginValue === "true") {
                vm.session = data.data;
                console.log('user login successful');
                $location.path('/publicaDoc');
            } else {
                onError();
            }
        }

        function onError() {
            console.log('ussername or password incorrect');
        }
    }
})();