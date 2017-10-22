/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("agencia-app");

app.controller("AgenciaController", ["$scope", "AgenciaService", function ($scope, AgenciaService) {

    //tab = 1 --> Novo pacote
    //tab = 2 --> Listar pacotes
    $scope.tab = 0;
    $scope.pacote = {};
    $scope.reserva = {};
    $scope.passagem = {};


    $scope.setTab = function (tab) {
        if (tab === null || tab === "") {
            tab = 0;
        } else if (tab === 1) {
            $scope.listarHoteis();
        } else if (tab === 2) {
            $scope.listarPacotes();
        }
        $scope.tab = tab;
    };

    $scope.compareTab = function (tab) {
        return tab === $scope.tab;
    };

    $scope.selecionarHotel = function (hotel) {
        $scope.reserva.hotel = hotel;
        $scope.passagem.cidadeDestino = hotel.cidade;
    }

    $scope.salvarPacote = function () {
        $scope.reserva.cpfCliente = $scope.passagem.cpfCliente;
        AgenciaService.salvarPacote($scope.reserva, $scope.passagem, function (res) {
            alert(res.statusText);
            console.log(res);
        });
    };

    $scope.listarHoteis = function () {
        AgenciaService.listarHoteis(function (res) {
            $scope.hoteis = res;
        });
    }

    $scope.listarPacotes = function () {
        AgenciaService.listarPacotes(function (res) {
            console.log(res);
            if (res.data.length > 0) {
                var cliente = {};
                var passagem = {};
                var reserva = {};
                var pacote = {};
                $scope.pacotes = [];
                for (p in res.data) {
                    AgenciaService.buscarPassagem(p.idPassagem, function (res) {
                        passagem = res;
                        AgenciaService.buscarReserva(p.idReserva, function (res) {
                            reserva = res;
                            AgenciaService.buscarCliente(reserva.cpfCliente, function (res) {
                                cliente = res;
                                pacote.cliente = cliente;
                                pacote.passagem = passagem;
                                pacote.reserva = reserva;
                                $scope.pacotes.push(pacote);
                            });
                        })
                    })
                }
            }
        })
    }

    $scope.cancelar = function () {
        $scope.tab = 0;
        $scope.pacote = {};
        $scope.reserva = {};
        $scope.passagem = {};
    }
}]);