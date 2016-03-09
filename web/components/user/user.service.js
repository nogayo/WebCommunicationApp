(function () {
    'use strict';

    angular.module('app.users', [])
            .service('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {
            registerUser: registerUser
        };
        function registerUser(onSuccess, onError, user) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/WebCommunicationApp/api/user',
                data: user
            }).then(onSuccess, onError);
        }
        return service;
    }

})();

