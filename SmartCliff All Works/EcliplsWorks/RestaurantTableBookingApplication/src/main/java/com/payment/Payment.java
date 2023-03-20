package com.payment;

import java.util.ArrayList;
import java.util.Scanner;

import com.booking.Booking;
import com.main.ConnectionProvider;

public class Payment {
	
		public static ArrayList<Payment> paymentobjlist=new ArrayList<Payment>();
		
		protected String order_id;
		protected String res_id;
		protected String payment_type;
		protected int amount;
		protected String payment_status;
		public int order_status;
		protected String customer_id;
		
		public Card card_obj_main;
		public UPI ui_obj_main;
		
		
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}
		public String getRes_id() {
			return res_id;
		}
		public void setRes_id(String res_id) {
			this.res_id = res_id;
		}
		public Card getCard_obj_main() {
			return card_obj_main;
		}
		public UPI getUi_obj_main() {
			return ui_obj_main;
		}
		public void setCard_obj_main(Card card_obj_main) {
			this.card_obj_main = card_obj_main;
		}
		public void setUi_obj_main(UPI ui_obj_main) {
			this.ui_obj_main = ui_obj_main;
		}
		public static Scanner read=new Scanner(System.in);
		public static ArrayList<Payment> getPaymentobjlist() {
			return paymentobjlist;
		}
		public String getOrder_id() {
			return order_id;
		}
		public String getPayment_type() {
			return payment_type;
		}
		public double getAmount() {
			return amount;
		}
		public String getPayment_status() {
			return payment_status;
		}
		public static void setPaymentobjlist(ArrayList<Payment> paymentobjlist) {
			Payment.paymentobjlist = paymentobjlist;
		}
		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}
		public void setPayment_type(String payment_type) {
			this.payment_type = payment_type;
		}
		
		public void setPayment_status(String payment_status) {
			this.payment_status = payment_status;
		}
		
		public int getOrder_status_obj() {
			return order_status;
		}
		public void setOrder_status_obj(int order_status_obj) {
			this.order_status = order_status_obj;
		}
		public void paymentOperation(ConnectionProvider cnpv,String card_no,String card_holder_name,String upi,String cusid,int or_st,String orderid,String res_id2,String payment_type,
				int amount,String payment_status) 
		
		{		this.order_status=or_st;
			    this.res_id=res_id2;
				this.order_id=orderid;
				this.payment_type=payment_type;
				this.amount=amount;
				this.payment_status=payment_status;
				this.customer_id=cusid;
				
				cnpv.paymentOperation(card_no,card_holder_name,upi,cusid,or_st,orderid,res_id2,payment_type,
						amount,payment_status); 
				
		}
		
}