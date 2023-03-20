package com.restaurantdetails;

import com.main.ConnectionProvider;
import com.persondetails.Restaurant;

public class Tables {

	private String tableType;
	public TableSeats tableSeats;
	private int basictableseatamount;
	private int premiumtableseatamount;
	
	public int getBasictableseatamount() {
		return basictableseatamount;
	}
	public int getPremiumtableseatamount() {
		return premiumtableseatamount;
	}
	public void setBasictableseatamount(int basictableseatamount) {
		this.basictableseatamount = basictableseatamount;
	}
	public void setBasictableseatamountCnpv(int basictableseatamount,ConnectionProvider cnpv,Restaurant obj) {
		this.basictableseatamount = basictableseatamount;
		cnpv.updateBasicTableAmount(basictableseatamount,obj);
	}
	public void setPremiumtableseatamount(int premiumtableseatamount) {
		this.premiumtableseatamount = premiumtableseatamount;
	}
	
	public void setPremiumtableseatamountCnpv(int premiumtableseatamount,ConnectionProvider cnpv,Restaurant obj) {
		
		this.premiumtableseatamount = premiumtableseatamount;
		
		cnpv.updatePremiumTableAmount(premiumtableseatamount,obj);
	}
	
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public TableSeats getTableSeats() {
		return tableSeats;
	}
	public void setTableSeats(TableSeats tableSeats) {
		this.tableSeats = tableSeats;
	}
	
	
}
