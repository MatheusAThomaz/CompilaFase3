/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Lexer.Symbol;

/**
 *
 * @author matheus
 */
public class CompOp {
    
    private int type;
    
    public CompOp (int type)
    {
        this.type = type;
    }
    
    public int getType(){
        return this.type;
    }
    
    public void genC (PW pw)
    {
        switch (type) {
            case Symbol.LOWER:
                pw.out.print(" < ");
                break;
            case Symbol.LOWEREQUAL:
                pw.out.print(" <= ");
                break;
            case Symbol.UPPER:
                pw.out.print(" > ");
                break;
            case Symbol.UPPEREQUAL:
                pw.out.print(" >= ");
                break;
            case Symbol.DIFERENT:
                pw.out.print(" != ");
                break;
            case Symbol.EQUAL:
                pw.out.print(" == ");
                break;
            default:
                break;
        }
    }
}
