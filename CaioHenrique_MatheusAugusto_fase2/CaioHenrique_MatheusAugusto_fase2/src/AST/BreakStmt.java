/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

/**
 *
 * @author matheus
 */
public class BreakStmt implements Stmt {
    
    public void genC(PW pw)
    {
        pw.println("break;");
    }
}
