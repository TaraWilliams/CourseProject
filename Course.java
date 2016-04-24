import java.util.Scanner;

class Course
   {
	StudentQueue waitQueue = new StudentQueue();	
   private String courseCode;
   private String courseName;
   private int maxSeats;
   private int enrolledSeats;
//--------------------------------------------------------------
   public Course(String code, String name, int max, int enr)
      {                               // constructor
      courseCode = code;
      courseName = name;
      maxSeats = max;
	  enrolledSeats = enr;
      }
//--------------------------------------------------------------
   public void displayCourse()		// displays course info
      {
      System.out.print("Course Info: " + courseCode);
      System.out.print(": " + courseName);
	  System.out.print(" - Max Seats: " + maxSeats);
      System.out.println(", Currently Enrolled: " + enrolledSeats);
      }
//--------------------------------------------------------------
   public int getOpenSeats()           // get remaining seats
      { return (maxSeats-enrolledSeats); }  

//--------------------------------------------------------------
	public void enrollStudent() 		// adds one to enrolled, prints updated course info
	{
		if(maxSeats==enrolledSeats)
		{
			 Scanner input = new Scanner(System.in);
			  System.out.println("========================================================================");
			  System.out.println("This course is full. You must add the student to the waitlist. Please enter the student's name.");
			  System.out.println("You may enter First and/or Last name in any text format you wish.");
			  System.out.println("========================================================================");
			  String name = input.nextLine().toUpperCase();
			  System.out.println("========================================================================");
			  System.out.println("Now please enter the student's ID number.");
			  System.out.println("You may enter the ID number in any numerical format you wish.");
			  System.out.println("========================================================================");
			  Long id = input.nextLong();
			  
	// NEW WAITLIST
			  
			  waitQueue.insert(name, id);
			  {
			  System.out.println("========================================================================");
			  System.out.println("The following student is now being added to the end of the wait list:");
			  System.out.println("{ Name: " + name + " | " + "ID: " + id + " }");
			  System.out.println("========================================================================");
			  }
			System.out.println("========================================================================");
			System.out.println("The following is the next student on this wait list:");
			waitQueue.displayFirst();
			System.out.println("========================================================================");
				
			//input.close();

		}
		else
		{
		enrolledSeats++;
		displayCourse();
		}
	}
//--------------------------------------------------------------
	
	public void removeStudent()		
	{
		   Scanner input = new Scanner(System.in);

		System.out.println("========================================================================");
		System.out.println("Do you want to remove a specific student from the waitlist? Enter 'yes' or 'no'.");
		System.out.println("========================================================================");
		  	if(input.nextLine().toUpperCase().equals("YES"))
		  	{
		  		waitQueue.deleteSpecific();
		  	}
		  	else
		  	{
				if(enrolledSeats==maxSeats)
					{
					System.out.println("========================================================================");
					System.out.println("The following student will now be added to the course and removed from the waitlist:");
					waitQueue.displayFirst();
					System.out.println("========================================================================");
					waitQueue.remove();
					}
				else
					enrolledSeats--;
				
				displayCourse();
		  	}
		
		  //input.close();	
	
	}
//--------------------------------------------------------------
	public String getCode()				// get name of course
	{ return courseCode; }

//--------------------------------------------------------------


    }  // end class Course
