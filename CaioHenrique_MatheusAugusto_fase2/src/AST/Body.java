/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;

/**
 *
 * @author matheus
 */
public class Body {
    
    private Declaration declaration = null;
    private ArrayList<Stmt> statements;
    
    public Body(Declaration declaration, ArrayList<Stmt> statements)
    {
        this.declaration = declaration;
        this.statements = statements;
    }
    public void genC(PW pw){
        
        int  ssize = statements.size(), i = 0;
        
        if(declaration != null)
        declaration.genC( pw);
        
        
        i = 0;
        
        while(i < ssize)
        {
            statements.get(i).genC(pw);
            i++;
        }
        

        
        
    }
}
