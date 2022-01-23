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
        <title>Customers</title>
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
        <!--adding javascript here -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        
        <script>
            function showCartValue()
            {
                $('#result').html('<c:out value="${sessionScope.Cart.size()}" />');
            }
        </script>
        
    </head>
    <body onload="showCartValue()">

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
                    <a class="nav-link px-3" href="ViewCart">
                        <i class="fa fa-shopping-cart"></i> <span id="result"></span><span>&nbsp;</span> | View Cart
                    </a>                    
                </div>
            </div>
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
                                <a class="nav-link" href="Dashboard">
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
                                <a class="nav-link active" href="ShowCustomers">
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
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-sm btn-outline-primary">Share</button>
                                <button type="button" class="btn btn-sm btn-outline-warning">Export</button>
                            </div>
                            <button type="button" class="btn btn-sm btn-outline-info dropdown-toggle">
                                <span data-feather="calendar"></span>
                                This week
                            </button>
                        </div>
                    </div> 
                    <h2>Customer List</h2>
                    <font style="color: #a52834"><c:out value="${requestScope.MSG}"></c:out></font>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th scope="col">Customer Id</th>
                                    <th scope="col">Customer Name</th>
                                    <th scope="col">Customer Address</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var = "netCustomers" scope = "request" value = "${requestScope.customers.size()}"/>
                                <c:if test='${netCustomers > 0}'>
                                    <c:forEach items="${requestScope.customers}" var="customer">
                                        <tr>
                                            <td><c:out value="${customer.getCustomerId()}"></c:out></td>
                                            <td><c:out value="${customer.getCustomerName()}"></c:out></td>
                                            <td><c:out value="${customer.getCustomerAddress()}"></c:out></td>
                                            <td><a class="fa fa-edit"  href='EditCustomer?customerId=<c:out value="${customer.getCustomerId()}"></c:out>'></a>
                                                <a class="fa fa-archive"  href='ArchiveCustomer?customerId=<c:out value="${customer.getCustomerId()}"></c:out>'></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>


        <script src="./js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./js/feather.min.js" crossorigin="anonymous"></script>
        <script src="./js/Chart.min.js" crossorigin="anonymous"></script>
        <script src="./js/dashboard.js"></script>
    </body>
</html>
