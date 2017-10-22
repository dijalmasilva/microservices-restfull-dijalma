/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("hotel-app");

app.controller("HotelController", ["$scope", "HotelService", function ($scope, HotelService) {

    //tab = 1 --> Novo hotel
    //tab = 2 --> Listar hoteis
    //tab = 3 --> Editar hotel
    //tab = 4 --> Nova reserva
    //tab = 4 --> Listar Reservas
    $scope.tab = 0;
    //set attribute hotel
    $scope.hotel = {};
    $scope.reserva = {};


    $scope.setTab = function (tab) {
        if (tab === null || tab === "") {
            tab = 0;
        } else if (tab === 2) {
            $scope.listarHoteis();
        } else if (tab === 5) {
            $scope.listarReservas();
        }
        $scope.tab = tab;
    };

    $scope.compareTab = function (tab) {
        return tab === $scope.tab;
    };

    $scope.salvarHotel = function () {
        HotelService.salvarHotel($scope.hotel, function (res) {
            if (res.status === 201) {
                alert("Hotel cadastrado!");
                $scope.hotel = {};
                $scope.setTab();
            } else {
                alert("Erro ao cadastrar hotel!");
            }
            console.log(res);
        });
    };

    $scope.editarHotel = function () {
        HotelService.editarHotel($scope.hotelEdit, function (res) {
            if (res.status === 200) {
                alert("Hotel editado!");
                $scope.setTab(2);
            } else {
                alert("Erro ao editar hotel!");
            }
            console.log(res);
        });
    }

    $scope.listarHoteis = function () {
        HotelService.listarHoteis(function (res) {
            $scope.hoteis = res.data;
        });
    }

    $scope.selecionarHotel = function (hotel) {
        $scope.hotelEdit = hotel;
        $scope.setTab(3);
    }

    $scope.deletarHotel = function (id) {
        HotelService.deletarHotel(id, function (res) {
            if (res.status === 200) {
                alert("Hotel removido!");
            } else {
                alert("Erro ao remover hotel!");
            }
            $scope.setTab(2);
            console.log(res);
        })
    }

    $scope.fazerReserva = function (hotel) {
        $scope.reserva.hotel = hotel;
        $scope.setTab(4);
    }

    $scope.salvarReserva = function () {
        HotelService.salvarReserva($scope.reserva, function (res) {
            if (res.status === 201) {
                alert("Reserva realizada!");
                $scope.setTab(2);
            } else {
                if (res.statusText !== null || res.statusText !== "") {
                    alert(res.statusText);
                } else {
                    alert("Erro ao cadastrar reserva!");
                }
            }

            console.log(res);
        });
    }

    $scope.listarReservas = function () {
        HotelService.listarReservas(function (res) {
            $scope.reservas = res.data;
            console.log(res);
        });
    }

    $scope.cancelar = function () {
        $scope.hotel = {};
        $scope.hotelEdit = {};
        $scope.tab = 0;
    }
}]);