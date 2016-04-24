//The "doing stuff" class - adding, deleting, calling other methods, etc

class ClassDataApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      ClassDataArray arr;            // reference to array
      arr = new ClassDataArray(maxSize);  // create the array
                                     // insert courses
      arr.insert("CIS140", "Software Tools I", 18, 17);
      arr.insert("CIS151", "Web Site Development", 18, 9);
      arr.insert("CIS252", "C++", 18, 10);
      arr.insert("CIS254", "Data Structures", 18, 12);
      arr.insert("ENG244" ,"Sci-Fi Literature", 20, 20);
	  
	  System.out.println("========================================================================");
      System.out.println("Original Array");
      
      arr.displayA();                // display items

	 System.out.println("========================================================================");
	  
 	 arr.takeInput(arr);
 	
     }  // end main()
   }  // end class ClassDataApp

// Recommended for testing:
// 1) add student
// 2) to eng244 (is already full)
// 3) choose name (can enter whatever, caps not important)
// 4) choose ID number (can be any number)
// 5) repeat 1-4 a few times (maybe 3+)
// 6) remove (student)
// 7) eng244 (you have established a list already)
// 8) yes
// 9) enter any name, make sure it's spelled the same (not case sensitive)
// 10) exit