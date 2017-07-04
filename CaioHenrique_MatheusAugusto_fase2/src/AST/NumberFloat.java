/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import Principal.*;
/**
 *
 * @author matheus
 */
public class NumberFloat  implements NumberInterface{
    
    private float value;
    
    public NumberFloat(float value){
        this.value = value;
    }
    
    public float getValue(){
        return value;
    }
    
    public int getInt(){
        return 0;
    }
    
    public void genC(PW pw){
        
        if(!VariablesTable.flag)
             pw.out.print("" + value);
        else
            pw.out.print(" %f ");
        
    }
    
}
