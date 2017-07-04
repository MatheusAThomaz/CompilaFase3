/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;

/**
 *
 * @author matheus
 */
public class ExprList {
    
    private ArrayList <Expr> arrayExpr;
    
    public ExprList(ArrayList <Expr> arrayExpr){
        this.arrayExpr = arrayExpr;
    }
    
    public void genC(PW pw, boolean flag, String name){
        int i = 0;

        
        if(flag){
            pw.out.print(name+"["+i+"]" + " = ");
            arrayExpr.get(i).genC(pw, false);
            i++;
            
            while(i < arrayExpr.size()){
                pw.out.println(";");
                pw.print(name+"["+i+"]" + " = ");
                arrayExpr.get(i).genC(pw, false);
                i++;
            }
        }
        else
        {
                arrayExpr.get(i).genC(pw, false);
                i++;
            while (i < arrayExpr.size()){
                 pw.out.print(", ");
                arrayExpr.get(i).genC(pw, false);

                i++;           
            }  
        }
    }
    
}
