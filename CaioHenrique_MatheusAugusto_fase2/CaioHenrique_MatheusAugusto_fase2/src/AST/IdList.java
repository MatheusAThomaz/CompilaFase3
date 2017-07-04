/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import Lexer.Symbol;
import Principal.VariablesTable;
import java.util.*;

/**
 *
 * @author maiks
 */
public class IdList {
    
    private ArrayList<Variables> variables;
    
    public IdList(ArrayList<Variables> variables)
    {
        this.variables = variables;
    }
    
    public void genC(PW pw){
        
        int i = 0;
        
        variables.get(i).genC(pw);

        int c;
        
        c = VariablesTable.getTable(variables.get(i).getName());
        if(c == Symbol.STRING || c == Symbol.VETORCHAR)
            pw.out.print("[500]");

        
        i++;
        while(i < variables.size())
        {
            pw.out.print(", ");
            variables.get(i).genC(pw);
            
            c = VariablesTable.getTable(variables.get(i).getName());
            if(c == Symbol.STRING || c == Symbol.VETORCHAR)
                pw.out.print("[500]");
            
            i++;
        }
        
    }
    
    
}
