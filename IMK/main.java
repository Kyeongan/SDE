class main{

	// public boolean isLeapYear(int year) {                   
	// 	Calendar cal = Calendar.getInstance();                
	// 	cal.set(Calendar.YEAR, year);                         
	// 	int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	// 	return (days > 365);                                  
	// } 

	public boolean isLeapYear(int year) {              
 Calendar cal = Calendar.getInstance();           
 cal.set(year, Calendar.FEBRUARY, 1);             
 int days = cal.getLastDay(Calendar.DAY_OF_MONTH);
 return (days == 29);                             
}   

    public static void main (String args []) {
System.out.println("main 1");
	System.out.println(isLeapYear(2017));

// public boolean isLeapYear(int year) {   
//  GregorianCalendar gc = new GregorianCalendar();
//  return gc.isLeapYear(year);                  
// }                                       





// public boolean isLeapYear(int year) {    
// Calendar cal = Calendar.getInstance();  
//  return cal.isLeapYear(year);            
// }                                        

// public boolean isLeapYear(int year) {              
//  Calendar cal = Calendar.getInstance();           
//  cal.set(year, 1, 1);                             
//  int days = cal.getMaximum(Calendar.DAY_OF_MONTH);
//  return (days == 29);                             
// }                                                  

                                               

	        

	

}


}