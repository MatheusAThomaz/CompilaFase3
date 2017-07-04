/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

/**
 *
 * @author matheus
 */
public class NotTest {
    
    private Comparison comparison;
    private boolean existe_not;
    
    public NotTest(Comparison comparison, boolean not){
        this.existe_not = not;
        this.comparison = comparison;
    }
    
    public void genC(PW pw, boolean flag){
        
        if(existe_not)
            pw.out.print(" !");
        
        comparison.genC(pw, flag);
        
    }
}
