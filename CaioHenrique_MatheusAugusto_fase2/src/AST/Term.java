/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
/**
 *
 * @author matheus
 */
public class Term {
    
    private ArrayList<Factor> factor;
    private char []signal;
    
    public Term(char[] signal, ArrayList<Factor> factor)
    {
        this.signal = signal;
        this.factor = factor;
    }
    
    public void genC(PW pw, boolean flag){
        
        int i = 0, y = 0;
        
        if(factor.size() >= 1)
            factor.get(i).genC(pw, flag);
        i++;
        
        while(i < factor.size())
        {
            pw.out.print(" " + signal[y] + " ");
            
            factor.get(i).genC(pw, flag);
            i++;
            y++;
        }
    }
    
    
}
