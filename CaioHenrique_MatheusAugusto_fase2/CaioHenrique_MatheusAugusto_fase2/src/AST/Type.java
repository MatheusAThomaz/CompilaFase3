/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Lexer.Symbol;

/**
 *
 * @author maiks
 */
public class Type {
    int symb;
    
    public Type(int type){
        this.symb = type;
    }
    
    public void genC(PW pw){
        switch (this.symb){
            case Symbol.INT:
                pw.print("int ");
                break;
            case Symbol.FLOAT:
                pw.print("float ");
                break;
            case Symbol.BOOLEAN:
                pw.print("int ");
                break;
            case Symbol.STRING:
                pw.print("char ");
                break;
            
        }
        
        
    }
    
}
