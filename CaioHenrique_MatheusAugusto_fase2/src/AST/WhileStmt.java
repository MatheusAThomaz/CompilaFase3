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
public class WhileStmt implements Stmt {
    
    private ArrayList<Stmt> stmt;
    private OrTest orTest;
    
    
    public WhileStmt(OrTest orTest, ArrayList<Stmt> stmt)
    {
        this.stmt = stmt;
        this.orTest = orTest;
    }
    
    public void genC(PW pw)
    {
        pw.print("\n");
        VariablesTable.flagcomp = true;
        int i = 0;
        pw.print("while(");
        
        orTest.genC(pw, false);
        
        VariablesTable.flagcomp = false;
        
        pw.out.print("){");
        pw.print("\n");
        while(i < stmt.size())
        {
            pw.add();
            stmt.get(i).genC(pw);
            i++;
            pw.sub();
        }
        
        pw.print("}");
    }
    
}
