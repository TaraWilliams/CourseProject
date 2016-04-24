////////////////////////////////////////////////////////////////
class FirstLastList
   {
   private Student first;               // ref to first item
   private Student last;                // ref to last item
// -------------------------------------------------------------
   public FirstLastList()            // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { 
	   return first==null; 
	  }

// -------------------------------------------------------------
   public void insertLast(String name, long id) // insert at end of list
      {
      Student newStudent = new Student(name, id);   // make new link
      if( isEmpty() )                // if empty list,
         first = newStudent;            // first --> newLink
      else
         last.next = newStudent;        // old last --> newLink
      last = newStudent;                // newLink <-- last
      }
// -------------------------------------------------------------
   public long deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      long temp = first.stuID;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public void displayList()
      {
      Student current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayStudent();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
public String find(String key)	// find link with given key
{								// (assumes non-empty list)
	Student current = first;	// start at ‘first’
	while(current.getName().compareTo(key) != 0)	// while no match,
	{
		if(current.next == null)	// if end of list,
			return null;	// didn’t find it
		else		// not end of list,
			current = current.next;	// go to next link
	}
return current.getName();	// found it

}   
//-------------------------------------------------------------
public void delete(String key) //delete link with given key
{								//(assumes non-empty list)
Student current = first; //search for link
Student previous = first;
	while(current.getName().compareTo(key) != 0)
	{
	if(current.next == null)
		return; 	//didnt find it
	else
	{
		previous = current;	//go to next link
		current = current.next;
	}
	} // found it
	if(current.getName().compareTo(first.getName()) == 0) // if first link,
		first = first.next; // change first
	else // otherwise,
		previous.next = current.next; //bypass it
	current.displayStudent();
}
// -------------------------------------------------------------   
   public String getFirstName()
   {
	   return first.getName();
   }
// -------------------------------------------------------------   
   public long getFirstID()
   {
	   return first.getID();
   }
// -------------------------------------------------------------
   public String getLastName()
   {
	   return last.getName();
   }
// -------------------------------------------------------------   
   public long getLastID()
   {
	   return last.getID();
   }   
// -------------------------------------------------------------
   }  // end class FirstLastList