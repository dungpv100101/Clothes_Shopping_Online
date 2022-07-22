<%@page import="entity.Product"%>
<%@page import="entity.Customers"%>
<%@page import="model.DAOCustomers"%>
<%@page import="entity.Orders"%>
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
                            <%String username = (String) session.getAttribute("username");%>
                            <li><a href="#"><%=username != null ? "Xin chao " + username : "My Account"%></a></li>
                            <li><a href="cart">Your Cart</a></li>
                            <li><a href="admin">Manager</a></li>					
                            <li><a href="register"><%=session.getAttribute("username") == null ? "Login" : "Logout"%></a></li>		
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
                <h4><span>Manager</span></h4>
            </section>
            <section class="main-content">				
                <div class="row">
                    <div class="span12">					
                        <h4 class="title"><span class="text"><strong>Your</strong> Manager</span></h4>
                        <div class="pull-left">	
                            <ul class="nav nav-tabs">
                                <li class="<%=request.getAttribute("service").toString().equals("customer") ? "active" : ""%>"><a href="admin?do=customer">Customer</a></li>
                                <li class="<%=request.getAttribute("service").toString().equals("product") ? "active" : ""%>"><a href="admin?do=product">Product</a></li>
                                <li class="<%=request.getAttribute("service").toString().equals("order") ? "active" : ""%>"><a href="admin?do=order">Bill</a></li>
                            </ul>
                        </div>
                        <form action="admin" class="form-search pull-right">
                            <input name="do" value="<%=request.getAttribute("service").toString()%>" type="hidden">
                            <input name="ID" placeholder="Search by ID" type="text" class="input-medium search-query">
                        </form>
                        <%
                            int page_number = Integer.parseInt((String) request.getAttribute("page_number"));
                            String service = request.getAttribute("service").toString();
                        %>
                        <%if (service.equals("customer")) {%>
                        <form acttion="cart" method="post">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Customer ID</th>
                                        <th>Company Name</th>
                                        <th>Address</th>
                                        <th>Country</th>
                                        <th>Phone</th>
                                        <th>Username</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Vector<Customers> vecCustomers = (Vector<Customers>) request.getAttribute("vecCustomers");
                                    %>
                                    <%if (vecCustomers != null) {%>
                                    <%for (Customers cus : vecCustomers) {%>
                                    <tr>
                                <input name="customerID" type="hidden" value="<%=cus.getCustomerID()%>">
                                <td><%=cus.getCustomerID()%></td>
                                <td><%=cus.getCompanyName()%></td>
                                <td><%=cus.getAddress()%></td>
                                <td><%=cus.getCountry()%></td>
                                <td><%=cus.getPhone()%></td>
                                <td><%=cus.getUsername()%></td>
                                <td><a href="admin_details?do=customer&customerID=<%=cus.getCustomerID()%>">Details</a></td>
                                </tr>	
                                <%}%>
                                <%}%>		  
                                </tbody>
                            </table>
                        </form>
                        <%}%>
                        <%if (service.equals("product")) {%>
                        <form acttion="cart" method="post">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Product Name</th>
                                        <th>Supplier ID</th>
                                        <th>Category ID</th>
                                        <th>Unit Price</th>
                                        <th>Unit in stock</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Vector<Product> vecProduct = (Vector<Product>) request.getAttribute("vecProduct");
                                    %>
                                    <%if (vecProduct != null) {%>
                                    <%for (Product pro : vecProduct) {%>
                                    <tr>
                                <input name="customerID" type="hidden" value="<%=pro.getProductID()%>">
                                <td><%=pro.getProductID()%></td>
                                <td><%=pro.getProductName()%></td>
                                <td><%=pro.getSupplierID()%></td>
                                <td><%=pro.getCategoryID()%></td>
                                <td><%=pro.getUnitPrice()%></td>
                                <td><%=pro.getUnitsInStock()%></td>
                                <td><a href="admin_details?do=product&productID=<%=pro.getProductID()%>">Details</a></td>
                                </tr>	
                                <%}%>
                                <%}%>		  
                                </tbody>
                            </table>
                        </form>
                        <%}%>
                        <%if (service.equals("order")) {%>
                        <div class="btn-group">
                            <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">
                                Search By Status
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="admin?do=<%=service%>&status=1">Wait</a></li>
                                <li><a href="admin?do=<%=service%>&status=2">Process</a></li>
                                <li><a href="admin?do=<%=service%>&status=3">Done</a></li>
                            </ul>
                        </div>
                        <form acttion="cart" method="post">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Order ID</th>
                                        <th>Customer Name</th>
                                        <th>Date</th>
                                        <th>Freight</th>
                                        <th>Status</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Vector<Orders> vecOrder = (Vector<Orders>) request.getAttribute("vecOrder");
                                        DAOCustomers dao = new DAOCustomers();
                                    %>
                                    <%if (vecOrder != null) {%>
                                    <%for (Orders order : vecOrder) {%>
                                    <%String customerName = dao.getCustomerName(order.getCustomerID() + "");%>
                                    <tr>
                                <input name="orderID" type="hidden" value="<%=order.getOrderID()%>">
                                <td><%=order.getOrderID()%></td>
                                <td><%=customerName%></td>
                                <td><%=order.getOrderDate()%></td>
                                <td><%=order.getFreight()%></td>
                                <td><%=order.getStatus().equals("1") ? "Wait" : order.getStatus().equals("2") ? "Process" : "Done"%></td>
                                <td><a href="admin_details?do=order&orderID=<%=order.getOrderID()%>">Details</a></td>
                                </tr>	
                                <%}%>
                                <%}%>		  
                                </tbody>
                            </table>	
                        </form>
                        <%}%>
                        <hr>
                        <div class="pagination pagination-small pagination-centered">
                            <ul>
                                <li><a href="admin?page_number=<%=page_number - 1%>">Prev</a></li>
                                <li class="active"><a href="#"><%=page_number%></a></li>
                                <li><a href="admin?do=<%=service%>&page_number=<%=page_number + 1%>"><%=page_number + 1%></a></li>
                                <li><a href="admin?do=<%=service%>page_number=<%=page_number + 2%>"><%=page_number + 2%></a></li>
                                <li><a href="admin?do=<%=service%>page_number=<%=page_number + 3%>"><%=page_number + 3%></a></li>
                                <li><a href="admin?do=<%=service%>page_number=<%=page_number + 1%>">Next</a></li>
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