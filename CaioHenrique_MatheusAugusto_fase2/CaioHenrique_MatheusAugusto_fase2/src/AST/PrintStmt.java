/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;
import Principal.*;
/**
 *
 * @author matheus
 */
public class PrintStmt implements Stmt {
    
    
    private ArrayList<OrTest> orTest;
    boolean flag = false;
 
    public PrintStmt (ArrayList<OrTest> orTest){
        this.orTest = orTest;
    }
    
    public void genC(PW pw)
    {
        VariablesTable.flag = true;
        char c = 34;
        pw.print("printf(" + c);
        int i = 0;
        
        orTest.get(i).genC(pw, flag);
        
        i++;
        
        while(i < orTest.size())
        {
            VariablesTable.print = false;
            VariablesTable.printed = false;
            orTest.get(i).genC(pw, flag);
            i++;
        }
        
        
        pw.out.print(c + "");
        
        if(!VariablesTable.string.isEmpty())
        {
            int j = 0, x = 0;
            if(!VariablesTable.print){
                while(j < VariablesTable.string.size())
                {
                    pw.out.print(",");
                    pw.out.print(" " + VariablesTable.string.get(j) + " ");
                    j++;
                }
            }
            else{
                pw.out.print("," + VariablesTable.string.get(j) + " ");
                j++;
                while(j < VariablesTable.string.size())
                {
                    pw.out.print(VariablesTable.signal[x] + "");
                    pw.out.print(" " + VariablesTable.string.get(j) + " ");
                    j++;
                    x++;    
                }
            }
        }
        
        pw.out.println(");");
        
        VariablesTable.flag = false;
        VariablesTable.string.clear();
    }
}
