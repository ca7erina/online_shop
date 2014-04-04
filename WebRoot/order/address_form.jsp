<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" 	src="../js/jquery-1.4.3.js"></script>
		<script src="../formValidate/formValidator-4.0.1.js" type="text/javascript"></script>
		<script src="../formValidate/formValidatorRegex.js" type="text/javascript"></script>
		<script type="text/javascript">
		 		$(document).ready(function(){
				$.formValidator.initConfig({
					formID:"f",				
					submitButtonID:"btnClientRegister",	

				  });
				$("#receivename").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的收件人姓名.",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:2,
					max:16,
					onError:"<img src='../images/wrong.gif'/>请填写有效的收件人姓名."})
				.functionValidator({
				
					fun:function isName(str)
						{	return true;
						},
					onError:"<img src='../images/wrong.gif'/>姓名无效."});
					
			
				$("#fulladdress").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的收件人的详细地址：.",
					onCorrect:"<img src='../images/correct.gif'/> "})
				.inputValidator({
					min:20,
					max:100,
					onError:"<img src='../images/wrong.gif'/>长度不能少于20 或多于100个字符."
					});
				
			
				$("#postalcode").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的收件人的邮政编码.",
					onCorrect:"<img src='../images/correct.gif'/> "})
				.inputValidator({
					min:6,
					max:8,
					onError:"<img src='../images/wrong.gif'/>长度应为6字符."
					});
			
				
				$("#phone").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的收件人的电话.",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:8,
					max:15,
					onError:"<img src='../images/wrong.gif'/>长度应为8-15字符."
					})
					.functionValidator({
				
				fun:function isSame()
					{
						return true;
					},
				onError:"<img src='../images/wrong.gif'/>."});
				
				
				$("#mobile").formValidator({
					onShow :"",
					onFocus:"<img src='../images/notice.gif'/>请填写有效的收件人的手机。",
					onCorrect:"<img src='../images/correct.gif'/>"})
				.inputValidator({
					min:11,
					max:15,
					onError:"<img src='../images/wrong.gif'/>长度应为11-15字符."});
				
				
				
					
			});
		
			$(function(){
				var addr=[<s:iterator value="addresses" var="a" status="st">
					   ['<s:property value="id"/>',
						'<s:property value="receivename"/>',
						'<s:property value="fulladdress"/>',
						'<s:property value="postalcode"/>',
						'<s:property value="mobile"/>',
						'<s:property value="phone"/>'],
						</s:iterator>];
				

				if(addr.length>=0&&addr.length<5){
					$('#newAddress').css("visibility","visible");

				}else{
					$('#newAddress').css("visibility","hidden");
				}
				
				$("#address").change(function(){
				
					if($("#address option:selected").html().replace(/\s+/g,"")=="New"){
					$("#addressId").val(-1);
					return;
					}else{
					 var id=$("#address option:selected").html().replace(/\s+/g,"").replace("Address-","");
					 var len=addr.length;
						for(var i=0;i<len;i++){
							if(addr[i][0]==id){
							$("#receivename").val(addr[i][1]);
							$("#add_hidden").val(addr[i][2]);
							alert(addr[i][2]);
							$("#postalcode").val(addr[i][3]);
							$("#mobile").val(addr[i][4]);
							$("#phone").val(addr[i][5]);
							$("#addressId").val(addr[i][0]);
							}
						}
					}
				
				}).trigger('change');
				
			});
			
			
		 
		</script>
	</head>
	<body>
<%@include file="../common/head1.jsp"%> 
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message" >
			<p id="fill_message_p">
				选择地址：
				<select id="address">
				<s:iterator value="addresses" var="a" status="st">
					<option>
						Address-<s:property value="id"/>
					</option>

				</s:iterator>
					
					<option id="newAddress">
						New
					</option>
					
				</select>
			</p>
			
			<form name="addressInfo" method="get" action="saveOrder.action" id="f">
			<s:debug/>
				<input type="hidden" name="deliverinfo.id" id="addressId" value="" />
				<input type="hidden" name="add_hidden" id="add_hidden" value="" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="deliverinfo.receivename"
								id="receivename" />
							<div class="text_left" id="receivenameTip">
								<p>
									
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="deliverinfo.fulladdress" class="text_input"
								id="fulladdress" />
							<div class="text_left" id="fulladdressTip">
								<p>
									
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码：
						</td>
						<td>
							<input type="text" class="text_input" name="deliverinfo.postalcode"
								id="postalcode" />
							<div class="text_left" id="postalcodeTip">
								<p>
									
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话：
						</td>
						<td>
							<input type="text" class="text_input" name="deliverinfo.phone"
								id="phone" />
							<div class="text_left" id="phoneTip">
								<p>
									
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机：
						</td>
						<td>
							<input type="text" class="text_input" name="deliverinfo.mobile"
								id="mobile" />
							<div class="text_left" id="mobileTip">
								<p>
									
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

				<a href="/dangdang/order/order_info.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="上一步" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%> 
	</body>
</html>

