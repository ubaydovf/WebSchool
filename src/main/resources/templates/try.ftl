<!DOCTYPE html>
<html ng-app="main">
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>

<#--Student List-->
<div class="panel-heading"></div>

<div class="panel panel-default">
        <div class="container" ng-controller="StudentCtrl as ctrl">

            <table class="table table-hover">
                <#--<div class="btn-group" role="group" aria-label="...">-->
                    <button ng-click="ctrl.loadStudents()" type="button" class="btn btn-default">Students</button>
                    <button ng-click="" type="button" class="btn btn-default">Subjects</button>
                    <button ng-click="" type="button" class="btn btn-default">Classes</button>
                <#--</div>-->
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Last name</th>
                    <th>Date of birth</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Class</th>
                    <th>Nation</th>
                <#--<th width="100"></th>-->
                <#--<th width="100"></th>-->
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="st in students">
                    <td>{{st.id}}</td>
                    <td>{{st.name}}</td>
                    <td>{{st.sureName}}</td>
                    <td>{{st.lastName}}</td>
                    <td>{{st.dateOfBirth}}</td>
                    <td>{{st.age}}</td>
                    <td>{{st.sex}}</td>
                    <td>{{st.selfClazz.id_n + ' ' + st.selfClazz.id_c}}</td>
                    <td>{{st.nation}}</td>
                <#--<td><button type="button" class="btn btn-success custom-width">Edit</button></td>-->
                <#--<td><button type="button" class="btn btn-danger custom-width">Remove</button></td>-->
                </tr>
                </tbody>
            </table>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Number</th>
                <th>Language</th>
                <th>Teacher</th>
                <th>Captain</th>
            <#--<th width="100"></th>-->
            <#--<th width="100"></th>-->
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="st in studArray">
                <td>{{st.id}}</td>
                <td>{{st.name}}</td>
                <td>{{st.sureName}}</td>
                <td>{{st.lastName}}</td>
                <td>{{st.dateOfBirth}}</td>
                <td>{{st.age}}</td>
                <td>{{st.sex}}</td>
                <td>{{st.selfClazz.id_n + ' ' + st.selfClazz.id_c}}</td>
                <td>{{st.nation}}</td>
            <#--<td><button type="button" class="btn btn-success custom-width">Edit</button></td>-->
            <#--<td><button type="button" class="btn btn-danger custom-width">Remove</button></td>-->
            </tr>
            </tbody>
        </table>
        </div>
</div>

<#--<!-- Table &ndash;&gt;-->
<#--<table class="table">-->
    <#--...-->
<#--</table>-->
<#--</div>-->

<#--<div class="form-group">-->
    <#--<label>Name:</label>-->
    <#--<input  type="text" class="form-control">-->
    <#--<label>Title</label>-->
    <#--<input  type="text" class="form-control">-->
    <#--<label>Author</label>-->
    <#--<input  type="text" class="form-control">-->
<#--</div>-->

<#--<button type="button" class="btn btn-success">Add</button>-->
<#--<button type="button" class="btn btn-success">Update</button>-->
<#--<br>-->

<script type="text/javascript" src="/js/lib/angular.min.js"></script>
<script type="text/javascript" src="/js/app/mainApp.js"></script>
</body>
</html>