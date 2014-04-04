1. Project Background
-------------------------------
     Implement a e-commerce system similar to Chinese online retailer dangdang.com, which includes following functional requirements:
   1) User Management
	Login, User registration, Permission management
   2) Product Category
	Main interface to the user, browse products by category, show product details
   3) Cart
        Purchase, update product count, cancel, list view, total amount display
   4) Order
	Create Order(with order management)

2. Technologies used:
-------------------------------
System is implemented in MVC fashion:
Views: JSP, jQuery. Ajax, Struts2+EL
Contollers: Struts2 Action Controllers
Models: Service objects
Data Access Layer: DAP + DB connection pool using dbcp, c3p0, proxool
The usage of connection pool saves the cost of creating connections for each invocation by reusing created database connections. The size of the connection pool is configurable.

3. Database design
----------------------------
Following is a list of tables:
 1)d_user stores user information
 2)d_category
stores product category, used to display product categories on the homepage
   
  3)d_product
stores product detail information
  4)d_book
stores book information

  5)d_category_product
stores relationship between products and categories

  6)d_receive_address
stores deliver addresses for users
  7)d_order
stores orders information

  8)d_item
stores items for each order


4. Project Structure:
------------------------------------
 1)Web Project including following jar dependencies
     a. struts2
        commons-io.jar
        struts-json-plugin.jar
     b. Database Driver mysql.jar
  2)Configuration for Struts2
      a.web.xml(filter and action mapping)
      b.src/struts.xml\
           struts-user.xml//configuration for user management
           struts-cart.xml//configuration for shopping cart
           struts-order.xml//configuration for order
           struts-main.xml//configuration for product category
  3)Source code structure
      action
         action.user
         action.order
         action.cart
         action.main
      service
      dao
      pojo
      util
      interceptor
  4)Jsp layout
      WebRoot/user/ :JSP for user management
      WebRoot/cart/ :JSP for shopping cart
      WebRoot/order/ :JSP for orders
      WebRoot/main/ :JSP for product category
      WebRoot/common/ :JSP for header and footer of home page
      WebRoot/css/ :css
      WebRoot/js/ :javascripts
      WebRoot/images/ :images
      WebRoot/productImages/ :product images
