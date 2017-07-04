/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import Principal.*;

/**
 *
 * @author matheus
 */
public class NumberInt implements NumberInterface {
    
    private int value;
    
    public NumberInt(int value){
        this.value = value;
    }
    
    public int getInt(){
        return this.value;
    }
    
    public float getValue(){
        //error;
        return 0;
    }
    
    public void genC(PW pw){
        if(!VariablesTable.flag)
            pw.out.print("" + value);
        else
        {
            if(VariablesTable.print && !VariablesTable.printed)
            {
                pw.out.print(" %d ");
                VariablesTable.printed = true;
            }     
        }
    }
    
}
