import java.io.*;
public class  FileClass {
            FileClass(){System.out.println("File");}
      public static void main(String[] args) throws Exception {
          int y = 127;
switch (y) {
    default: System.out.print("129 ");    
    case 127: System.out.print("127 ");
    case 128: System.out.print("128 ");
    
}
            }
}

class IkmTest extends FileClass implements Serializable {
    private String name;
    IkmTest(String name){
        this.name = name;
        System.out.println("Test");
    }    
    public String getName(){return name;}
}