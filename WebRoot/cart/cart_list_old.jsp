<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" 	src="../js/jquery-1.4.3.js"></script>
		<script src="../formValidate/formValidator-4.0.1.js" type="text/javascript"></script>
		<script src="../formValidate/formValidatorRegex.js" type="text/javascript"></script>
   		 <script type="text/javascript">
   		 
   		 
   		 
   		//caculate the all kinds of price showing on the page.
   		 $(function(){
   			calcu();
   		
   		 	});
   		 	
   		var calcu=function(){

   		 	var x= $('#title').siblings('.td_no_bord').children(".buy_td_5").text();
   		 
			var	y=x.replace(/\s+/g,"");
			var z=y.split("￥");
			var fixed=0;
		for(var j=1;j<z.length;j++){
		
			fixed=fixed+parseInt(z[j]);
		}
		
		
    	x= $('#title').siblings('.td_no_bord').children(".buy_td_4").text();
  
		y=x.replace(/\s+/g,"");
		z=y.split("￥");
		 w=0;
		for(var i=1;i<z.length;i++){
			w=w+parseInt(z[i]);
		}
  		 $('#total_account').html(w);
   		 
  		  $('#total_economy').html(fixed-w);
   		 
   		 };
   		 	// modify checking and modify submit;
   		$(function(){
   	
			$("input[name='changeqty']").blur(function(){
					var re=new RegExp("\\D+");
					var c=$(this).val();
					
					if($(this).val()==null||$(this).val().length<=0||$(this).val()==0){
						$(this).next('.modifyLink').eq(0).css("visibility","hidden");
						$(this).siblings('.modifyTip').html("<br/>请填写购买的数量.");
					}else if(re.test(c)){
						$(this).next('.modifyLink').eq(0).css("visibility","hidden");
						$(this).siblings('.modifyTip').html("&nbsp;请填写购买的数量.");
					}else{
						$(this).next('.modifyLink').eq(0).css("visibility","visible");
						$(this).siblings('.modifyTip').html("");
					}
					calcu();
			});
			
			$("a[name='modify']").click(function(){
					var productId = $(this).attr("id");	
					var qty=$(this).prev('.del_num').eq(0).val();
					var thisObj=$(this);
					var getJson=function(){
					$.getJSON("/dangdang/cart/modify.action?productId="+productId+"&newQty="+qty, function(json){			
						if(json.modified){				
							thisObj.parent().prev().html("&nbsp;&nbsp;"+json.newQty);
							thisObj.parent().prev().prev().html("&nbsp;&nbsp;￥"+json.newQty*json.product.dangprice+".0");
							thisObj.parent().prev().prev().prev().html("￥"+json.newQty*json.product.fixedprice+".0");
						}else{
							$(this).siblings('.modifyTip').html("库存不足");
						}
						calcu();
					});	
					};
					getJson();
					calcu();
				});

			});
			// delete submit and display the product just deleted.
			 $(function(){
				$("a[name='delete']").click(function(){
					var productId = $(this).attr("id");	
					$(this).parent().parent().fadeOut("fast");
					location="/dangdang/cart/delete.action?productId="+ productId;
				//		$.getJSON("/dangdang/cart/deletejson.action?productId="+productId, function(json){
				//		 $("#deletedName").html(json.product.productname);
				//		 $("#deletedDangprice").html(json.product.dangprice);
				//		$("#deletedFixedprice").html(json.product.fixedprice);
				//		$("#deletedProductId").html(json.product.id);
				//		var name=json.product.productname;
				//		var dangprice=json.product.dangprice;
				//		var fixedprice=json.product.fixedprice;
				//		var id=json.product.id;
				//		var tr="<tr><td width='58' class='buy_td_6'>&nbsp;</td><td width='365' class=t2><a id='deletedName' href='#'>"+name+"</a></td>"+"<td id='deletedFixedprice'width='106' class='buy_td_5'>"+fixedprice+"</td>"+"<td id='deletedDangprice' width='134' class='buy_td_4'>"+fixedprice+"<span></span></td>"+"<td width='56' class=buy_td_1><a id='"+id+"' name='undelete' href='javascript:' src='undelete()'>恢复</a></td>"+"<td width='16' class='objhide'>&nbsp;</td></tr>";
				//		$("#undeleteRow").append(tr);
				//		 $("a[name='undelete']").attr("id",productId);
				//		 });	
				//		 $("#divCartItemsRemoved").css("visibility","visible");
	  $("#divCartItemsRemoved").css("visibility","visible");
					
				});
			 
			 });
			 
			 
			//undelete the item
			$(function(){
	
			if($("#undeleteTbody").children().eq(0).html()==null){
				  $("#divCartItemsRemoved").css("visibility","hidden");
			}
		
			$("a[name='undelete']").click(function(){		
					var productId = $(this).attr("id");						
				location="/dangdang/cart/undelete.action?productId="+ productId;
			});
			
			
			});
			//set "orderbutton"
			$(function(){
		
				if($("#title").siblings(".td_no_bord").html()==null){
				  $("#balance_div").css("visibility","hidden");
				}
			});
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品<span id="test"></span>
			</h2>
			<div class="choice_bord" >
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title" id="title" >
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8" >
							&nbsp;
						</td>
					</tr>
				<s:iterator value="#session.cart" var="sc1" status="i">
					<s:iterator value="buy" var="sc2" status="st">
						
                      <!-- 购物列表开始 -->
						<tr class='td_no_bord' >
							<td style='display: none'>
								<s:property value="product.id"/>
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#"><s:property value="product.productname"/></a>
							</td>
							<td class="buy_td_5"><span class="c_gray">￥<s:property value="product.fixedprice*qty"/></span>
							</td>
							<td class="buy_td_4">&nbsp;&nbsp;<span>￥<s:property value="product.dangprice*qty"/></span>
							</td>
							<td class="buy_td_1" id="qty<s:property value="product.id"/>">
								&nbsp;&nbsp;<s:property value="qty"/>
							</td>

							<td >
								<input name ="changeqty"  class="del_num" type="text" size="3" maxlength="4" value="<s:property value="qty"/>"/>
								<a  id="<s:property value="product.id"/>" name="modify" href="javascript:" class="modifyLink" >变更</a>
								<span class="modifyTip" style="font-size:10px;color:red"></span>
							</td>
							<td>
								<a  id="<s:property value="product.id"/>" name="delete" href="javascript:">删除</a>
							</td>
						</tr>
				
						</s:iterator>
						</s:iterator>
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>
					<div id="balance_div" class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy"></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='/dangdang/order/orderView.action' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch" >
			<div class="del_title" >
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody id="undeleteTbody">
				<s:iterator value="#session.cart" var="sc1" status="i">
					<s:iterator value="unbuy" var="sc2" status="st">		
					 <tr id ="undeleteRow">
						<td  width="58" class=buy_td_6>
							&nbsp;
						</td>
				<td width="365" class=t2>
							<a id="deletedName" href="#"><s:property value="product.productname"/></a>
						</td>
						<td id="deletedFixedprice"width="106" class="buy_td_5">
							<s:property value="product.fixedprice"/>
						</td>
						<td id="deletedDangprice" width="134" class="buy_td_4">
							<s:property value="product.dangprice"/><span></span>
						</td>
						<td width="56" class=buy_td_1>
							<a id="<s:property value="product.id"/>" name="undelete" href="javascript:">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					</s:iterator>
					</s:iterator>
				
				


				</tbody>
			</table>
		</div>
	
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



