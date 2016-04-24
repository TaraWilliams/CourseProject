import java.util.Scanner;

class StudentQueue
   {
   private FirstLastList theList;
//--------------------------------------------------------------
   public StudentQueue()                // constructor
      { theList = new FirstLastList(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return theList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(String a,long j)        // insert, rear of queue
      { theList.insertLast(a, j); }
//--------------------------------------------------------------
   public long remove()              // remove, front of queue
      {  return theList.deleteFirst();  }
//--------------------------------------------------------------
   public void displayQueue()
      {
      System.out.print("Wait list first to last: ");
      theList.displayList();
      }
// -------------------------------------------------------------   
   public void displayFirst()
   {
	   System.out.println("{ Name: " + theList.getFirstName() + " | ID: " + theList.getFirstID() + " }");
   }
//--------------------------------------------------------------   
   public void deleteSpecific()
   {
		Scanner input = new Scanner(System.in);

		System.out.println("========================================================================");
  		System.out.println("What student do you want to remove? Enter the student's name as it appears in the list below:");
  		displayQueue();
  		System.out.println("========================================================================");
  		String searchName = input.nextLine().toUpperCase();		
		System.out.println("========================================================================");
  		System.out.println("The following student is being deleted from the wait list:");
  		theList.delete(searchName);
  		System.out.println("The waitlist is now as follows:");
  		theList.displayList();
  		System.out.println("========================================================================");

  		//input.close();

   }  
//--------------------------------------------------------------
   }  // end class LinkQueue