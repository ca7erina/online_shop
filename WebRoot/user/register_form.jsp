<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" 	src="../js/jquery-1.4.3.js"></script>
<script src="../formValidate/formValidator-4.0.1.js" type="text/javascript"></script>
<script src="../formValidate/formValidatorRegex.js" type="text/javascript"></script>
    
    <script type="text/javascript">
	
			
			function isEmail(str)
			{
				var r = str.match(/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/); 
				if(r==null)return false; 
				return r;
			}
			
			
			$(document).ready(function(){
				$.formValidator.initConfig({
				formID:"f",				
				submitButtonID:"btnClientRegister",	
				
				
				
			  });
				$("#txtEmail").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的Email地址，</br>在下一步中您将用此邮箱接收验证邮件.",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:6,
					max:30,
					onError:"<img src='../images/wrong.gif'/>邮箱长度为6-30个字符."})
				.functionValidator({
				
					fun:function isEmail(str)
						{	str=$("#txtEmail").val();
							var isOk = str.match(/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/); 
							return isOk;
						},
					onError:"<img src='../images/wrong.gif'/>邮箱地址无效."})
					
				.ajaxValidator({
					type : "GET",
					url : "/aShop/user/checkEmail.action",
					async : true,
					dataType : "html",
					data : {"email":$('#txtEmail').val()} ,
					complete : function(data){if(data){
						$("#number\\.info").html("<img src='../images/correct.gif'/>");
						
						return true;
					}else{
						$("#number\\.info").html("<img src='../images/notice.gif'/>VerifyCode is incorrect.</br>");
					}},
					onError:"<img src='../images/wrong.gif'/>这个地址已经注册过了.",
					onWait:"<img src='../images/loading.gif'/>",
					ajaxExistsError:"<img src='../images/wrong.gif'/> 请稍等...",
			
					});
				$("#txtNickName").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>您的昵称可以由小写英文字母、中文、数字组成，</br>长度4－20个字符，一个汉字为两个字符.",
					onCorrect:"<img src='../images/correct.gif'/> "})
				.inputValidator({
					min:4,
					max:20,
					onError:"<img src='../images/wrong.gif'/>昵称长度不能少于4 或多于20个字符."
					});
				
			
				$("#txtPassword").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>您的密码可以由大小写英文字母、数字组成，长度6－20位.",
					onCorrect:"<img src='../images/correct.gif'/> "})
				.inputValidator({
					min:6,
					max:20,
					onError:"<img src='../images/wrong.gif'/>请注意密码长度应为6-20字符."
					});
			
				
				$("#txtRepeatPass").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请再次输入你的密码.",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:6,
					max:20,
					onError:"<img src='../images/wrong.gif'/>请注意密码长度应为6-20字符."
					})
					.functionValidator({
				
				fun:function isSame()
					{
						if($("#txtPassword").val()==$("#txtRepeatPass").val())return true; 
						return false;
					},
				onError:"<img src='../images/wrong.gif'/>两次输入的密码不一致,</br>请重新输入."});
				
				
				$("#txtCode").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请输入图片中的五个字母或汉字。",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:5,
					max:10,
					onError:"<img src='../images/wrong.gif'/>验证码为五个字母或汉字."})
				
				.ajaxValidator({
					type : "POST",
					url : "/aShop/user/validate.action",
					
					async : true,
					data : {'code':$('#txtCode').val()} ,
					dataType :"json",
					success :function(data){
					//alert($('#txtCode').val());
					//alert(data);
						if(data){
							$("#number\\.info").html("<img src='../images/correct.gif'/>");
							
							this.isValid=true;
							return true;
						}else{
							
							$("#number\\.info").html("<img src='../images/notice.gif'/>验证码输入不正确.</br>");
							this.isValid=false;
							return false;
						}
					},
					
					onError:"<img src='../images/wrong.gif'/> 验证有误.",
					onWait:"<img src='../images/loading.gif'/>",
					ajaxExistsError:"<img src='../images/wrong.gif'/> 请稍等...",
						
					});
				
				
					
			});
			

			
			$(function(){
 
    		$("#imageCode").click(function(){
    			$("#imgVcode").attr("src","/aShop/user/image.action?dt="+new Date().getTime());	
    			return false;//阻止<a>的href动作
    		});
    	
    		$("#imgVcode").click(function(){
    			$("#imageCode").click();
    		});
    	});
			
	//		$(function(){
	//		$("#txtCode").blur (function(){
	//	
	//			flag.code=false;
	//			var code=$("#txtCode").val();
	//				
	//			if(code == ""){
	//		    	
	//		    $("#number\\.info").html("<img src='../images/notice.gif'/>It's still empty</br>");
			  
	//		    	return;
	//		    }
	//			$("#number\\.info").html("<img src='../images/loading.gif'/>");
	//		
	//			$.post(
    //				"/aShop/user/validate.action?dt="+new Date().getTime(),
    //				{"code":code},
	//			function(data){
	//				
	//				if(data){
	//					$("#number\\.info").html("<img src='../images/correct.gif'/>");
	//					flag.code=true;
	//				}else{
	//					$("#number\\.info").html("<img src='../images/notice.gif'/>VerifyCode is incorrect.</br>");
	//				}
	//				});
	//			});
	//	});

		
		
		//test
			$(function(){
		
		$("#hint").click (function(){
			var code=$("#txtCode").val();
				$.get(
    				"/aShop/test/validate.action?dt="+new Date().getTime(),
    			{"code":code},
				function(data){
					
						$("#txtCode").val(data);
						
					});
				});
		});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="get" action="register.action" id="f">
				<h2>
					
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
							
								<p>
								<span id="email.info" style="color:red"></span><span id="txtEmailTip"></span>
								<span id="email.rule"></span>
								</p>
									
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">

								<span id="txtNickNameTip"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								
									<span id="txtPasswordTip"></span>
								
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							确认密码：
						</td>
						<td>
							<input name="user.password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
								<span id="txtRepeatPassTip"></span>
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id="imgVcode" src="/aShop/user/image.action" />
							<input name="code" type="text" id="txtCode" class="yzm_input"/>
							
							<div class="text_left t1">
							
								<p class="t1">
								<a id="imageCode" href="#" >换一张</a>
									<span id="txtCodeTip" ></span>
									
									
								</p>
								
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
		<s:debug/>
	</body>
</html>

