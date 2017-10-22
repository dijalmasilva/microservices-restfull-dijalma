/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("hotel-app");

app.service("HotelService", ["$http", function ($http) {

    var url = "http://localhost:8081/hotel";
    var urlReserva = "http://localhost:8081/reserva";
    var urlCliente = "http://localhost:8080/cliente";

    this.salvarHotel = function (hotel, callback) {
        $http.post(url, hotel).then(function (res) {
            callback(res);
        });
    };

    this.listarHoteis = function (callback) {
        $http.get(url).then(function (res) {
            callback(res);
        });
    };

    this.editarHotel = function (hotel, callback) {
        $http.put(url + "/" + hotel.id, hotel).then(function (res) {
            callback(res);
        });
    }

    this.deletarHotel = function (idHotel, callback) {
        $http.delete(url + "/" + idHotel).then(function (res) {
            callback(res);
        });
    }

    this.salvarReserva = function (reserva, callback) {
        $http.get(urlCliente + "/filter/cpf/" + reserva.cpfCliente).then(function (res) {
            $http.post(urlReserva, reserva).then(function (res) {
                callback(res);
            });
        }, function (res) {
            res.statusText = "Cliente não existe!";
            callback(res);
        });
    }

    this.listarReservas = function (callback) {
        $http.get(urlReserva).then(function (res) {
            callback(res);
        })
    }
}]);