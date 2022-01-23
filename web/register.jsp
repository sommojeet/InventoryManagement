<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <header>
        <link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="./css/login.css" rel="stylesheet" id="bootstrap-css">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="./css/font-awesome.css" rel="stylesheet">
    </header>

    <form action="Register" method="post">
        <div class="container">
            <div class="omb_login">
                <h3 class="omb_authTitle">Fill up this form</h3>
                <div class="row omb_row-sm-offset-3 omb_loginOr">
                    <div class="col-xs-12 col-sm-6">
                        <hr class="omb_hrOr">
                         
                    </div>
                </div>

                <div class="row omb_row-sm-offset-3">
                    <div class="col-xs-12 col-sm-6">	

                        <div class="input-group">
                             
                            <input type="text" class="form-control" name="userName" placeholder="email address" value="">  
                        </div>
                        <span class="help-block"></span>

                        <div class="input-group">
                             <input  type="password" class="form-control" name="password" placeholder="Password" value="">
                        </div>
                        <span class="help-block"></span>

                        <div class="input-group">
                             <input  type="text" class="form-control" name="firstName" placeholder="First Name" value="">
                        </div> 
                        <span class="help-block"></span>

                        <div class="input-group">
                             <input  type="text" class="form-control" name="lastName" placeholder="Last Name" value="">
                        </div> 
                        <span class="help-block"></span>

                        <div class="input-group">
                             <input  type="text" class="form-control" name="email" placeholder="email" value="">
                        </div> 
                        <span class="help-block"></span>

                        <div class="input-group">
                             <input  type="text" class="form-control" name="phoneNumber" placeholder="Phone Number" value="">
                        </div> 
                        <div class="row omb_row-sm-offset-3">
                            <div class="col-xs-12 col-sm-3">
                                <br>
                            </div>
                            <div class="col-xs-12 col-sm-3">

                            </div>
                        </div>	   

                        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                        <br>
                    </div>
                </div>  	
            </div>
    </form>
</div>
</html>

