/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
/**
 *
 * @author matheus
 */
public class OrTest {
    
    private ArrayList<AndTest> andTest;
    
    public OrTest (ArrayList<AndTest> AndTest)
    {
        this.andTest = AndTest;
    }
    
    public void genC(PW pw, boolean flag){
        
        int i = 0;
        
        if(i < andTest.size())
            andTest.get(i).genC(pw, flag);
        
        i++;
        
        while(i < andTest.size())
        {
            pw.out.print(" || ");
            andTest.get(i).genC(pw, flag);
            i++;
        }
    }
    
}
