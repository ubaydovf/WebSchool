<!DOCTYPE html>

<html lang="en">
<head>
    <title>Hello guys<#--${title}--></title>
    <link href="static/css/bootstrap.css" rel="stylesheet"/>
    <link href="static/css/app.css" rel="stylesheet"/>
</head>
<body>

<div ui-view></div>
<script src="js/lib/angular.min.js" ></script>
<script src="js/lib/angular-ui-router.min.js" ></script>
<script src="js/lib/localforage.min.js" ></script>
<script src="js/lib/ngStorage.min.js"></script>
<#--<script src="js/app/app.js"></script>-->
<#--<script src="js/app/BookService.js"></script>-->
<#--<script src="js/app/BookController.js"></script>-->

<#--Тут типо должно быть отображение модели-->
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>AGE</th>
                        <th>SALARY</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllUsers()">
                        <td>{{u.id}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.age}}</td>
                        <td>{{u.salary}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
