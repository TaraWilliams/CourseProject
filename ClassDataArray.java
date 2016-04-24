import java.util.Scanner;

//The "holding stuff" class - Methods to be called

class ClassDataArray
   {
   private Course[] a;               // reference to array
   private int nElems;               // number of data items

   public ClassDataArray(int max)    // constructor
      {
      a = new Course[max];               // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public Course find(String searchName)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if( a[j].getCode().equals(searchName) )  // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return null;                    // yes, can't find it
      else
         return a[j];                    // no, found it
      }  // end find()
//--------------------------------------------------------------         
   public void insert(String code, String name, int max, int enr)  // put Course into array
      {
      a[nElems] = new Course(code, name, max, enr);
      nElems++;  // increment size
      
      //auto insertion Sort
      int in, out;

      for(out=1; out<nElems; out++)
         {
         Course temp = a[out];       // out is dividing line
         in = out;                   // start shifting at out

         while(in>0 &&               // until smaller one found,
               a[in-1].getCode().compareTo(temp.getCode())>0)
            {
            a[in] = a[in-1];         // shift item to the right
            --in;                    // go left one position
            } //end while
         a[in] = temp;               
         } //end for
      } // end insert()
   
//--------------------------------------------------------------
   public boolean delete(String searchName)
      {                              // delete Course from array
      int j;
      for(j=0; j<nElems; j++)            // look for it
         if( a[j].getCode().equals(searchName) )
            break;
      if(j==nElems)                      // can't find it
         return false;
      else                               // found it
         {
         for(int k=j; k<nElems; k++)     // shift down
            a[k] = a[k+1];
         nElems--;                       // decrement size
         return true;
         }
      }  // end delete()
//--------------------------------------------------------------
   public void displayA()            // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         a[j].displayCourse();          // display it
      } //end displayA()
//--------------------------------------------------------------
   public void takeInput(ClassDataArray theArray){
		
	   Scanner input = new Scanner(System.in);
		  System.out.println("========================================================================");
		  System.out.println("Your Options: (1)ADD COURSE or (2)DELETE COURSE or (3)ADD STUDENT or (4)REMOVE STUDENT or (5)DISPLAY ALL COURSES or (6)EXIT?");
		  System.out.println("Enter only: COURSE or DELETE or ADD or REMOVE or DISPLAY or EXIT");
		  System.out.println("Note: No answers in this program are case-sensitive");
		  System.out.println("========================================================================");
		  String toDo = input.nextLine().toUpperCase();
		
		  	  
			  if(toDo.equals("COURSE"))
			  {
			  System.out.println("========================================================================"); 
			  System.out.println("Enter course code in format AAA###");
			  System.out.println("========================================================================");
			  String newCode = input.nextLine().toUpperCase();
			  System.out.println("========================================================================"); 
			  System.out.println("Enter course name");
			  System.out.println("========================================================================");
		      String newName = input.nextLine();
		      System.out.println("========================================================================"); 
			  System.out.println("Enter maximum enrollment number");
			  System.out.println("========================================================================");
			  int newMax = input.nextInt();
			  System.out.println("========================================================================"); 
			  System.out.println("Enter current enrollment number");
			  System.out.println("========================================================================");
			  int newCur = input.nextInt();
			  
			  
			  theArray.insert(newCode, newName, newMax, newCur);  
		      theArray.takeInput(theArray);
			  } //end course
		  
			  else if(toDo.equals("DELETE"))
			  {
			  System.out.println("========================================================================");
			  System.out.println("What course do you want to delete? Enter in AAA### form.");
			  System.out.println("========================================================================");
			  String theCourse = input.nextLine().toUpperCase();
			  theArray.delete(theCourse);
		      theArray.takeInput(theArray);
			  } //end delete
			  
			  
			  else if(toDo.equals("ADD"))
			  {
			  System.out.println("========================================================================");
			  System.out.println("What course do you want to add a student to? Enter in AAA### form.");
			  System.out.println("========================================================================");
			  String theCourse = input.nextLine().toUpperCase();
			  theArray.find(theCourse).enrollStudent();
		      theArray.takeInput(theArray);
			  } //end add
		  
			  else if(toDo.equals("REMOVE"))
			  {
				  
		  		System.out.println("========================================================================");
		  		System.out.println("What course do you want to remove a student from? Enter in AAA### form.");
		  		System.out.println("========================================================================");
		  		String theCourse = input.nextLine().toUpperCase();
		  		theArray.find(theCourse).removeStudent();
			
		      theArray.takeInput(theArray);
			  } //end delete
			  
			  else if(toDo.equals("DISPLAY"))
			  {
				  System.out.println("========================================================================");
				  System.out.println("The course array will be displayed.");
				  System.out.println("========================================================================");
				  theArray.displayA();
			      theArray.takeInput(theArray);

			  } // end display
			  
			  else if(toDo.equals("EXIT"))
			  {
				  System.out.println("========================================================================");
				  System.out.println("Thank you! Goodbye forever!");
				  System.out.println("========================================================================");		  
			  } // end exit	
			  
			  else
			  {
				  System.out.println("========================================================================");
				  System.out.println("Sorry, that was not an option. Please enter a valid request.");
				  System.out.println("========================================================================");
				  theArray.takeInput(theArray);
			  } // end catch for others
	//input.close();

}	// end takeInput()   
//--------------------------------------------------------------  
   }  // end class ClassDataArray
