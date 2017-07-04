/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import Principal.VariablesTable;
import java.util.*;
/**
 *
 * @author matheus
 */
public class Expr {
    
    private ArrayList<Term> term;
    private char []signal;
    
    public Expr (char[] signal, ArrayList<Term> term)
    {
        this.signal = signal;
        this.term = term;
    }
    
    public void genC(PW pw, boolean flag){
        
        int i = 0, y = 0;
        char c = 34;
        
        
        if(VariablesTable.flag)
        {
            
            VariablesTable.signal = signal;
            
            
            if(term.size() > 1)
                VariablesTable.last = true;
            else
                VariablesTable.last = false;
            
            if(term.size() >= 1)
            term.get(i).genC(pw, flag);
            i++;
            
            while(i < term.size())
            {
                VariablesTable.print = true;
                term.get(i).genC(pw, flag);
                i++;
                y++;  

            }
            
        }

        else{
            if(term.size() >= 1)
                term.get(i).genC(pw, flag);
            i++;

            while(i < term.size())
            {
                        pw.out.print(" " + signal[y] + " ");
                        term.get(i).genC(pw, flag);
                        i++;
                        y++;  

            }
        }
    }
    
    
}
