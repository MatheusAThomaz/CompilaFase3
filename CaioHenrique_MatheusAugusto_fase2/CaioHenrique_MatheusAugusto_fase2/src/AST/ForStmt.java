/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
/**
 *
 * @author matheus
 */
public class ForStmt implements Stmt {
    
    private Name name;
    private NumberInt number1;
    private NumberInt number2;
    private ArrayList<Stmt> stmt;
    
    public ForStmt(Name name, NumberInt number1, NumberInt number2, ArrayList<Stmt> stmt)
    {
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.stmt = stmt;
    }
    
    public void genC(PW pw)
    {
        int i = 0;
        
        pw.print("\n");
        pw.print("for(");
        name.genC(pw);
        pw.out.print(" = ");
        number1.genC(pw);
        pw.out.print(" ; ");
        
        name.genC(pw);
        if(number1.getInt() < number2.getInt())
            pw.out.print(" < ");
        else
            pw.out.print(" > ");
        number2.genC(pw);
        pw.out.print(" ; ");
        
        name.genC(pw);
        if(number1.getInt() < number2.getInt())
            pw.out.println("++){");
        else
            pw.out.println("--){");
        
        if(stmt != null)
            while(i < stmt.size())
            {
                pw.add();
                stmt.get(i).genC(pw);
                i++;
                pw.sub();
            }
        pw.print("\n");
        pw.println("}");
        
        
        
    }
}
