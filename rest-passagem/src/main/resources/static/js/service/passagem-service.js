/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("passagem-app");

app.service("PassagemService", ["$http", function ($http) {

    //to run in browser local machine
    var url = "http://localhost:8083/passagem";
    var urlCliente = "http://localhost:8081/cliente";
    //to run in terminal docker
    //var url = "http://localhost:8082/passagem";
    //var urlCliente = "http://cliente-api:8080/cliente";


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
