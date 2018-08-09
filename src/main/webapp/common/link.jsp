<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="link">
	<div class="w960">
		<div class="data_list link_list">
			<div class="dataHeader">友情链接</div>
			<div class="datas">
				<ul>
	              <c:forEach var="link" items="${linkList }">
	              	<li><a target="_blank" href="${link.url }">${link.name }</a></li>
	              </c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>    