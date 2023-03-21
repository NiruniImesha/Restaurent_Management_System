package com.mtit.deliverysubscriber;

import com.mtit.deliverypublisher.DeliveryPublish;
//import com.mtit.deliverypublisher.DeliveryPublishImpl;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class DeliverySubscriberActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		serviceReference = context.getServiceReference(DeliveryPublish.class.getName()); //refer previously registered delivery service 
		DeliveryPublish deliveryPublish = (DeliveryPublish)context.getService(serviceReference);
		
		while(true) {
			
			if( deliveryPublish == null ) {
				
				System.out.println("Delivery Publisher / Redeem Publisher is Offline.");
				break;
			}
			
			System.out.println("Delivery Service Consumer Started.");
			
			DeliveryPublish dp = (DeliveryPublish) context.getService(serviceReference);
		
			System.out.println("\n--------- Welcome to Terrace Restaurant - Delivery Service ---------");
			System.out.print("\n\n--------------------------------------");
			System.out.print("\n\t\tSERVICE LIST  \n");
			System.out.println("--------------------------------------");
			System.out.print("\n\n");
			System.out.println("\t[1]. Generate Delivery Charges");
			System.out.println("\t[2]. Check Eligibility Discounts");
			System.out.println("\t[3]. Sign-off");
			System.out.println("\n--------------------------------------");
			
			System.out.println("");
			System.out.print("Enter the number of the service required : ");
			
			int sNo = sc.nextInt();
			
			
			if(sNo == 1) {
				
				dp.getUserInput();
				dp.selectOrderCount();
				dp.selectPaymentmethod();
				dp.generateDeliveryCharges();
				

			} else if (sNo == 2) {
				
				dp.checkOffers();
				
			} else {
				System.out.println("Good byee..");
				break;
			}
			
			System.out.println("");
			System.out.println("");
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("--- Good Bye ---");
		context.ungetService(serviceReference);
	}

}