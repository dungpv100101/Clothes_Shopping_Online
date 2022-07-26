<%@page import="entity.Product"%>
<%@page import="java.util.Vector"%>
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
                        <input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt " style="color: black" name="search">
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
            <section  class="homepage-slider" id="home-slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <img src="themes/images/carousel/banner-1.jpg" alt="" />
                        </li>
                        <li>
                            <img src="themes/images/carousel/banner-2.jpg" alt="" />
                            <div class="intro">
                                <h1>Mid season sale</h1>
                                <p><span>Up to 50% Off</span></p>
                                <p><span>On selected items online and in stores</span></p>
                            </div>
                        </li>
                    </ul>
                </div>			
            </section>
            <section class="header_text">
                We stand for top quality templates. Our genuine developers always optimized bootstrap commercial templates. 
                <br/>Don't miss to use our cheap abd best bootstrap templates.
            </section>
            <section class="main-content">
                <div class="row">
                    <div class="span12">													
                        <div class="row">
                            <div class="span12">
                                <h4 class="title">
                                    <span class="pull-left"><span class="text"><span class="line">Feature <strong>Products</strong></span></span></span>
                                    <span class="pull-right">
                                        <a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
                                    </span>
                                </h4>
                                <div id="myCarousel" class="myCarousel carousel slide">
                                    <div class="carousel-inner">
                                        <div class="active item">
                                            <ul class="thumbnails">
                                                <%Vector<Product> vecProduct = (Vector<Product>) request.getAttribute("vecProduct");%>
                                                <%for (int i = 0; i < 4; i++) {%>
                                                <li class="span3">
                                                    <div class="product-box">
                                                        <span class="sale_tag"></span>
                                                        <p><a href="product_detail?productID=<%=vecProduct.elementAt(i).getProductID()%>"><img src="themes/images/ladies/<%=i+1%>.jpg" alt="" /></a></p>
                                                        <a href="product_detail?productID=<%=vecProduct.elementAt(i).getProductID()%>" class="title"><%=vecProduct.elementAt(i).getProductName()%></a><br/>
                                                        <a href="products" class="category">Commodo consequat</a>
                                                        <p class="price">$<%=vecProduct.elementAt(i).getUnitPrice()%></p>
                                                    </div>
                                                </li>
                                                <%}%>
                                            </ul>                    
                                        </div>
                                        <div class="item">
                                            <ul class="thumbnails">
                                                <%for (int i = 4; i < vecProduct.size(); i++) {%>
                                                <li class="span3">
                                                    <div class="product-box">
                                                        <p><a href="product_detail?productID=<%=vecProduct.elementAt(i).getProductID()%>"><img src="themes/images/ladies/<%=i+1%>.jpg" alt="" /></a></p>
                                                        <a href="product_detail?productID=<%=vecProduct.elementAt(i).getProductID()%>" class="title"><%=vecProduct.elementAt(i).getProductName()%></a><br/>
                                                        <a href="products" class="category">Quis nostrud</a>
                                                        <p class="price"><%=vecProduct.elementAt(i).getUnitPrice()%></p>
                                                    </div>
                                                </li>	
                                                <%}%>
                                            </ul>
                                        </div>
                                    </div>							
                                </div>
                                <div class="col-md-12 text-center">
                                    <a href="products?page_number=0"><button type="button" class="btn btn-warning">View All</button></a>
                                </div>
                            </div>						
                        </div>
                        <br>
                        <div class="row feature_box">						
                            <div class="span4">
                                <div class="service">
                                    <div class="responsive">	
                                        <img src="themes/images/feature_img_2.png" alt="" />
                                        <h4>MODERN <strong>DESIGN</strong></h4>
                                        <p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>									
                                    </div>
                                </div>
                            </div>
                            <div class="span4">	
                                <div class="service">
                                    <div class="customize">			
                                        <img src="themes/images/feature_img_1.png" alt="" />
                                        <h4>FREE <strong>SHIPPING</strong></h4>
                                        <p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="service">
                                    <div class="support">	
                                        <img src="themes/images/feature_img_3.png" alt="" />
                                        <h4>24/7 LIVE <strong>SUPPORT</strong></h4>
                                        <p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>
                                    </div>
                                </div>
                            </div>	
                        </div>		
                    </div>				
                </div>
            </section>
            <section class="our_client">
                <h4 class="title"><span class="text">Manufactures</span></h4>
                <div class="row">					
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/14.png"></a>
                    </div>
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/35.png"></a>
                    </div>
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/1.png"></a>
                    </div>
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/2.png"></a>
                    </div>
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/3.png"></a>
                    </div>
                    <div class="span2">
                        <a href="#"><img alt="" src="themes/images/clients/4.png"></a>
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
        <script src="themes/js/jquery.flexslider-min.js"></script>
        <script type="text/javascript">
            $(function () {
                $(document).ready(function () {
                    $('.flexslider').flexslider({
                        animation: "fade",
                        slideshowSpeed: 4000,
                        animationSpeed: 600,
                        controlNav: false,
                        directionNav: true,
                        controlsContainer: ".flex-container" // the container that holds the flexslider
                    });
                });
            });
        </script>
    </body>
</html>