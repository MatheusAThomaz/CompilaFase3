/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
/**
 *
 * @author matheus
 */
public class Factor {
    
    private ArrayList<Factor> factor;
    private Atom atom;
    private char signal;
    
    public Factor(char signal, Atom atom, ArrayList<Factor> factor){
        this.signal = signal;
        this.factor = factor;
        this.atom = atom;
    }
    
    public void genC(PW pw, boolean flag){
       int i = 0;
        if(signal == '+')
            pw.out.print(" + ");
        else if(signal == '-')
            pw.out.print(" - ");
        
        if (factor.size() > 0){ pw.out.print("pow(");
            atom.genC(pw, flag);
            pw.out.print(", ");
        }
        else atom.genC(pw, flag);
        
        while(i < factor.size())
        {          
            factor.get(i).genC(pw, flag);
            pw.out.print(")");
            i++;
        }
        
    }
    
}
