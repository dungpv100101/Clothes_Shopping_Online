<%@page import="model.DAOProduct"%>
<%@page import="entity.OrderDetails"%>
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
                <script src="themes/js/respond.min.js"></script>
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
                <h4><span>Shopping Cart</span></h4>
            </section>
            <section class="main-content">				
                <div class="row">
                    <div class="span9">					
                        <h4 class="title"><span class="text"><strong>Your</strong> Cart</span></h4>
                        <p style="color: red"><%=request.getAttribute("text") != null ? request.getAttribute("text").toString() : ""%></p>
                        <form acttion="cart" method="post">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Remove</th>
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Quantity</th>
                                        <th>Unit Price</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Vector<OrderDetails> vecOrderDetails = (Vector<OrderDetails>) session.getAttribute("vecOrderDetails");
                                        DAOProduct dao = new DAOProduct();
                                        double total = 0;
                                    %>
                                    <%if (vecOrderDetails != null) {%>
                                    <%for (OrderDetails order : vecOrderDetails) {%>
                                    <%String productName = dao.getProductName(order.getProductID() + "");%>
                                    <tr>
                                <input name="productID" type="hidden" value="<%=order.getProductID()%>">
                                <td><input name="remove" type="checkbox" value="<%=order.getProductID()%>"></td>
                                <td><a href="product_detail.jsp"><img alt="" src="themes/images/ladies/<%=order.getProductID() % 9%>.jpg"></a></td>
                                <td><%=productName%></td>
                                <td><input name="quantity" type="text" value="<%=order.getQuantity()%>" class="input-mini"></td>
                                <td>$<%=order.getUnitPrice()%></td>
                                <td>$<%=order.getUnitPrice() * order.getQuantity()%></td>
                                </tr>	
                                <%total += order.getUnitPrice() * order.getQuantity();%>
                                <%}%>
                                <%}%>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td><strong>$<%=total%></strong></td>
                                </tr>		  
                                </tbody>
                            </table>

                            <hr>
                            <p class="cart-total right">
                                <strong>Total</strong>: $<%=total%><br>
                            </p>
                            <hr/>
                            <p class="buttons center">				
                                <button class="btn" type="submit" id="update">Update</button>
                                <a href="home"><button class="btn" type="button" id="checkout">Continue</button></a>
                                <a href="checkout?sumTotal=<%=total%>"><button class="btn btn-inverse" type="button" id="checkout">Checkout</button></a>
                            </p>	
                        </form>
                    </div>
                    <div class="span3 col">
                        <div class="block">	
                            <ul class="nav nav-list">
                                <li class="nav-header">SUB CATEGORIES</li>
                                <li><a href="products.jsp">Nullam semper elementum</a></li>
                                <li class="active"><a href="products.jsp">Phasellus ultricies</a></li>
                                <li><a href="products.jsp">Donec laoreet dui</a></li>
                                <li><a href="products.jsp">Nullam semper elementum</a></li>
                                <li><a href="products.jsp">Phasellus ultricies</a></li>
                                <li><a href="products.jsp">Donec laoreet dui</a></li>
                            </ul>
                            <br/>
                            <ul class="nav nav-list below">
                                <li class="nav-header">MANUFACTURES</li>
                                <li><a href="products.jsp">Adidas</a></li>
                                <li><a href="products.jsp">Nike</a></li>
                                <li><a href="products.jsp">Dunlop</a></li>
                                <li><a href="products.jsp">Yamaha</a></li>
                            </ul>
                        </div>
                        <div class="block">
                            <h4 class="title">
                                <span class="pull-left"><span class="text">Randomize</span></span>
                                <span class="pull-right">
                                    <a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
                                </span>
                            </h4>
                            <div id="myCarousel" class="carousel slide">
                                <div class="carousel-inner">
                                    <div class="active item">
                                        <ul class="thumbnails listing-products">
                                            <li class="span3">
                                                <div class="product-box">
                                                    <span class="sale_tag"></span>												
                                                    <a href="product_detail.jsp"><img alt="" src="themes/images/ladies/2.jpg"></a><br/>
                                                    <a href="product_detail.jsp" class="title">Fusce id molestie massa</a><br/>
                                                    <a href="#" class="category">Suspendisse aliquet</a>
                                                    <p class="price">$261</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="item">
                                        <ul class="thumbnails listing-products">
                                            <li class="span3">
                                                <div class="product-box">												
                                                    <a href="product_detail.jsp"><img alt="" src="themes/images/ladies/4.jpg"></a><br/>
                                                    <a href="product_detail.jsp" class="title">Tempor sem sodales</a><br/>
                                                    <a href="#" class="category">Urna nec lectus mollis</a>
                                                    <p class="price">$134</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
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
    </body>
</html>