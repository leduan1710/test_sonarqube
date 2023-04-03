<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<title>Trang Quản Trị</title>
		<%@include file ="/common/admin/header.jsp" %>
</head>
<body>

	<div class="container-fluid">
		<%@include file ="/common/admin/sidebar.jsp" %>
			<div class="col py-3">
				<div class="container">
					<div class="d-flex justify-content-center row mt-5">
						<div class="col-10">
							<div id="chartContainer" style="height: 100px; width: 50%;"></div>

						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
<!-- <script type="text/javascript">

window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "My First Chart in CanvasJS"              
		},
		data: [              
			{
				type: "column",
				dataPoints: [
					{ label: "apple",  y: 10  },
					{ label: "orange", y: 15  },
					{ label: "banana", y: 25  },
					{ label: "mango",  y: 60  },
					{ label: "grape",  y: 28  }
				]
			}
			]
	});
	chart.render();
}

	</script>	-->
	<%@ include file="/common/admin/footer.jsp" %>
</body>
</html>