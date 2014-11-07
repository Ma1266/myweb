<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose >
<c:when test="${sessionInfo==null}">
	<c:redirect url="/view/login/login.jsp"/>
</c:when>
<c:when  test="${sessionInfo!=null}">
	<c:redirect url="/view/index.jsp"/>
</c:when>
</c:choose>
