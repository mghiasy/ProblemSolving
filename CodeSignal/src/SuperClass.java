

import java.util.Collections;

class SuperClass {
     public SuperClass() {
         System.out.println("Super");
     }
 }

 class SubClass extends SuperClass{
     public SubClass() {
         System.out.println("Sub");
     }

     public static void main(String[] args) {
         new SubClass();
     }

 }

