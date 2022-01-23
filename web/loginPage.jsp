<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <header>
        <link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="./css/login.css" rel="stylesheet" id="bootstrap-css">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    </header>

    <form action="Login" method="post">
        <div class="container">
            <div class="omb_login">
                <h3 class="omb_authTitle">Login or <a href="register.jsp">Sign up</a></h3>
                <div class="row omb_row-sm-offset-3 omb_socialButtons">
                    <div class="col-xs-4 col-sm-2">
                        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
                            <i class="fa fa-facebook visible-xs"></i>
                            <span class="hidden-xs">Facebook</span>
                        </a>
                    </div>
                    <div class="col-xs-4 col-sm-2">
                        <a href="#" class="btn btn-lg btn-block omb_btn-twitter">
                            <i class="fa fa-twitter visible-xs"></i>
                            <span class="hidden-xs">Twitter</span>
                        </a>
                    </div>	
                    <div class="col-xs-4 col-sm-2">
                        <a href="#" class="btn btn-lg btn-block omb_btn-google">
                            <i class="fa fa-google-plus visible-xs"></i>
                            <span class="hidden-xs">Google+</span>
                        </a>
                    </div>	
                </div>

                <div class="row omb_row-sm-offset-3 omb_loginOr">
                    <div class="col-xs-12 col-sm-6">
                        <hr class="omb_hrOr">
                        <span class="omb_spanOr">or</span>
                    </div>
                </div>
                <div class="row omb_row-sm-offset-3">
                    
                    <div class="col-xs-12 col-sm-6" style="color: red">                    
                        <span class="omb_spanOr">
                            <!-- here I want to display my error msg after 
                            extracting from request object. Also I need to format the 
                            text in red color. 
                            In order to use request object ( Java object) we need to use 
                            something call jstl - java server tag lib - why? Because 
                            it helps us reduce number of lines of code. 
                            -->                            
                            <c:out value='${requestScope.ErrorMsg}'/>
                        </span>
                    </div>
                </div>

                <div class="row omb_row-sm-offset-3">
                    <div class="col-xs-12 col-sm-6">	

                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" class="form-control" name="userName" placeholder="User Name" value="">  
                        </div>
                        <span class="help-block"></span>

                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input  type="password" class="form-control" name="password" placeholder="Password" value="">
                        </div> 
                        <div class="row omb_row-sm-offset-3">
                            <div class="col-xs-12 col-sm-3">
                                <br>
                            </div>
                            <div class="col-xs-12 col-sm-3">

                            </div>
                        </div>	   

                        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                        <br>
                    </div>
                </div>
                <div class="row omb_row-sm-offset-3">
                    <div class="col-xs-12 col-sm-3">
                        <label class="checkbox">
                            <input type="checkbox" value="remember-me">Remember Me
                        </label>
                    </div>
                    <div class="col-xs-12 col-sm-3">
                        <p class="omb_forgotPwd">
                            <a href="#">Forgot password?</a>
                        </p>
                    </div>
                </div>	    	
            </div>
    </form>
</div>
</html>

