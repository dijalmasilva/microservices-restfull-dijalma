/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("cliente-app");

app.service("ClienteService", ["$http", function ($http) {

    //to run browser local machine
    var url = "http://localhost:8081/cliente";
    //to run in terminal docker
    //var url = "http://localhost:8080/cliente";

    this.salvarCliente = function (cliente, callback) {
        $http.post(url, cliente).then(function (res) {
            callback(res);
        });
    };

    this.listarClientes = function (callback) {
        $http.get(url).then(function (res) {
            callback(res);
        });
    };

    this.editarCliente = function (cliente, callback) {
        $http.put(url + "/" + cliente.id, cliente).then(function (res) {
            callback(res);
        });
    }

    this.deletarCliente = function (idCliente, callback) {
        $http.delete(url + "/" + idCliente).then(function (res) {
            callback(res);
        });
    }
}]);
