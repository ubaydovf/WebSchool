<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>

<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>TITLE</th>
            <th>AUTHOR</th>
            <th width="100"></th>
            <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><#--{{u.id}}--></td>
            <td><#--{{u.name}}--></td>
            <td><#--{{u.title}}--></td>
            <td><#--{{u.author}}--></td>
            <td><button type="button" class="btn btn-success custom-width">Edit</button></td>
            <td><button type="button" class="btn btn-danger custom-width">Remove</button></td>
        </tr>
        </tbody>
</div>

<#--<div class="panel panel-default">-->
<#--<!-- Default panel contents &ndash;&gt;-->
<#--<div class="panel-heading">Panel heading</div>-->

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

<#--<script type="text/javascript" src="js/lib/angular.min.js"></script>-->
<#--<script type="text/javascript" src="js/app.js"></script>-->
</body>
</html>