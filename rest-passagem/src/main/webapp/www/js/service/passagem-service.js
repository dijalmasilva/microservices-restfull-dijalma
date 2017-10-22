/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("passagem-app");

app.service("PassagemService", ["$http", function ($http) {

    var url = "http://localhost:8082/passagem";
    var urlCliente = "http://localhost:8080/cliente";

    this.salvarPassagem = function (passagem, callback) {
        $http.get(urlCliente + "/filter/cpf/" + passagem.cpfCliente).then(function (res) {
            $http.post(url, passagem).then(function (res) {
                callback(res);
            });
        }, function (res) {
            res.statusText = "Cliente não cadastrado!";
            callback(res);
        })
    };

    this.listarPassagens = function (callback) {
        $http.get(url).then(function (res) {
            callback(res);
        });
    };

    this.editarPassagem = function (passagem, callback) {
        $http.put(url + "/" + passagem.id, passagem).then(function (res) {
            callback(res);
        });
    }

    this.deletarPassagem = function (idPassagem, callback) {
        $http.delete(url + "/" + idPassagem).then(function (res) {
            callback(res);
        });
    }
}]);