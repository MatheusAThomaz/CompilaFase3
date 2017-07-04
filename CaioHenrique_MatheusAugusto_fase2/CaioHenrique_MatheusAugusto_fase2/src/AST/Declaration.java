/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;
import java.util.*;

/**
 *
 * @author matheus
 */
public class Declaration {
    
    private ArrayList<Type> type;
    private ArrayList<IdList> idList;
    
    public Declaration(ArrayList<Type> type, ArrayList<IdList> idList){
        
        this.type = type;
        this.idList = idList;
        
    }
    
    
    public void genC(PW pw){
           int i = 0;
           
           while(i < type.size())
           {
               type.get(i).genC(pw);
               idList.get(i).genC(pw);
               pw.out.println(";");
               i++;
           }
    }
}
