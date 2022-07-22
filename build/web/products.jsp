<%@page import="entity.Suppliers"%>
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
                <h4><span>New products</span></h4>
            </section>
            <section class="main-content">

                <div class="row">	
                    <%
                        Vector<Suppliers> vecSuppliers = (Vector<Suppliers>) request.getAttribute("vecSuppliers");
                        String supplier = (String) request.getAttribute("supplier");
                        Vector<Product> vecProduct = (Vector<Product>) request.getAttribute("vecProduct");
                        int page_number = Integer.parseInt((String) request.getAttribute("page_number"));
                        int i = 0;
                    %>
                    <div class="span9">								
                        <ul class="thumbnails listing-products">

                            <%for (Product pro : vecProduct) {%>
                            <li class="span3">
                                <div class="product-box">
                                    <span class="sale_tag"></span>												
                                    <a href="product_detail?productID=<%=pro.getProductID()%>"><img alt="" src="themes/images/ladies/<%=++i%>.jpg"></a><br/>
                                    <a href="product_detail?productID=<%=pro.getProductID()%>" class="title"><%=pro.getProductName()%></a><br/>
                                    <a href="#" class="category">Phasellus consequat</a>
                                    <p class="price">$<%=pro.getUnitPrice()%></p>
                                </div>
                            </li>
                            <%}%>
                        </ul>								
                        <hr>
                        <div class="pagination pagination-small pagination-centered">
                            <ul>
                                <li><a href="products?page_number=<%=page_number - 1%>">Prev</a></li>
                                <li class="active"><a href="#"><%=page_number%></a></li>
                                <li><a href="products?page_number=<%=page_number + 1%>&supplier=<%=supplier%>"><%=page_number + 1%></a></li>
                                <li><a href="products?page_number=<%=page_number + 2%>&supplier=<%=supplier%>"><%=page_number + 2%></a></li>
                                <li><a href="products?page_number=<%=page_number + 3%>&supplier=<%=supplier%>"><%=page_number + 3%></a></li>
                                <li><a href="products?page_number=<%=page_number + 1%>&supplier=<%=supplier%>">Next</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="span3 col">
                        <div class="block">	
                            <ul class="nav nav-list">
                                <li class="nav-header">SUB SUPPLIERS</li>
                                <li><a href="products?page_number=0">None</a></li>
                                <%for (Suppliers sup : vecSuppliers) {%>
                                <li class="<%=(sup.getSupplierID() + "").equals(supplier) ? "active" : ""%>"><a href="products?page_number=<%=page_number%>&supplier=<%=sup.getSupplierID()%>"><%=sup.getContactName()%></a></li>
                                <%}%>
                            </ul>
                        </div>
                        <div class="block">								
                            <h4 class="title"><strong>Best</strong> Seller</h4>								
                            <ul class="small-product">
                                <li>
                                    <a href="#" title="Praesent tempor sem sodales">
                                        <img src="themes/images/ladies/3.jpg" alt="Praesent tempor sem sodales">
                                    </a>
                                    <a href="#">Praesent tempor sem</a>
                                </li>
                                <li>
                                    <a href="#" title="Luctus quam ultrices rutrum">
                                        <img src="themes/images/ladies/4.jpg" alt="Luctus quam ultrices rutrum">
                                    </a>
                                    <a href="#">Luctus quam ultrices rutrum</a>
                                </li>
                                <li>
                                    <a href="#" title="Fusce id molestie massa">
                                        <img src="themes/images/ladies/5.jpg" alt="Fusce id molestie massa">
                                    </a>
                                    <a href="#">Fusce id molestie massa</a>
                                </li>   
                            </ul>
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