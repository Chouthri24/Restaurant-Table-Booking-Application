package com.payment;

public class UPI extends Payment{
		private String upi_id;

		
		public String getUpi_id() {
			return upi_id;
		}
		
		public void setUpi_id(String upi_id) {
			this.upi_id = upi_id;
		}
		
		public void paymentUPIOperation(String upi) {
				
				this.upi_id=upi;
		}
		
}
