package com.robomq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.robomq.dao.DBConnection;
import com.robomq.pojo.Customer;

public class CustomerServiceImpl {
	Connection con;
	PreparedStatement pre;
	int ra;
	ResultSet res;
	boolean flag=false;
	Scanner sc = new Scanner(System.in);
	
	public CustomerServiceImpl()
	{
		con=DBConnection.getConnection();
	}

	//Register a New Customer
	public boolean createCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("insert into customer11 values(?,?,?,?,?)");
			pre.setInt(1,c.getId());
			pre.setString(2,c.getName());
			pre.setString(3,c.getEmail());
			pre.setString(4,c.getAddress());
			pre.setString(5,c.getMobileno());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ResultSet displayCustomer(int cid)
	{
		try {
			pre=con.prepareStatement("select * from customer11 where id=?");
			pre.setInt(1,cid);
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public void updateCustomer(int cid , Customer c){
		
		
		try {
		flag=false;
		System.out.println("Do you want to update name if yes type yes if no type no\n");
		String ch=sc.next();
		if(ch.equals("yes")) {
		System.out.println("Enter name to update the name\n");
		
		String name=sc.next();
		c.setName(name);
		
		pre=con.prepareStatement("update Customer11 set name=? where id=?");
		pre.setString(1, c.getName());
		pre.setInt(2,cid);
		
		int re=pre.executeUpdate();
		if(re>0) {
			System.out.println("Name updated Successfully");
		}
		else {
			System.out.println("Name Not updated Successfully");
		}
		pre.close();
		}
		else {
			System.out.println("Continuue...");
		}
		
		
		
		System.out.println("Do you want to update address if yes type yes if no type no\n");
		String chw=sc.next();
		if(chw.equals("yes")) {
		System.out.println("Enter Address to be updated\n");
		
		String address=sc.next();
		c.setAddress(address);
		
		pre=con.prepareStatement("update Customer11 set address=? where id=?");
		pre.setString(1, c.getAddress());
		pre.setInt(2,cid);
		
		int re=pre.executeUpdate();
		if(re>0) {
			System.out.println("Address updated Successfully");
		}
		else {
			System.out.println("Address Not updated Successfully");
		}
		pre.close();
		}
		else {
			System.out.println("Continuue...");
		}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		}
	}
	
	
	public boolean deleteCustomer(int cid) {
		flag=false;
		
		try {

			pre=con.prepareStatement("delete from Customer11 where id=?");
			pre.setInt(1,cid);
			int re=pre.executeUpdate();
			if(re>0) {
				flag=true;
				
			}
			else {
				flag=false;		
				}
			pre.close();
			}
	
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	
	public void validateCustomer(Customer c) {
		
		System.out.println("Enter Customer id to login");
		
		int id=(sc.nextInt()); 
		try {
			
			pre=con.prepareStatement("select * from Customer11 where id=?");
			pre.setInt(1,id);
			res=pre.executeQuery();
			
			
			if(res.next()) {
				System.out.println("login successfully");
				
				//updateCustomer();
				
				System.out.println("The detail of cutomer\n");
				
					System.out.println("Customer_id: "+res.getInt("id"));
					
					System.out.println("CustomerName: "+res.getString("name"));
					System.out.println("CustomerEmail: "+res.getString("email"));
					System.out.println("CustomerMobile: "+res.getString("mobileno"));
					System.out.println("CustomerAddress: "+res.getString("address"));
					
					System.out.println("you can  update or delete the customer details\n");
					System.out.println("Either enter 'update' or 'delete'");
					String ch=sc.next();
					
					if(ch.equals("update")) {
						updateCustomer(id,c);
							
						
						
					}
					else if(ch.equals("delete")) {
						if(deleteCustomer(id)) {
							System.out.println("Record Deleted Successsfuly...");
							
						}
						
						else {
							System.out.println("Record Not Deleted .......");
							
						}
					}
	
				
				
				
				
			}
			
			else {
				System.out.println("Id not exists first register your self");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
