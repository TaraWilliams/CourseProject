
class Student
   {
   public long stuID;					// data item
   public String stuName;
   public Student next;                 // next link in list
// -------------------------------------------------------------
   public Student(String name, long id)               // constructor
      {
	   stuName = name;
	   stuID = id;
      }
// -------------------------------------------------------------
   public void displayStudent()         // display this link
      { 
	   System.out.print("{ Name: " + stuName + " | ID: " + stuID + " }"); 
      }
 //--------------------------------------------------------------	
   public String getName(){
	return stuName;   
   }
//--------------------------------------------------------------	   
   public long getID(){
	return stuID;
   }

// -------------------------------------------------------------
   }  // end class Student
