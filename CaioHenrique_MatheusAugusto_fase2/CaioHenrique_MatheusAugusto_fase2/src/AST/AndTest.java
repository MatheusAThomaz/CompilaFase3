/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
/**
 *
 * @author matheus
 */
public class AndTest {
    
    private ArrayList<NotTest> notTest;
    
    public AndTest(ArrayList<NotTest> notTest)
    {
        this.notTest = notTest;
    }
    
    public void genC(PW pw, boolean flag){
        
        int i = 0;
        
        if(i < notTest.size())
            notTest.get(i).genC(pw,flag);
        
        i++;
        
        while(i < notTest.size())
        {
            pw.out.print(" && ");
            notTest.get(i).genC(pw, flag);
            i++;
        }
    }
    
}
