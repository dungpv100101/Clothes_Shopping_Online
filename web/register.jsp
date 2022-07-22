<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Shopper</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
        <!-- bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
        <link href="themes/css/bootstrappage.css" rel="stylesheet"/>

        <!-- global styles -->
        <link href="themes/css/flexslider.css" rel="stylesheet"/>
        <link href="themes/css/main.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="themes/js/jquery-1.7.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>				
        <script src="themes/js/superfish.js"></script>	
        <script src="themes/js/jquery.scrolltotop.js"></script>
        <!--[if lt IE 9]>			
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>		
        <div id="top-bar" class="container">
            <div class="row">
                <div class="span4">
                    <form action="products?page_number=0" method="POST" class="search_form">
                        <input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt" style="color: black" name="search">
                    </form>
                </div>
                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">			
                            <%String username = (String)session.getAttribute("username");%>
                            <li><a href="#"><%=username != null ? "Xin chao " + username : "My Account"%></a></li>
                            <li><a href="cart">Your Cart</a></li>
                            <li><a href="admin">Manager</a></li>					
                            <li><a href="register"><%=session.getAttribute("username") == null ? "Login":"Logout"%></a></li>		
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="wrapper" class="container">
            <section class="navbar main-menu">
                <div class="navbar-inner main-menu">				
                    <a href="home" class="logo pull-left"><img src="themes/images//logo.png" class="site_logo" alt=""></a>
                </div>
            </section>			
            <section class="header_text sub">
                <img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
                <h4><span>Login or Regsiter</span></h4>
            </section>			
            <section class="main-content">				
                <div class="row">
                    <div class="span5">					
                        <h4 class="title"><span class="text"><strong>Login</strong> Form For Customer</span></h4>
                        <form action="register?do=login" method="post">
                            <p style="color: red; font-weight: bold"><%=request.getAttribute("text_login").toString()%></p>
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input type="text" placeholder="Enter your username" id="username" class="input-xlarge" name="username">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input type="password" placeholder="Enter your password" id="password" class="input-xlarge" name="password">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <input tabindex="3" class="btn btn-inverse large" type="submit" value="Sign into your account">
                                    <hr>
                                    <p class="reset">Recover your <a tabindex="4" href="#" title="Recover your username or password">username or password</a></p>
                                </div>
                            </fieldset>
                        </form>	
                        <h4 class="title"><span class="text"><strong>Login</strong> Form For ADMIN</span></h4>
                        <form action="register?do=login_admin" method="post">
                            <p style="color: red; font-weight: bold"><%=request.getAttribute("text_login_admin").toString()%></p>
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input type="text" placeholder="Enter your username" id="username" class="input-xlarge" name="username">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input type="password" placeholder="Enter your password" id="password" class="input-xlarge" name="password">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <input tabindex="3" class="btn btn-inverse large" type="submit" value="Sign into your account">
                                    <hr>
                                    <p class="reset">Recover your <a tabindex="4" href="#" title="Recover your username or password">username or password</a></p>
                                </div>
                            </fieldset>
                        </form>    
                    </div>
                    <div class="span7">					
                        <h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
                        <form action="register?do=register" method="post" class="form-stacked">
                            <p style="color: red; font-weight: bold"><%=request.getAttribute("text_register").toString()%></p>
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label">Username</label>
                                    <div class="controls">
                                        <input name="username" type="text" placeholder="Enter your username" class="input-xlarge">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Password:</label>
                                    <div class="controls">
                                        <input name="password" type="password" placeholder="Enter your password" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Customer ID</label>
                                    <div class="controls">
                                        <input name="customerID" value="" type="text" placeholder="Enter your Customer ID" class="input-xlarge">
                                    </div>
                                </div>	

                                <div class="control-group">
                                    <label class="control-label">Company Name</label>
                                    <div class="controls">
                                        <input name="companyName" value="" type="text" placeholder="Enter your Company Name" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Contact Name</label>
                                    <div class="controls">
                                        <input name="contactName" value="" type="text" placeholder="Enter your Contact Name" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Contact Title</label>
                                    <div class="controls">
                                        <input name="contactTitle" value="" type="text" placeholder="Enter your Contact Title" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Address</label>
                                    <div class="controls">
                                        <input name="address" value="" type="text" placeholder="Enter your Address" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">City</label>
                                    <div class="controls">
                                        <input name="city" value="" type="text" placeholder="Enter your City" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Region</label>
                                    <div class="controls">
                                        <input name="region" value="" type="text" placeholder="Enter your Region" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Postal Code</label>
                                    <div class="controls">
                                        <input name="postalCode" value="" type="text" placeholder="Enter your Postal Code" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Country</label>
                                    <div class="controls">
                                        <input name="country" value="" type="text" placeholder="Enter your Country" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Phone</label>
                                    <div class="controls">
                                        <input name="phone" value="" type="text" placeholder="Enter your Phone" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <label class="control-label">Fax</label>
                                    <div class="controls">
                                        <input name="fax" value="" type="text" placeholder="Enter your Fax" class="input-xlarge">
                                    </div>
                                </div>	
                                <div class="control-group">
                                    <p>Now that we know who you are. I'm not a mistake! In a comic, you know how you can tell who the arch-villain's going to be?</p>
                                </div>
                                <hr>
                                <div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Create your account"></div>
                            </fieldset>
                        </form>					
                    </div>				
                </div>
            </section>			
            <section id="footer-bar">
                <div class="row">
                    <div class="span3">
                        <h4>Navigation</h4>
                        <ul class="nav">
                            <li><a href="./index.jsp">Homepage</a></li>  
                            <li><a href="./about.jsp">About Us</a></li>
                            <li><a href="./contact.jsp">Contac Us</a></li>
                            <li><a href="./cart.jsp">Your Cart</a></li>
                            <li><a href="./register.jsp">Login</a></li>							
                        </ul>					
                    </div>
                    <div class="span4">
                        <h4>My Account</h4>
                        <ul class="nav">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Order History</a></li>
                            <li><a href="#">Wish List</a></li>
                            <li><a href="#">Newsletter</a></li>
                        </ul>
                    </div>
                    <div class="span5">
                        <p class="logo"><img src="themes/images/logo.png" class="site_logo" alt=""></p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the  Lorem Ipsum has been the industry's standard dummy text ever since the you.</p>
                        <br/>
                        <span class="social_icons">
                            <a class="facebook" href="#">Facebook</a>
                            <a class="twitter" href="#">Twitter</a>
                            <a class="skype" href="#">Skype</a>
                            <a class="vimeo" href="#">Vimeo</a>
                        </span>
                    </div>					
                </div>	
            </section>
            <section id="copyright">
                <span>Copyright 2013 bootstrappage template  All right reserved.</span>
            </section>
        </div>
        <script src="themes/js/common.js"></script>
        <script>
            $(document).ready(function () {
                $('#checkout').click(function (e) {
                    document.location.href = "checkout.jsp";
                })
            });
        </script>		
    </body>
</html>