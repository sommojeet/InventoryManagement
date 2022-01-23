<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if (request.getSession().getAttribute("validUser") == null) {
        String errorMsg = "You are not logged in. Please login first!!";
        request.setAttribute("ErrorMsg", errorMsg);
        request.getRequestDispatcher("loginPage.jsp").forward(request, response);
    }
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.88.1">
        <title>Orders</title>
        <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <meta name="theme-color" content="#7952b3">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="./css/dashboard.css" rel="stylesheet">
    </head>
    <body>

        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="http://www.exavalu.com">
                Exavalu<br>
                Welcome <c:out value='${sessionScope.validUser.getFirstName()}'/>
            </a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <button type="button" class="btn btn-sm btn-danger"><a class="nav-link px-3" href="Logout">Sign out</a></button>
                </div>
            </div>
        </header>
        <div class="container-fluid">
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="position-sticky pt-3">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="Dashboard">
                                    <span data-feather="home"></span>
                                    Dashboard
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ShowOrders">
                                    <span data-feather="file"></span>
                                    Orders
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ShowProducts">
                                    <span data-feather="shopping-cart"></span>
                                    Products
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ShowCustomers">
                                    <span data-feather="users"></span>
                                    Customers
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="bar-chart-2"></span>
                                    Reports
                                </a>
                            </li>
                        </ul>

                        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>Saved reports</span>
                            <a class="link-secondary" href="#" aria-label="Add a new report">
                                <span data-feather="plus-circle"></span>
                            </a>
                        </h6>
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="file-text"></span>
                                    Current month
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="file-text"></span>
                                    Last quarter
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="file-text"></span>
                                    Social engagement
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="file-text"></span>
                                    Year-end sale
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

                    <h2>Edit Product</h2>
                    <form action="SaveProduct" method="post">
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                    <tr>
                                        <th scope="col">Product Id</th>
                                        <td>
                                            <input type="text" value='<c:out value="${product.getProductId()}"></c:out>' name="productId" readonly>
                                        </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Product Name</th>
                                            <td>
                                                <input type="text" value="<c:out value="${product.getProductName()}"></c:out>" name="productName"> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Product Make</th>
                                            <td>
                                                <input type="text" value="<c:out value="${product.getProductMake()}"></c:out>" name="productMake" readonly>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Price</th>
                                            <td>
                                                <input type="text" value="<c:out value="${product.getPrice()}"></c:out>" name="price">
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="col">Availability</th>
                                            <td>
                                                <input type="text" value="<c:out value="${product.getAvailability()}"></c:out>" name="availability">
                                            </td>
                                        </tr>                                        
                                    <tr>
                                        <td>
                                            <input type="submit" name="Submit">
                                        </td>
                                        <td>
                                            <input type="button" name="Cancel" value="Cancel">
                                        </td>
                                    </tr>
                                </thead>                            
                            </table>
                        </div>
                    </form>
                </main>
            </div>
        </div> 
    </body>
</html>
