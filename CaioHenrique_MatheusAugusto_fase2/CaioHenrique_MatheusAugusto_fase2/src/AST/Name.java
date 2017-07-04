/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

import Lexer.Symbol;
import Principal.VariablesTable;

/**
 *
 * @author matheus
 */
public class Name implements Variables{
    
    private String value;
    
    public Name(String value){
        this.value = value;
    }
    
    public String getName(){
        return this.value;
    }
    
    public void genC(PW pw)
    {
        if(VariablesTable.flag)
        {
            int tipo = VariablesTable.getTable(value);
            
            if(tipo == Symbol.INT || tipo == Symbol.VETORINT)
            {            
                
            if(VariablesTable.print && !VariablesTable.printed)
            {               
                pw.out.print(" %d ");
                VariablesTable.printed = true;
            }
            else if(!VariablesTable.print && !VariablesTable.last)
                pw.out.print(" %d ");
            }
            else if(tipo == Symbol.FLOAT || tipo == Symbol.VETORFLOAT)
                pw.out.print(" %f ");
            else if(tipo == Symbol.CHAR)
                pw.out.print(" %c ");
            else if(tipo == Symbol.STRING)
                pw.out.print(" %s ");       
        }
        
        else if(VariablesTable.flagcomp)
        {
            
            int tipo = VariablesTable.getTable(value);
            
            if(tipo == Symbol.STRING)
            {
                VariablesTable.isString = true;
                if(VariablesTable.first)
                {
                    pw.out.print("strcmp(");
                     pw.out.print(value + ",");
                }
                else{
                        pw.out.print(value+ ") == 0");
                }
                
            }
            else
                pw.out.print(value);
        }
        else
            pw.out.print(value);
        
    }
}
