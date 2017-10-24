/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("cliente-app");

app.controller("ClienteController", ["$scope", "ClienteService", function ($scope, ClienteService) {

    //tab = 1 --> Novo cliente
    //tab = 2 --> Listar clientes
    //tab = 3 --> Editar cliente
    $scope.tab = 0;
    //set attribute cliente
    $scope.cliente = {};


    $scope.setTab = function (tab) {
        if (tab === null || tab === "") {
            tab = 0;
        } else if (tab === 2) {
            $scope.listarClientes();
        }
        $scope.tab = tab;
    };

    $scope.compareTab = function (tab) {
        return tab === $scope.tab;
    };

    $scope.salvarCliente = function () {
        ClienteService.salvarCliente($scope.cliente, function (res) {
            if (res.status === 201) {
                alert("Usuário cadastrado!");
                $scope.cliente = {};
                $scope.setTab();
            } else {
                alert("Erro ao cadastrar");
            }
            console.log(res);
        });
    };

    $scope.editarCliente = function () {
        ClienteService.editarCliente($scope.clienteEdit, function (res) {
            if (res.status === 200) {
                alert("Cliente editado!");
                $scope.setTab(2);
            } else {
                alert("Erro ao editar cliente!");
            }
            console.log(res);
        });
    }

    $scope.listarClientes = function () {
        ClienteService.listarClientes(function (res) {
            $scope.clientes = res.data;
        });
    }

    $scope.selecionarCliente = function (cliente) {
        $scope.clienteEdit = cliente;
        $scope.setTab(3);
    }

    $scope.deletarCliente = function (id) {
        ClienteService.deletarCliente(id, function (res) {
            if (res.status === 200) {
                alert("Cliente removido!");
            } else {
                alert("Erro ao remover cliente!");
            }
            $scope.setTab(2);
            console.log(res);
        })
    }

    $scope.cancelar = function () {
        $scope.cliente = {};
        $scope.clienteEdit = {};
        $scope.tab = 0;
    }
}]);