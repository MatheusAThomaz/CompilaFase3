/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package AST;

/**
 *
 * @author matheus
 */
public class Program{
    
    private Body body;
    private String name;
    
    public Program(Body body, String name)
    {
        this.body = body;
        this.name = name;
    }
 
    public void genC(PW pw){
        pw.add();
        
        pw.out.println("#include <stdio.h>");
        pw.out.println("#include <string.h>");
        pw.out.println("#include <math.h>");
        pw.out.println("");
        pw.out.println("int main(){");
        
        body.genC(pw);
        pw.print("\n");
        pw.println("return 0;");
        pw.out.println("}");
        pw.sub();      
    }
    
    
    
}
