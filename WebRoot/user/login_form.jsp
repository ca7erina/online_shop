<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" 	src="../js/jquery-1.4.3.js"></script>
		<script src="../formValidate/formValidator-4.0.1.js" type="text/javascript"></script>
		<script src="../formValidate/formValidatorRegex.js" type="text/javascript"></script>
   		 <script type="text/javascript">
   		 	$(document).ready(function(){
				$.formValidator.initConfig({
				formID:"ctl00",				
				submitButtonID:"btnSignCheck",	
				
				
				
			  });
				$("#txtUsername").formValidator({
					onShow :"",
					onFocus:"",
					onCorrect:"",
					onEmpty: "<img src='../images/wrong.gif'/> 邮箱地址不能为空."})
				.inputValidator({
					min:6,
					max:30,
					onError:"<img src='../images/wrong.gif'/> 请填写正确邮箱地址  "})
				.functionValidator({
				
					fun:function isEmail()
						{	
							str=$("#txtUsername").val();
							var match = str.match(/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/); 
							if(match==null){
								return false;
							}else{
								return true;
							}
							
						},
					onError:"<img src='../images/wrong.gif'/>无效的邮箱地址"});

				$("#txtPassword").formValidator({
					onShow :"",
					onFocus:"",
					onCorrect:"",
					onEmpty: "<img src='../images/wrong.gif'/> 密码不能为空."})
				.inputValidator({
					min:6,
					max:20,
					onError:"<img src='../images/wrong.gif'/>"
					});
				
			});
			
			
   		 </script>
	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>
		
			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
						<s:property value="#request.loginError"/>
				
					</div><span id="txtUsernameTip" id="txtPasswordTip"></span>
					<div class="main">
						<h3>
							登录当当网
							
						</h3>
					
						<form method="post" action="/dangdang/user/login.action" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="email" id="txtUsername" class="textbox" />
								</li>
							
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword"
										class="textbox" />
										
								</li>
							
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />


								</li>
								
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

