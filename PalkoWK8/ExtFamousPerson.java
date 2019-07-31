/********************
 * Class name:    ExtFamousPerson.java
 * Author:        Robert Palko
 * Date:          2019-07-27
 *
 * Assignment:    p.548, #24a-e
 * Description:   Extending the FamousPerson class to make it hashable.
 ********************/
 
import support.FamousPerson;
 
public class ExtFamousPerson extends FamousPerson{
   
   /*******
    * Constructor
    *
    * @param String first The person's first name
    * @param String last the person's last name
    * @param int yob The person's year of birth
    * @param String f A fact about the person
    *******/    
   public ExtFamousPerson(String first, String last, int yob, String f){
      super(first, last, yob, f);
   }
   
   /*******
    * The hashCode method generates a hash value for the FamousPerson class.
    *
    * @return An int that is the hashed value
    *******/    
   @Override
   public int hashCode(){
      return Math.abs((lastName.hashCode() * 3) + firstName.hashCode());
   }
}