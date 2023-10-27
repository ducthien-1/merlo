<%-- 
    Document   : header
    Created on : Jul 8, 2023, 10:41:14 PM
    Author     : chi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header">

    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href=""><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="home">Home</a></li>
                        <li class="active"><a href="productlist">Product</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="viewcart">Cart</a></li>
                                    <c:if test="${sessionScope['account']!=null}">
                                    <li><a href="myorder">My Order</a></li>

                                </c:if>

                            </ul>
                        </li>
                        <c:if test="${sessionScope['account'].getRoleId() == 'AD'}">
                            <li><a href="manageProduct">Manage Product</a></li>
                            </c:if>
                            <c:if test="${sessionScope['account'].getRoleId() == 'PG'}">
                            <li><a href="manageaccount">Manage Account</a></li>
                            </c:if>
                            <c:if test="${sessionScope['account']!=null}">
                            <li><a href="editprofile">Edit Profile</a></li>
                        </c:if>
                            <c:if test="${sessionScope['account']!=null}">
                            <li><a href="changepassword">Change Password</a></li>
                        </c:if>
                            <c:if test="${sessionScope['account']!=null}">
                            <li><a href="logout">Logout</a></li>
                        </c:if>
                            
                    </ul>
                </nav>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>

