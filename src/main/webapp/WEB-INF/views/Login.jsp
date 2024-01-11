<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Login</title>
</head>
<body>

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                            <p class="text-white-50 mb-5">Inserisci username e password!</p>

                            <c:if test="${not empty error}">
                                <div class="alert ${alertClass} alert-dismissible fade show" role="alert">
                                    <strong>${error}</strong>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                </div>
                            </c:if>


                            <form action="${pageContext.request.contextPath}/login" method="post">
                                <div class="form-outline form-white mb-4">
                                    <label>Username: <input type="text" name="username" required /></label><br/>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <label>Password: <input type="password" name="password" required /></label><br/>
                                </div>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                            </form>

                            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                            </div>

                        </div>

                        <div>
                            <form action="${pageContext.request.contextPath}/register" method="get">
                                <label>Non sei ancora registrato? : <input type="SUBMIT" value="Vai alla registrazione"/></label><br/>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>