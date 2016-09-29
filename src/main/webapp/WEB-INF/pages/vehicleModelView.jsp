<%@ include file="/common/taglibs.jsp" %>
<option value="null"> Select Vehicle Model -- </option>	
<m:forEach items="${vehicleModelList}" var="vehicleModel">
    <option value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
</m:forEach>
