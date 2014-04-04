package service;

import java.util.ArrayList;

import action.cart.Cart;

import entity.CartItem;

public class CaculatePrice {

	
	public double getTotalPrice(Cart cart){
		 ArrayList<CartItem> items=(ArrayList<CartItem>) cart.getBuy();
		int totalPrice=0;
		 for(CartItem i:items){
			 totalPrice+=i.getQty()*i.getProduct().getDangprice();
		 }
		
		System.out.println("calcu totalprice "+totalPrice);
		System.out.println("(calcu totalprice) cart"+cart);
		return totalPrice;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
