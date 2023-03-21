package com.mtit.deliverypublisher;

import java.time.LocalDateTime;

public interface DeliveryPublish {
	
	public String publishService();
	
	public void selectPaymentmethod();
	
	public void selectOrderCount();
	
	public String getUserInput();
	
	public String getTimeCategory(LocalDateTime dateTime);
	
	public void generateDeliveryCharges();
	
	public void checkOffers();
}
