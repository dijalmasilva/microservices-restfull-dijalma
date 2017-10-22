/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("passagem-app");

app.controller("PassagemController", ["$scope", "PassagemService", function ($scope, PassagemService) {

    //tab = 1 --> Nova passagem
    //tab = 2 --> Listar passagens
    //tab = 3 --> Editar passagem
    $scope.tab = 0;
    //set attribute passagem
    $scope.passagem = {};


    $scope.setTab = function (tab) {
        if (tab === null || tab === "") {
            tab = 0;
        } else if (tab === 2) {
            $scope.listarPassagens();
        }
        $scope.tab = tab;
    };

    $scope.compareTab = function (tab) {
        return tab === $scope.tab;
    };

    $scope.salvarPassagem = function () {
        PassagemService.salvarPassagem($scope.passagem, function (res) {
            if (res.status === 201) {
                alert("Passagem cadastrada!");
                $scope.passagem = {};
                $scope.setTab();
            } else {
                if (res.statusText !== null || res.statusText !== "") {
                    alert(res.statusText);
                } else {
                    alert("Erro ao cadastrar passagem!");
                }
            }
            console.log(res);
        });
    };

    $scope.editarPassagem = function () {
        PassagemService.editarPassagem($scope.passagemEdit, function (res) {
            if (res.status === 200) {
                alert("Passagem editada!");
                $scope.setTab(2);
            } else {
                alert("Erro ao editar passagem!");
            }
            console.log(res);
        });
    }

    $scope.listarPassagens = function () {
        PassagemService.listarPassagens(function (res) {
            $scope.passagens = res.data;
        });
    }

    $scope.selecionarPassagem = function (passagem) {
        $scope.passagemEdit = passagem;
        $scope.setTab(3);
    }

    $scope.deletarPassagem = function (id) {
        PassagemService.deletarPassagem(id, function (res) {
            if (res.status === 200) {
                alert("Passagem removida!");
            } else {
                alert("Erro ao remover passagem!");
            }
            $scope.setTab(2);
            console.log(res);
        })
    }

    $scope.cancelar = function () {
        $scope.passagem = {};
        $scope.passagemEdit = {};
        $scope.tab = 0;
    }
}]);