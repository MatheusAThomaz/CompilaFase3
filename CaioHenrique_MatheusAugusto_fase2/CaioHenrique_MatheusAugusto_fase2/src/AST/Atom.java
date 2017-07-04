/*
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
public class Atom {
    
    private int type;
    private NumberFloat floatValue;
    private NumberInt intValue;
    private StringVar string;
    private Name name;
    private Vetor vetor;
    
    public Atom(int type, float value){
        this.type = type;
        this.floatValue = new NumberFloat(value);
    }
    
    public Atom(int type, int value){
        this.type = type;
        this.intValue = new NumberInt(value);
    }
    
    public Atom(int type){
        this.type = type;
    }
    
    public Atom(int type, String name){
        this.type = type;
        if(type == Symbol.VARSTRING)
            this.name = new Name(name);
        else
            this.string = new StringVar(name);
    }
    
    public Atom(int type, String name, String indexS){
        this.type = type;
        this.vetor = new Vetor(name,indexS);
    }
    
    public Atom(int type, String name, int indexI){
        this.type = type;
        this.vetor = new Vetor(name, indexI);
    }
    
    
    public void genC(PW pw, boolean flag){
        char c = 34;
        switch (type) {
            case Symbol.VETOR:
            if(VariablesTable.flag)
            {
                if(vetor.getFlag())
                    VariablesTable.string.add(vetor.getName() + "[" + vetor.getString() + "]");
                else
                    VariablesTable.string.add(vetor.getName() + "[" + vetor.getInt() + "]");

                    
            }
                vetor.genC(pw);
                break;
            case Symbol.NUMBERINT:
                if(VariablesTable.flag)
                    VariablesTable.string.add(Integer.toString(intValue.getInt()));
                intValue.genC(pw);
                break;
            case Symbol.NUMBERFLOAT:
                if(VariablesTable.flag)
                    VariablesTable.string.add(Float.toString(floatValue.getValue()));                
                floatValue.genC(pw);
                break;
            case Symbol.VARSTRING:
                if(VariablesTable.flag)
                    VariablesTable.string.add(name.getName());
                name.genC(pw);
                break;
            case Symbol.STRINGTEXT:
                if(flag){
                    pw.out.print(c+"");
                    string.genC(pw);
                    pw.out.print(c +"");
                }
                else
                    string.genC(pw);
                
                break;
            case Symbol.TRUE:
                if (VariablesTable.flag){ 
                    pw.out.print("%d");
                    VariablesTable.string.add("1");
                }
                else
                    pw.out.print("1");
                
                break;
            case Symbol.FALSE:
                   if (VariablesTable.flag){ 
                    pw.out.print("%d");
                    VariablesTable.string.add("0");
                }
                else
                    pw.out.print("0");
                break;
            default:
                break;
        }
    }
    
    
}
