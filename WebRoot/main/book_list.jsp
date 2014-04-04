<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>

		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" 	src="../js/jquery-1.4.3.js"></script>
		<script src="../formValidate/formValidator-4.0.1.js" type="text/javascript"></script>
		<script src="../formValidate/formValidatorRegex.js" type="text/javascript"></script>
   		 <script type="text/javascript">
		</script>
		<script>
			$(function(){
			$("a[name='buy']").click(function(){
					var productId = $(this).attr("id");
				
					$(this).remove();	
					$.post(
					'/dangdang/cart/buy.action?s='+(new Date()).getTime(),
					'productId='+ productId,
					function(data){
						if(data){
							$('#cartinfo'+productId).show("slow",function(){
								$('#cartinfo'+productId).html("<img src='../images/correct.gif'/>放入购物车");
							});
						$('#cartinfo'+productId).html("<img src='../images/correct.gif'/>放入购物车");

						}else{	
						
						$('#cartinfo'+productId).show("slow",function(){
							$('#cartinfo'+productId).html("<img src='../images/wrong.gif'/>已经放入购物车");
						});
						$('#cartinfo'+productId).html("<img src='../images/wrong.gif'/>已经放入购物车");
						}
					},'json');
				
				
				
			});
			
			
			});
		$(function(){
			
		
				$('a[name=<s:property value='subctgy'/>]').css("color","red");
		

		});
		
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='/dangdang/main/main.jsp'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong><s:property value="category.name"/></strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(<s:property value="category.pnum"/>)
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<s:iterator value="subctgys" var="c2" status="i">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a id='subcategorylink' name='<s:property value="id"/>' href='/dangdang/list/booklist.action?ctgy=<s:property value="parentid"/>&subctgy=<s:property value="id"/>'><s:property value="name"/>
										&nbsp(<s:property value="pnum"/>)</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						    <!--2级分类结束-->
						    </s:iterator>
							
							
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">
		
				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page!=1">
								<div class='list_r_title_text3a'>
									<a name=link_page_prev
										href="/dangdang/list/booklist.action?ctgy=<s:property value="ctgy"/>&subctgy=<s:property value="subctgy"/>&page=<s:property value="page-1"/>">
									<img src='../images/page_up.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_up_gray.gif' />
								</div>
							</s:else>

							<div class='list_r_title_text3b'>
								第<s:property value="page"/>页/共<s:property value="totalPage"/>页
							</div>
							<s:if test="page!=totalPage">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="/dangdang/list/booklist.action?ctgy=<s:property value="ctgy"/>&subctgy=<s:property value="subctgy"/>&page=<s:property value="page+1"/>">
										<img src='../images/page_down.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</s:else>


							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<s:iterator value="books" var="b">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="../productImages/<s:property value="id"/>.jpg" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='#'><s:property value="name"/></a>
							</h2>
							<h3>
								顾客评分：100;
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'><s:property value="author"/></a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'><s:property value="publishing"/></a>
							</h4>
							<h4>
								出版时间：<s:date name="publishTime"/>
							</h4>
							<h5>
								<s:property value="summary"/>
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="fixedprice"/></span>
								<span class="red">￥<s:property value="dangprice"/></span>
								节省：￥<s:property value="fixedprice-dangprice"/>
								
							</h6>
							<span id="cartinfo<s:property value="id"/>"></span>
							<span class="list_r_list_button"> 
							<span id="cartinfo<s:property value="id"/>"></span>
							<a name="buy" href="javascript:" id="<s:property value="id"/>"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							</span>
						</div>
						
						<div class="clear"></div>
						
						<!--商品条目结束-->
						</s:iterator>

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
						<!--分页导航开始-->
							<s:if test="page!=1">
								<div class='list_r_title_text3a'>
									<a name=link_page_prev
										href="/dangdang/list/booklist.action?ctgy=<s:property value="ctgy"/>&subctgy=<s:property value="subctgy"/>&page=<s:property value="page-1"/>">
									<img src='../images/page_up.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_up_gray.gif' />
								</div>
							</s:else>

							<div class='list_r_title_text3b'>
								第<s:property value="page"/>页/共<s:property value="totalPage"/>页
							</div>
							<s:if test="page!=totalPage">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="/dangdang/list/booklist.action?ctgy=<s:property value="ctgy"/>&subctgy=<s:property value="subctgy"/>&page=<s:property value="page+1"/>">
										<img src='../images/page_down.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</s:else>


							<!--分页导航结束-->
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
