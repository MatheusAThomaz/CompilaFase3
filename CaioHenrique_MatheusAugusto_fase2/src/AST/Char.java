/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import Principal.*;

/**
 *
 * @author maiks
 */
public class Char{
    
    private char ch;
    
    public void Char(char ch){
        
        this.ch = ch;
        
    }
    
    public void genC(PW pw){
        
        if(!VariablesTable.flag)
            pw.out.print("" + ch);
        else
        {
            pw.out.print("%c");
        }
        
    }
    
}
