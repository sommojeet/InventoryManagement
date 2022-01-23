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

        <!--adding javascript here -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


        <script>

            function addProductToCart(pid)
            {

                var qty = document.getElementById("Quantity_" + pid).value;
                $.ajax({
                    url: 'AddProductToCart',
                    method: 'POST',
                    data: {productId: pid, quantity: qty},
                    success: function (resultText) {
                        $('#result').html(resultText);
                    },
                    error: function (jqXHR, exception) {
                        console.log('Error occured!!');
                    }
                });
            }
            function getCustomerAddress()
            {
                var custId = document.getElementById("customerList").value;

                $.ajax({
                    url: 'FindCustomer',
                    method: 'POST',
                    data: {custId: custId},
                    success: function (resultText) {
                        $('#customerAddress').html(resultText);
                    },
                    error: function (jqXHR, exception) {
                        console.log('Error occured!!');
                    }
                });
            }

            function getStates()
            {
                var countryCode = document.getElementById("countryList").value;
                $.ajax({
                    url: 'FindStates',
                    method: 'POST',
                    data: {countryCode: countryCode},
                    success: function (resultText) {
                        $('#destinationStates').html(resultText);
                    },
                    error: function (jqXHR, exception) {
                        console.log('Error occured!!');
                    }
                });
            }


        </script>



    </head>
    <body>

        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a id='something' class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="http://www.exavalu.com">
                Exavalu<br>
                Welcome <c:out value='${sessionScope.validUser.getFirstName()}'/>
            </a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="#">
                        Items in cart <span id="result"></span>| View Cart
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
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                            </div>
                            <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                <span data-feather="calendar"></span>
                                This week
                            </button>
                        </div>
                    </div> 
                    <form action="PlaceOrder" method="post">
                        <h2>Place Order</h2>
                        <font style="color: #a52834"><c:out value="${requestScope.MSG}"></c:out></font>
                            <div class="table-responsive">
                                <table class="table table-striped table-sm">
                                    <thead>
                                        <tr>
                                            <th scope="col">Product Name</th>
                                            <th scope="col">Product Make</th>
                                            <th scope="col">Order Quantity</th>
                                            <th scope="col">Price</th>
                                            <th scope="col">Tax</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var = "netProducts" scope = "request" value = "${sessionScope.products.size()}"/>

                                    <c:if test='${netProducts > 0}'>
                                        <c:forEach items="${sessionScope.products}" var="product">
                                            <tr>
                                                <td><c:out value="${product.getProductName()}"></c:out></td>
                                                <td><c:out value="${product.getProductMake()}"></c:out></td>
                                                <td><c:out value="${product.getQuantityOrdered()}"></c:out></td>
                                                <td><i class="fa fa-inr"></i><c:out value="${product.getPrice()}"></c:out></td>
                                                <td><i class="fa fa-inr"></i><c:out value="${product.getProductTax()}"></c:out></td>
                                                </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test='${netProducts == null}'>
                                        <tr>
                                    <center><h2 style="color: red"><c:out value="${sessionScope.EmptyCart}"></c:out></h2></center>
                                        </tr>
                                </c:if>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td><b>Total Amount</b></td>
                                    <td><i class="fa fa-inr"></i><c:out value="${sessionScope.order.getOrderValue()}"></c:out></td>
                                    <td><i class="fa fa-inr"></i><c:out value="${sessionScope.order.getTaxAmount()}"></c:out></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <hr>
                                <table class="table table-striped table-sm">
                                    <tr>
                                        <td>
                                            Select a customer
                                        </td>
                                        <td colspan="2">
                                            <select onchange="getCustomerAddress()" id="customerList" name="customerId">
                                                <option value="NA">
                                                    ----Select Customer Name----
                                                </option>
                                            <c:forEach items="${requestScope.customers}" var="customer">
                                                <option value="<c:out value="${customer.getCustomerId()}"></c:out>">
                                                    <c:out value="${customer.getCustomerName()}"></c:out>
                                                    </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                            <hr>
                            <table class="table table-striped table-sm">
                                <tr>
                                    <td>
                                        Shipping Address
                                    </td>
                                    <td>
                                        <textArea  name="custAddress" id="customerAddress" rows="4" cols="50" style="align-content:left; overflow:auto; border:1px outset #000000;" readonly></textarea>
                                    </td>
                            </tr>
                            <tr>
                                <td>
                                    Destination Country
                                </td>
                                <td>
                                    <select onchange="getStates()" id="countryList" name="country">
                                        <option value="NA">
                                            ----Select Country----
                                        </option>
                                            <c:forEach items="${requestScope.countries}" var="country">
                                                <option value="<c:out value="${country.getCountryCode()}"></c:out>">
                                                    <c:out value="${country.getCountryName()}"></c:out>
                                                    </option>
                                            </c:forEach>
                                        </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Destination City
                                </td>
                                <td id="destinationStates">
                                    Destination City
                                </td>
                            </tr>
                        </table>
                            
                            <hr>
                            <table class="table table-striped table-sm">
                                <tr>
                                    <td>
                                        <input type="submit" value="Place Order">
                                    </td>
                                    <td>
                                    </td>
                            </tr>
                        </table>
                    </div>
                    </form>
                </main>
            </div>
        </div>



        <script src="./js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./js/feather.min.js" crossorigin="anonymous"></script>
        <script src="./js/Chart.min.js" crossorigin="anonymous"></script>
        <script src="./js/dashboard.js"></script>
    </body>
</html>
