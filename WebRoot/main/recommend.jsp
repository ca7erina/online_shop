<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<h2>
	编辑推荐
</h2>

<div id=__bianjituijian/danpin>

	<div class=second_c_02>
		
		<div class=second_c_02_b1>
		<s:iterator value="recommendProducts" var="n1">
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="../productImages/<s:property value="id"/>.jpg" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'></a>
				</h3>
				<h4>
					作者：<s:property value="author"/> 著
					<br />
					出版社：<s:property value="publishing"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:date name="publishTime"/>
				</h4>
				<h5>
					简介<s:property value="summary"/>
				</h5>
				<h6>
					定价：￥<s:property value="fixedprice"/>&nbsp;&nbsp;当当价：￥<s:property value="dangprice"/>
				</h6>
				<div class=line_xx></div>
			</div>
			</s:iterator>
		</div>
		
	</div>
	
</div>
