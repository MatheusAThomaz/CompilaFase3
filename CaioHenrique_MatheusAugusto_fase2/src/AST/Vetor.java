/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Lexer.Symbol;

/**
 *
 * @author matheus
 */
public class Vetor implements Variables {
    
    
    private String name;
    private int indexI;
    private int type;
    private String indexS;
    private boolean flag;
    
    
    
    public Vetor(String name, String indexS)
    {
        this.name = name;
        this.indexS = indexS;
        this.type = Symbol.STRING;
        this.flag = true;
    }
    
    public Vetor(String name, int indexI)
    {
        this.name = name;
        this.indexI = indexI;
        this.type = Symbol.INT;
        this.flag = false;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
    public String getString(){
        return this.indexS;
    }
    
    public int getInt(){
        return this.indexI;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void genC(PW pw){
        
        if(type == Symbol.STRING)
            pw.out.print(name + "[" + indexS + "]");
        else
            pw.out.print(name + "[" + indexI + "]");
    }
}
