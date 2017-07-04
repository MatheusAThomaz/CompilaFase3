/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Principal.VariablesTable;

/**
 *
 * @author matheus
 */
public class StringVar{
    
    private String value;
    
    public String getValue(){
        return this.value;
    }
    
    public StringVar(String value){
        this.value = value;
    }
    
    public void genC(PW pw){
       
            pw.out.print(value);
    }
}
