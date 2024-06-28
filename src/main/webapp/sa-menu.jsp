<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Super Admin Menu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row mt-3 mb-4">
        <div class="col-md-1">
            <a href="javascript:history.back()" class="btn btn-outline-secondary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-arrow-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M11.354 2.646a.5.5 0 0 1 0 .708L6.707 8l4.647 4.646a.5.5 0 0 1-.708.708l-5-5a.5.5 0 0 1 0-.708l5-5a.5.5 0 0 1 .708 0z"/>
                </svg>
            </a>
        </div>
        <div class="col-md-11">
            <h2 class="text-center">Super-admin Menu</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="text-center">
                <a href="${pageContext.request.contextPath}/users" class="btn btn-primary btn-lg btn-block mb-3">Users</a>
                <a href="${pageContext.request.contextPath}/courses" class="btn btn-primary btn-lg btn-block">Courses</a>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
