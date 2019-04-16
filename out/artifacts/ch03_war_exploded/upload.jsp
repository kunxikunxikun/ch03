<%@ page pageEncoding="UTF-8"  import="java.sql.*" %>
<!DOCTYPE html>
<html>
<body>
<form role="form" method="post" action="UploadServlet" enctype="multipart/form-data">
<!-- 带上传的  表单   里边必须有enctype="multipart/form-data" 这个属性  -->
	上传者：<input type="text" class="form-control" name="username" id="username" required="required" />
	上传图片：<input type="file" id="img" name="img" />               
	<input type="submit" value="确认">
</form>		
</body>
</html>
	