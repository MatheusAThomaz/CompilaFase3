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
public class Comparison {
    
    private Expr expr1;
    private CompOp compOp;
    private Expr expr2;
    
    public Comparison(Expr expr1){
        this.expr1 = expr1;
        this.compOp = null;
        this.expr2 = null;
    }
    
    public Comparison(Expr expr1, CompOp compOp, Expr expr2){
        this.expr1 = expr1;
        this.compOp = compOp;
        this.expr2 = expr2;       
    }
    
    public void genC(PW pw, boolean flag){
        
        if(VariablesTable.flagcomp)
        {
            VariablesTable.first = true;
   
            
            
            expr1.genC(pw, flag);
            VariablesTable.first = false;
            /*
            if(compOp.getType() == Symbol.EQUAL)
                pw.print(" == 0");
            else if(compOp.getType() == Symbol.LOWER)
                pw.print(" < 0");
            else 
                pw.print(" > 0");*/
            
            VariablesTable.first = false;
            if(compOp != null)
            {
                if(!VariablesTable.isString)
                    compOp.genC(pw);
                
                expr2.genC(pw, flag);
            }
            VariablesTable.isString = false;
        }
        else{
            
            expr1.genC(pw, flag);

            if(compOp != null)
            {
                compOp.genC(pw);
                expr2.genC(pw, flag);
            }

        }
        
    }
}
