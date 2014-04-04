<%@page contentType="text/html;charset=utf-8" %>
<%@page import="java.util.*,util.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" 	src="../js/jquery-1.4.3.js">
    </script>
    <script type="text/javascript">
			var flag={"email":false,
						"nickname":false,
						"password":false,
						"repassword":false,
						"code":false};
			
			
			$(function(){
			$("txtCode").blur (function(){
			
				flag.code=false;
				var code=$("#txtCode").val();
				
				$("#number\\.info").html("<img src='../images/wrong.gif'/>");
				$.post(
    				"/dangdang/user/validate.action?dt="+new Date().getTime(),
    				{"code":code},
				function(data){
					if(data==code){
						$("#number\\.info").html("<img src='../images/right.gif'/>pass");
						flag.code=true;
					}else{
						$("#number\\.info").html("<img src='../images/wrong.gif'/>fail");
					}
					});
				});
		});
		$(function(){
			$("#f").submit(function(){
				if(flag.code){
				return true;
				}else{
				alert("");
				return false;
				}
			
			});
	
		});
		
		</script>
	</head>
	<body>
		
							验证码：
							<% ImageUtil.createImage(); %>
							<img class="yzm_img" id='imgVcode' src="" />
							<input name="number" type="text" id="txtCode" class="yzm_input"/>
							
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									
									
									<a id="imageCode" href="#" >看不清楚？换个图片</a>
								</p>
								<span id="number.info" style="color:red"></span>
			

	</body>
</html>

