
public class sort {
	public void exchange (int[] num) {
	     int i, j;
	     int temp;  //be sure that the temp variable is the same "type" as the array
	     for (i = 0; i < num.length - 1; i++)  {
	          for (j = i + 1; j < num.length; j++) {
	               if(num[i] > num[j])         //sorting into descending order
	               {
	                       temp = num[i];   //swapping
	                       num[i] = num[j];
	                       num[j] = temp; 
	                }           
	          }
	     }
	}	
	
	
	public void bubble(int[] num) {
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while (flag)
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for(j=0;  j < num.length -1;  j++)
	            {
	                   if (num[j] > num[j+1])   // change to > for ascending sort
	                   {
	                           temp = num[j];                //swap elements
	                           num[j] = num[j+1];
	                           num[j+1] = temp;
	                          flag = true;              //shows a swap occurred 
	                  }
	            }
	      }
	}
	
	public int[] selection (int [] num)
	{
	     int i, j, first;
	     int temp; 
	     for (i = 0; i < num.length; i++) 
	     {
	          first = 0;   //initialize to subscript of first element
	          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
	          {
	               if(num[j] > num[first]) // switch to "<" for descending order   
	                 first = j;
	          }
	          temp = num[first];   //swap smallest found with element in position i.
	          num[first] = num[i];
	          num[i] = temp; 
	      }
	     return num;
	}
	
	public void insertion(int [] num)
	{
	     int j, i;                     // the number of items sorted so far
	     int key;                // the item to be inserted

	     for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
	    {
	           key = num[j];
	           for(i = j - 1; (i >= 0) && (num[i] < key); i--)   // Smaller values are moving up
	          {
	                 num[i+1] = num[i];
	          }
	         num[i+1] = key;    // Put the key in its proper location
	     }
	}
	
	
}
