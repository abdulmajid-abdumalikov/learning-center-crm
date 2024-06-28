<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row mt-3 mb-2">
        <div class="col-md-1">
            <a href="javascript:history.back()" class="btn btn-outline-secondary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-arrow-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M11.354 2.646a.5.5 0 0 1 0 .708L6.707 8l4.647 4.646a.5.5 0 0 1-.708.708l-5-5a.5.5 0 0 1 0-.708l5-5a.5.5 0 0 1 .708 0z"></path>
                </svg>
            </a>
        </div>
        <div class="col-md-11">
            <h2 class="text-center">Courses</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${requestScope.courses}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${course.name}</td>
                        <td>${course.description}</td>
                        <td>${course.price}</td>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary"
                                    data-bs-toggle="modal" data-bs-target="#updateCourseModal"
                                    data-course-id="${course.getID()}"
                                    data-course-name="${course.name}"
                                    data-course-description="${course.description}"
                                    data-course-price="${course.price}">
                                <i class="fas fa-edit"></i> Update
                            </button>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/delete-course" method="post">
                                <input type="hidden" name="courseId" value="${course.getID()}">
                                <button type="submit" class="btn btn-sm btn-danger">
                                    <i class="fas fa-trash"></i> Delete
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-12">
            <h3>Add Course</h3>
            <form action="${pageContext.request.contextPath}/add-course" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" required>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" step="0.01" class="form-control" id="price" name="price" required>
                </div>
                <button type="submit" class="btn btn-primary">Add Course</button>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="updateCourseModal" tabindex="-1" aria-labelledby="updateCourseModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateCourseModalLabel">Update Course</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="updateCourseForm" action="${pageContext.request.contextPath}/update-course" method="post">
                <div class="modal-body">
                    <input type="hidden" name="courseId" id="modalCourseId">
                    <div class="form-group">
                        <label for="modalName">Name</label>
                        <input type="text" class="form-control" id="modalName" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="modalDescription">Description</label>
                        <input type="text" class="form-control" id="modalDescription" name="description" required>
                    </div>
                    <div class="form-group">
                        <label for="modalPrice">Price</label>
                        <input type="number" step="0.01" class="form-control" id="modalPrice" name="price" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const updateCourseModal = document.getElementById('updateCourseModal');
        const updateCourseForm = document.getElementById('updateCourseForm');

        updateCourseModal.addEventListener('show.bs.modal', (event) => {
            const button = event.relatedTarget;
            const courseId = button.getAttribute('data-course-id');
            const courseName = button.getAttribute('data-course-name');
            const courseDescription = button.getAttribute('data-course-description');
            const coursePrice = button.getAttribute('data-course-price');

            updateCourseForm.elements['courseId'].value = courseId;
            updateCourseForm.elements['name'].value = courseName;
            updateCourseForm.elements['description'].value = courseDescription;
            updateCourseForm.elements['price'].value = coursePrice;
        });
    });
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
