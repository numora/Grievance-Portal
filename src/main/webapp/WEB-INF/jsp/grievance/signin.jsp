<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">

<div id="container" class="container-fluid">
    <div id="content" class="row-fluid">
        <div class="span12">
            <spring:bind path="signInVB.*">
                <form:form class="form-horizontal" modelAttribute="signInVB" id="signInForm" method="POST">
                    <div class="form-group">
                        <label class="col-lg-2 control-label" path="loginName" id="loginName"/>
                        <fmt:message key="signin.userForm.loginName"/>
                        </label>

                        <div class="col-lg-6"><form:input id="loginName" class="form-control" name="loginName" path="loginName" maxlength="20" /> 
                            <form:errors path="loginName" cssClass="error" /> 
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" path="password" id="password">
                            <fmt:message key="signin.userForm.password"/>
                        </label>

                        <div class="col-lg-6"> <form:password id="password" class="form-control" name="password" path="password" maxlength="20" /> 
                            <form:errors path="password" cssClass="error" /> 
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="form-actions"><button type="submit" id="submit" name="processSignIn" class="btn btn-success">SignIn</button>

                                <a href="/grievance/grievance/forgotPassword" id="forgotPassword">forgot password?</a>
                            </div>
                        </div>
                    </div>
                </form:form>
            </spring:bind>

            <a href="/Grievance-Portal/grievance/signin?openIdSignIn=openIdSignIn&identifier=https://www.google.com/accounts/o8/id"><img src="../images/Red-signin.png"></a>       

            <form:form action="/Grievance-Portal/grievance/signin?openIdSignIn=openIdSignIn&identifier=https://me.yahoo.com" method="post">
                <input class="google openid_large_btn" style="background: #fff url(/resources/images/login/openid-logos.png?v=3);
                       background-position: -1px -63px;" type="image" value=" " />

            </form:form>

        </div>       
    </div>
</div>
