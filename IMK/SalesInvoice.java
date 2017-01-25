
public class SalesInvoice extends Invoice {
   public static String formatId(String oldId) {
      return oldId + "_SalesInvoice";
   }

public static void main (String args []) {
    

Invoice invoice = new SalesInvoice();
System.out.println(invoice.formatId("1234"));

 
	Invoice invoice = new Invoice();
System.out.println((SalesInvoice)Invoice.formatId("1234"));

	SalesInvoice invoice = new SalesInvoice();
System.out.println(Invoice.formatId("1234"));

	Invoice invoice = new Invoice();
System.out.println(invoice.formatId("1234"));

 
	SalesInvoice invoice = new SalesInvoice();
System.out.println(invoice.formatId("1234"));


    }
}


	