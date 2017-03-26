/**
 * Created by firdavs on 23/03/17.
 */
(function(){
    var app = angular.module('main', []);
    this.url = 'http://localhost:8080/';
    app.controller('StudentCtrl', ['$scope', '$http',

        function ($scope, $http){
        $http.get(url + 'students').then(function (response) {
                $scope.studArray = response.data;
            });

            this.loadStudents = function() {
                    $http.get(url + 'students')
                        .then(
                            function (response) {
                                $scope.students = response.data;
                            }
                        );
                }

            this.loadSubjects = function() {
                $http.get(url + 'subjects')
                    .then(
                        function (response) {
                            $scope.subjects = response.data;
                        }
                    );
            }

            this.loadClasses = function() {
                $http.get(url + 'classes')
                    .then(
                        function (response) {
                            $scope.classes = response.data;
                        }
                    );
            }
            // this.createBook = function() {
            //
            //     $scope.update = false;
            //     $scope.add = true;
            //
            //     $http.post('http://localhost:8080/books', JSON.stringify($scope.book)).then(function (response) {
            //         //TO DO
            //     });
            //
            //     this.resetForm();
            //     this.loadAllBooks();
            // }

            // this.updateBook = function(id) {
            //
            //     $http.put('http://localhost:8080/books/' + id, $scope.book);
            //
            //     $scope.update = false;
            //     $scope.add = true;
            //
            //     this.resetForm();
            //     this.loadAllBooks();
            // }
            //
            //
            // this.deleteBook = function(id) {
            //     $http.delete('http://localhost:8080/books/' + id).then(function (response) {
            //         //TO DO
            //     });
            //     this.loadAllBooks();
            // }
            //
            // this.editBook = function(id) {
            //
            //     $scope.update = true;
            //     $scope.add = false;
            //
            //     $http.get('http://localhost:8080/books/' + id).then(function (response) {
            //         $scope.book = response.data;
            //     });
            //
            //     this.loadAllBooks();
            //
            // }

            // this.loadAllBooks = function() {
            //     $http.get('http://localhost:8080/books')
            //         .then(
            //             function (response) {
            //                 $scope.books = response.data;
            //             }
            //         );
            // }

            // this.resetForm = function () {
            //     $scope.book = {};
            // }

        }]);

})();