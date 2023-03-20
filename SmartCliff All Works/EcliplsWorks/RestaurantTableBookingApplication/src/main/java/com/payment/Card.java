package com.payment;

public class Card extends Payment{
		private String card_number;
		private String card_holder_name;
		public String getCard_number() {
			return card_number;
		}
		public String getCard_holder_name() {
			return card_holder_name;
		}
		public void setCard_number(String card_number) {
			this.card_number = card_number;
		}
		public void setCard_holder_name(String card_holder_name) {
			this.card_holder_name = card_holder_name;
		}
		
		public void paymentCardOperation(
				String cardno,String card_holder_name) {
				this.card_holder_name=card_holder_name;
				this.card_number=cardno;
		}
		
		
}
