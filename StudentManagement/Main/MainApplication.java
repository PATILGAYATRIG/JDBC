package com.myapp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.myapp.bean.Student;
import com.myapp.dao.StudentDao;

public class MainApplication {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		//User input
		Scanner sc = new Scanner(System.in)) {
			StudentDao rd=new StudentDao();
			do
			{
				System.out.println("1.Add new record. ");
				System.out.println("2.Update record. ");
				System.out.println("3.Delete record. ");
				System.out.println("4.Fetch record by roll_no. ");
			
				System.out.println("5.Fetch all record ");
				System.out.println("6.Exit ");
				System.out.println("Enter your choice:");
				
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:
						System.out.println("Enter student roll_no,name and percentage");
						int r=sc.nextInt();
						String n=sc.next();
						float p=sc.nextFloat();
						Student s=new Student(r,n,p);
						int k=rd.saveDate(s);
						System.out.println("Record Inserted....");
						break;
					case 2:
						System.out.println("Enter student roll_no and update percentage");
						 r=sc.nextInt();
						 p=sc.nextFloat();
						
						 k=rd.updateRecord(r, p);
						System.out.println("Record Updated....");
						break;
					case 3:
						System.out.println("Enter student roll_no");
						 r=sc.nextInt();
						k=rd.deleteRecord(r);
						System.out.println("Record Deleted....");
						break;
					case 4:
						System.out.println("Enter student roll_no");
						 r=sc.nextInt();
					    Student	kt=rd.fetchReocordByRno(r);
						System.out.println(kt);
						break;
					case 5:
						List<Student> list=rd.fechAllData();
						Iterator<Student> itr=list.iterator();
						while(itr.hasNext())
						{
							System.out.println(itr.next());
						}
						break;
					case 6:
						  System.out.println("Exited the application...");
						  System.exit(0);
						  
						break;
					default :
						
						System.out.println("Wrong choice");
					
				}
			}while(true);
		}
		
	}

}
