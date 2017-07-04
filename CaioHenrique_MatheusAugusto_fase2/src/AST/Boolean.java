/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

/**
 *
 * @author maiks
 */
public class Boolean{
     
    private boolean bool;
    
    public void Boolean(boolean bool){
        
        this.bool = bool;
        
    }
    
    public void genC(PW pw){
        
        if(bool)
            pw.out.print("1");
        else
            pw.out.print("0");     
    }
}
