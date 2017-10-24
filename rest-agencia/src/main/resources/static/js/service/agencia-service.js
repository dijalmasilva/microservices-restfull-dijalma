/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("agencia-app");

app.service("AgenciaService", ["$http", function ($http) {

    //to run in browser local machine
    var url = "http://localhost:8084/pacote";
    var urlCliente = "http://localhost:8081/cliente";
    var urlHotel = "http://localhost:8082/hotel";
    var urlReserva = "http://localhost:8082/reserva";
    var urlPassagem = "http://localhost:8083/passagem";
    //to run in terminal docker
    //var url = "http://localhost:8083/pacote";
    //var urlCliente = "http://cliente-api:8080/cliente";
    //var urlHotel = "http://hotel-api:8081/hotel";
    //var urlReserva = "http://hotel-api:8081/reserva";
    //var urlPassagem = "http://passagem-api:8082/passagem";

    this.salvarPacote = function (reserva, passagem, callback) {

        $http.get(urlCliente + "/filter/cpf/" + passagem.cpfCliente).then(function (res) {
            var pacote = {};
            $http.post(urlReserva, reserva).then(function (res) {
                pacote.idReserva = res.data.id;
                $http.post(urlPassagem, passagem).then(function (res) {
                    pacote.idPassagem = res.data.id;
                    $http.post(url, pacote).then(function (res) {
                        res.statusText = "Pacote cadastrado com sucesso!";
                        callback(res);
                    }, function (res) {
                        res.statusText = "Erro ao salvar pacote!";
                        callback(res);
                    })
                }, function (res) {
                    res.statusText = "Erro ao salvar passagem!";
                    callback(res);
                });
            }, function (res) {
                res.statusText = "Erro ao salvar a reserva!";
                callback(res);
            });
        }, function (res) {
            res.statusText = "Cliente não cadastrado!";
            callback(res);
        })
    }

    this.listarHoteis = function (callback) {
        $http.get(urlHotel).then(function (res) {
            callback(res.data);
        });
    }

    this.listarPacotes = function (callback) {
        $http.get(url).then(function (res) {
            callback(res);
        })
    }

    this.buscarCliente = function (cpfCliente, callback) {
        $http.get(urlCliente + "/filter/cpf/" + cpfCliente).then(function (res) {
            callback(res.data);
        });
    }

    this.buscarReserva = function (idReserva, callback) {
        $http.get(urlReserva + "/" + idReserva).then(function (res) {
            callback(res.data);
        });
    }

    this.buscarPassagem = function (idPassagem, callback) {
        $http.get(urlPassagem + "/" + idPassagem).then(function (res) {
            callback(res.data);
        });
    }

    this.buscaPacoteCompleto = function (p, callback) {
        var pacote = {};
        $http.get(urlPassagem + "/" + p.idPassagem).then(function (res) {
            pacote.passagem = res.data;
            $http.get(urlReserva + "/" + p.idReserva).then(function (res) {
                pacote.reserva = res.data;
                $http.get(urlCliente + "/filter/cpf/" + pacote.reserva.cpfCliente).then(function (res) {
                    pacote.cliente = res.data;
                    callback(pacote);
                });
            });
        });
    }
}]);
