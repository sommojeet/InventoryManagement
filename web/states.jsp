<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select id="stateList" name="state">
    <option value="NA">
        ----Select City----
    </option>
    <c:forEach items="${requestScope.states}" var="state">
        <option value="<c:out value="${state.getStateCode()}"></c:out>">
            <c:out value="${state.getStateName()}"></c:out>
            </option>
    </c:forEach>
</select>