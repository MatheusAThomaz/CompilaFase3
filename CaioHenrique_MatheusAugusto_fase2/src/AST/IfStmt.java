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
public class IfStmt implements Stmt {
    
    private OrTest orTest;
    private ArrayList<Stmt> ifStmt;
    private ArrayList<Stmt> elseStmt = null;
    
    public IfStmt(OrTest orTest, ArrayList<Stmt> ifStmt){
        
        this.orTest = orTest;
        this.ifStmt = ifStmt;
        this.elseStmt = null;
        
    }
    
    public IfStmt(OrTest orTest, ArrayList<Stmt> ifStmt, ArrayList<Stmt> elseStmt){
        
        this.orTest = orTest;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
        
    }
    
    public void genC(PW pw){
        pw.print("\n");
        int i = 0;
        VariablesTable.flagcomp = true;
        pw.print("if(");
        
        orTest.genC(pw, false);

        
        
        VariablesTable.flagcomp = false;
        pw.out.println("){");
        
        while(i < ifStmt.size())
        {
            pw.add();
            ifStmt.get(i).genC(pw);
            i++;
            pw.sub();
        }
        
        i = 0;
        pw.print("}");
        
        if(elseStmt != null)
        {            
            pw.print("\n");
            pw.println("else {");
            while(i < elseStmt.size())
            {
                pw.add();
                elseStmt.get(i).genC(pw);
                i++;
                pw.sub();
            }           
            pw.println("}");
            
        }
        
        
    }
    
}
