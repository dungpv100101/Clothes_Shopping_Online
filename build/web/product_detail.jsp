
<%@page import="entity.Product"%>
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
        <link href="themes/css/main.css" rel="stylesheet"/>
        <link href="themes/css/jquery.fancybox.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="themes/js/jquery-1.7.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>				
        <script src="themes/js/superfish.js"></script>	
        <script src="themes/js/jquery.scrolltotop.js"></script>
        <script src="themes/js/jquery.fancybox.js"></script>
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
                    <a href="home" class="logo pull-left"><img src="themes/images/logo.png" class="site_logo" alt=""></a>
                </div>
            </section>
            <section class="header_text sub">
                <img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
                <h4><span>Product Detail</span></h4>
            </section>
            <section class="main-content">				
                <div class="row">						
                    <div class="span9">
                        <div class="row">
                            <div class="span4">
                                <a href="themes/images/ladies/1.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="themes/images/ladies/1.jpg"></a>												
                                <ul class="thumbnails small">								
                                    <li class="span1">
                                        <a href="themes/images/ladies/2.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 2"><img src="themes/images/ladies/2.jpg" alt=""></a>
                                    </li>								
                                    <li class="span1">
                                        <a href="themes/images/ladies/3.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 3"><img src="themes/images/ladies/3.jpg" alt=""></a>
                                    </li>													
                                    <li class="span1">
                                        <a href="themes/images/ladies/4.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 4"><img src="themes/images/ladies/4.jpg" alt=""></a>
                                    </li>
                                    <li class="span1">
                                        <a href="themes/images/ladies/5.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 5"><img src="themes/images/ladies/5.jpg" alt=""></a>
                                    </li>
                                </ul>
                            </div>
                            <%Product pro = (Product) request.getAttribute("product");%>
                            <div class="span5">
                                <address>
                                    <strong>Name:</strong> <span><%=pro.getProductName()%></span><br>
                                    <strong>Product Code:</strong> <span><%=pro.getProductID()%></span><br>								
                                </address>									
                                <h4><strong>Price: $<%=pro.getUnitPrice()%></strong></h4>
                            </div>
                            <div class="span5">
                                <form action="add_to_cart" class="form-inline" method="post">
                                    <p>&nbsp;</p>
                                    <label>Qty:</label>
                                    <input type="hidden" name="productID" value="<%=pro.getProductID()%>">
                                    <input type="text" class="span1" name="quantity" value="1">
                                    <button class="btn btn-inverse" type="submit">Add to cart</button>
                                </form>
                                <p style="color: red"><%=request.getAttribute("text") != null ? request.getAttribute("text").toString() : ""%></p>
                            </div>							
                        </div>						
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
            $(function () {
                $('#myTab a:first').tab('show');
                $('#myTab a').click(function (e) {
                    e.preventDefault();
                    $(this).tab('show');
                })
            })
            $(document).ready(function () {
                $('.thumbnail').fancybox({
                    openEffect: 'none',
                    closeEffect: 'none'
                });

                $('#myCarousel-2').carousel({
                    interval: 2500
                });
            });
        </script>
    </body>
</html>