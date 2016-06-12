<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css' />"
    	rel="stylesheet">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css">
    <script src="<c:url value='/static/js/jquery-2.2.3.js'/>"></script>
    <script src="<c:url value='/static/js/app.js'/>"></script>
    <script
    	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
    <div id="mainWrapper">
	    <div class="page-header">
			<h2>
	           Ви зайшли як <strong>${user}</strong> !
	                <a href="<c:url value="/logout" />">Вийти</a>
    	    </h2>
    	</div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Коктелі</h2>
            <div class="panel-body">
                <table class="table">
                    <button type="button" class="btn btn-info" data-toggle="modal"
                        data-target="#recipeModal">Додати Коктель</button>
                    <div id="recipeModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Додати Коктель</h4>
                                </div>
                                <div class="modal-body">
                                    <form id="saveRecipeForm" role="form">
                                        <div class="form-group">
                                            <label for="name">Назва:</label> <input type="text"
                                                class="form-control" id="name" name="name" value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Опис:</label> <input
                                                type="text" class="form-control" id="description"
                                                name="description" value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="category">Основні інгредієнти:</label>
                                            <select class="form-control" name="categoryId">
                                                <c:forEach items="${categoryList}" var="row">
                                                    <option value="${row.id}">${row.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-default hidden">Submit</button>
                                        <div id="saveRecipeAlert" class="alert alert-danger"
                                            style="display: none;"></div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default"
                                        data-dismiss="modal">Закрити</button>
                                    <button type="button" class="btn btn-default"
                                        onClick="saveEntity('/user/recipe', 'saveRecipeForm', 'saveRecipeAlert')">Зберегти</button>
                                </div>
                            </div>
                        </div>
                    </div>
                      <thead>
                            <tr>
                                   <th>Назва</th>
                                   <th>Опис</th>
                                   <th>Основні інгредієнти</th>
                                   <th>Автор</th>
                            </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${recipeList}" var="row">
                            <tr>
                                <td>${row.name}</td>
                                <td>${row.description}</td>
                                <td>${row.category.name}</td>
                                <td>${row.author.name}</td>
                                <td><a href="#" class="confirm-delete btn mini red-stripe"
                                    role="button" onClick="deleteRecipe('${row.id}')">Видалити</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
</body>
</html>