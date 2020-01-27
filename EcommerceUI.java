package com.robomq.ecomUI;

import java.util.Scanner;

import com.robomq.pojo.Customer;
import com.robomq.service.CustomerServiceImpl;

public class EcommerceUI {

	static Customer c;
	Scanner sc;
	static CustomerServiceImpl service;
	public EcommerceUI()
	{
		sc=new Scanner(System.in);
		c=new Customer();
		service=new CustomerServiceImpl();
	}
	public void registerCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		System.out.println("Enter Customer Name.");
		c.setName(sc.next());
		System.out.println("Enter Customer email.");
		c.setEmail(sc.next());
		System.out.println("Enter Customer address.");
		c.setAddress(sc.next());
		System.out.println("Enter Customer Mobileno.");
		c.setMobileno(sc.next());
		if(service.createCustomer(c))
			System.out.println("Customer registered successfully...");
		else
			System.out.println("Customer Not registered ...");
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ch=null;
		EcommerceUI e=new EcommerceUI();
		/*while(true)
		{*/
			System.out.println("Enter Your Choice");
			System.out.println("1. Registring New Customer");
			System.out.println("2. Login as Existing Customer");
			System.out.println("3. Exit");
			ch=sc.next();
			switch(ch)
			{
				case "1":
				{
					e.registerCustomer();
					break;
				}
				case "2":{
					service.validateCustomer(c);
					break;
				}
				case "3":
				{
					System.exit(0);
					break;
				}
				default:
					System.out.println("Enter the valid no to continnue...");
			}
		}
		//}
	}


