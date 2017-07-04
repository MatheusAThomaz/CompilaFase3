/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Lexer.Symbol;
import Principal.VariablesTable;

/**
 *
 * @author matheus
 */
public class ExprStmt implements Stmt{
    
    private Name name;
    private Vetor vector;
    private OrTest orTest;
    private ExprList exprList;
    private boolean flag;
    
    
    public ExprStmt(Name name, OrTest orTest){
        
        this.name = name;
        this.orTest = orTest;
        this.vector = null;
        this.exprList = null;
    }
    
    public ExprStmt(Name name, ExprList exprList, boolean flag)
    {
     this.exprList = exprList;
     this.name = name;
     this.flag = flag;
    }
    
    public ExprStmt(Name name, ExprList exprList){
        
        this.name = name;
        this.exprList = exprList;
        this.vector = null;
        this.orTest = null;
    }
    
    public ExprStmt(Vetor vetor, OrTest orTest){
        
        this.name = null;
        this.exprList = null;
        this.vector = vetor;
        this.orTest = orTest;
    }
    
    public ExprStmt(Vetor vetor, ExprList exprList){
        
        this.name = null;
        this.exprList = exprList;
        this.vector = vetor;
        this.orTest = null;
    }
    
    
    
    public void genC(PW pw){
        
        pw.print("");
            
        if(flag)
        {
            int x = VariablesTable.getTable(name.getName());
            if(x == Symbol.VETORCHAR)
            {
                pw.out.print("strcpy("+ vector.getName());
                pw.out.print(", ");
                if(exprList == null)
                    orTest.genC(pw, false);
                else
                    exprList.genC(pw, false, "");
                pw.out.print(")");
            }
            else{
                if(exprList == null)
                    orTest.genC(pw, false);
                else
                    exprList.genC(pw, true, name.getName());

        }
        }
        
        else {
            if(name == null)
        {
            int c = VariablesTable.getTable(vector.getName());
            if(c == Symbol.VETORCHAR)
            {
                pw.out.print("strcpy("+ vector.getName());
                pw.out.print(", ");
                if(exprList == null)
                    orTest.genC(pw, false);
                else
                    exprList.genC(pw, false, "");
                pw.out.print(")");
            }
            else{
                vector.genC(pw);
                pw.out.print(" = [");
                if(exprList == null)
                    orTest.genC(pw, false);
                else
                    exprList.genC(pw, false, "");

                pw.out.print("]");
            }
  
                
        }
        else{

               if(VariablesTable.getTable(name.getName()) == Symbol.STRING){
                 
                pw.out.print("strcpy(");
                name.genC(pw);
                pw.out.print(", ");
                if(exprList == null)
                    orTest.genC(pw, true);
                else
                    exprList.genC(pw, false, "");
                pw.out.print(")");
            }
            else{  
 
                name.genC(pw);
                pw.out.print(" = ");
                if(exprList == null)
                    orTest.genC(pw, false);
                else
                    exprList.genC(pw, false, "");
            }
        }
        }
        
        pw.out.println(";");
        
    }
}
