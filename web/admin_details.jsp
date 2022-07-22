<%@page import="entity.Categories"%>
<%@page import="entity.Suppliers"%>
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
                <%
                    String service = request.getAttribute("service").toString();
                %>
                <h4 class="title"><span class="text"><strong><%=service.toUpperCase()%></strong> Details</span></h4>
                <%if (service.equals("customer")) {%>
                <%Customers cus = (Customers) request.getAttribute("customer");%>
                <form action="admin_details" method="POST">
                    <input type="hidden" name="do" value="customer_update">
                    <table>
                        <tr>
                            <td><strong>CustomerID: </strong></td>
                            <td><%=cus.getCustomerID()%></td>
                            <td><input type="hidden" name="customerID" value="<%=cus.getCustomerID()%>"></td>
                        </tr>             
                        <tr>
                            <td><strong>ContactName: </strong></td>
                            <td><input type="text" name="contactName" value="<%=cus.getContactName()%>"></td>
                            <td></td>
                            <td><strong>CompanyName: </strong></td>
                            <td><input type="text" name="companyName" value="<%=cus.getCompanyName()%>"></td>
                        </tr>
                        <tr>
                            <td><strong>Address: </strong></td>
                            <td><input type="text" name="address" value="<%=cus.getAddress()%>"></td>.
                            <td></td>
                            <td><strong>ContactTitle: </strong></td>
                            <td><input type="text" name="contactTitle" value="<%=cus.getContactTitle()%>"></td>
                        </tr>
                        <tr>
                            <td><strong>Region: </strong></td>
                            <td><input type="text" name="region" value="<%=cus.getRegion()%>"></td>
                            <td></td>
                            <td><strong>City: </strong></td>
                            <td><input type="text" name="city" value="<%=cus.getCity()%>"></td>
                        </tr>
                        <tr>
                            <td><strong>Country: </strong></td>
                            <td><input type="text" name="country" value="<%=cus.getCountry()%>"></td>
                            <td></td>
                            <td><strong>PostalCode: </strong></td>
                            <td><input type="text" name="postalCode" value="<%=cus.getPostalCode()%>"></td>
                        </tr>
                        <tr>
                            <td><strong>Fax: </strong></td>
                            <td><input type="text" name="fax" value="<%=cus.getFax()%>"></td>
                            <td></td>
                            <td><strong>Phone: </strong></td>
                            <td><input type="text" name="phone" value="<%=cus.getPhone()%>"></td>
                        </tr>
                    </table>                                    

                    <div>
                        <input class="btn btn-default" type="submit" value="Update">
                        <a class="btn btn-default" href="admin_details?do=customer_remove&customerID=<%=cus.getCustomerID()%>">Remove</a>
                    </div>
                </form>
                <%}%>
                <%if (service.equals("product")) {%>
                <%
                    Product pro = (Product) request.getAttribute("product");
                    Vector<Suppliers> vecSuppliers = (Vector<Suppliers>) request.getAttribute("vecSuppliers");
                    Vector<Categories> vecCategories = (Vector<Categories>) request.getAttribute("vecCategories");
                %>

                <form action="admin_details" method="POST">
                    <input type="hidden" name="do" value="product_update">
                    <table>
                        <tr>
                            <td></td>
                            <td><input type="hidden" name="productID" value="<%=pro.getProductID()%>"></td>
                        </tr>
                        <tr>
                            <td>Product Name</td>
                            <td><input type="text" name="productName" value="<%=pro.getProductName()%>"></td>
                        </tr>
                        <tr>
                            <td>Supplier ID</td>
                            <td>
                                <select name="supplierID">
                                    <%for (Suppliers sup : vecSuppliers) {%>
                                    <option value="<%=sup.getSupplierID()%>" <%=sup.getSupplierID() == pro.getProductID() ? "selected" : ""%>><%=sup.getCompanyName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Category ID</td>
                            <td>
                                <select name="categoryID">
                                    <%for (Categories cate : vecCategories) {%>
                                    <option value="<%=cate.getCategoryID()%>" <%=cate.getCategoryID() == pro.getCategoryID() ? "selected" : ""%>><%=cate.getCategoryName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>QuantityPerUnit</td>
                            <td><input type="text" name="quantityPerUnit" value="<%=pro.getQuantityPerUnit()%>"></td>
                        </tr>
                        <tr>
                            <td>UnitPrice</td>
                            <td><input type="text" name="unitPrice" value="<%=pro.getUnitPrice()%>"></td>
                        </tr>
                        <tr>
                            <td>UnitsInStock</td>
                            <td><input type="text" name="unitsInStock" value="<%=pro.getUnitsInStock()%>"></td>
                        </tr>
                        <tr>
                            <td>UnitsOnOrder</td>
                            <td><input type="text" name="unitsOnOrder" value="<%=pro.getUnitOnOrder()%>"></td>
                        </tr>
                        <tr>
                            <td>ReorderLevel</td>
                            <td><input type="text" name="reorderLevel" value="<%=pro.getReordeerLevel()%>"></td>
                        </tr>
                        <tr>
                            <td>Discontinued</td>
                            <td>
                                <label class="radio inline">
                                    <input id="discontinued" type="radio" name="discontinued" value="1" <%=pro.getDiscontinued() == 1 ? "checked" : ""%>>Yes
                                </label>
                                <label class="radio inline">
                                    <input id="continued" type="radio" name="discontinued" value="0" <%=pro.getDiscontinued() == 0 ? "checked" : ""%>>No
                                </label>
                            </td>
                        </tr>
                    </table>                                    

                    <div>
                        <input class="btn btn-default" type="submit" value="Update">
                        <a class="btn btn-default" href="admin_details?do=product_remove&productID=<%=pro.getProductID()%>">Remove</a>
                    </div>
                </form>
                <%}%>
                <%if (service.equals("order")) {%>
                <%Orders order = (Orders) request.getAttribute("order");%>
                <strong>Customer Name: </strong>
                <span><%=request.getAttribute("customerName").toString()%></span>
                <br>
                <strong>Order ID: </strong>
                <span><%=order.getOrderID()%></span>
                <br>
                <strong>Order Date: </strong>
                <span><%=order.getOrderDate()%></span>
                <br>
                <strong>Order Status: </strong>
                <span><%=order.getStatus()%></span>
                <br>
                <strong>Status: </strong>
                <div class="btn-group">
                    <button class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">
                        <%=order.getStatus().equals("1") ? "Wait" : order.getStatus().equals("2") ? "Process" : "Done"%>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="admin_details?do=order_update&orderID=<%=order.getOrderID()%>&status=1">Wait</a></li>
                        <li><a href="admin_details?do=order_update&orderID=<%=order.getOrderID()%>&status=2">Process</a></li>
                        <li><a href="admin_details?do=order_update&orderID=<%=order.getOrderID()%>&status=3">Done</a></li>
                    </ul>
                </div>
                <br>
                <h4 class="title"><span class="text"><strong>Details</strong></span></h4>
                <form acttion="cart" method="post">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Unit Price</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Vector<OrderDetails> vecOrderDetails = (Vector<OrderDetails>) request.getAttribute("vecOrderDetails");
                                DAOProduct dao = new DAOProduct();
                                double total = 0;
                            %>
                            <%if (vecOrderDetails != null) {%>
                            <%for (OrderDetails orderDetails : vecOrderDetails) {%>
                            <%String productName = dao.getProductName(orderDetails.getProductID() + "");%>
                            <tr>
                        <input name="productID" type="hidden" value="<%=orderDetails.getProductID()%>">
                        <td><%=orderDetails.getProductID()%></td>
                        <td><%=productName%></td>
                        <td><%=orderDetails.getQuantity()%></td>
                        <td>$<%=orderDetails.getUnitPrice()%></td>
                        <td>$<%=orderDetails.getUnitPrice() * orderDetails.getQuantity()%></td>
                        </tr>	
                        <%total += orderDetails.getUnitPrice() * orderDetails.getQuantity();%>
                        <%}%>
                        <%}%>	  
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td><strong>Grand Total:</strong></td>
                            <td><strong>$<%=total%></strong></td>
                        </tr>	
                        </tbody>
                    </table>	
                </form>
                <%}%>
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