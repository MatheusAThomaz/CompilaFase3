/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package Lexer;
import java.util.*;


/**
 *
 * @author matheus
 */
public class Lexer {
    
    public int token;
    private int tokenPos;
    private int numberInt;
    private int lineNumber;
    private int lastTokenPos;
    private int beforeLastTokenPos;
    private char input[];
    private float numberFloat;
    private static final int MaxValueInteger = 32768;
    private boolean flagOutLimit = false;
    
    private String StringValue;
    
    //Vai inserir o negocio do error aqui
    public Lexer(char input[])
    {
        this.input = input;
        
        input[input.length - 1] = '\0';
        
        lineNumber = 1;
        tokenPos = 0;
        lastTokenPos = 0;
        beforeLastTokenPos = 0;
        
        // this.error = error;
    }
    
    static public Hashtable keywordsTable;
    
    static{
        keywordsTable = new Hashtable();
        
        keywordsTable.put("and", new Integer(Symbol.AND));
        keywordsTable.put("boolean", new Integer(Symbol.BOOLEAN));
        keywordsTable.put("break", new Integer(Symbol.BREAK));
        keywordsTable.put("elif", new Integer(Symbol.ELIF));
        keywordsTable.put("else", new Integer(Symbol.ELSE));
        keywordsTable.put("end", new Integer(Symbol.END));
        keywordsTable.put("False", new Integer(Symbol.FALSE));
        keywordsTable.put("float", new Integer(Symbol.FLOAT));
        keywordsTable.put("for", new Integer(Symbol.FOR));
        keywordsTable.put("if", new Integer(Symbol.IF));
        keywordsTable.put("in", new Integer(Symbol.IN));
        keywordsTable.put("inrange", new Integer(Symbol.INRANGE));
        keywordsTable.put("int", new Integer(Symbol.INT));
        keywordsTable.put("not", new Integer(Symbol.NOT));
        keywordsTable.put("notin", new Integer(Symbol.NOTIN));
        keywordsTable.put("or", new Integer(Symbol.OR));
        keywordsTable.put("print", new Integer(Symbol.PRINT));
        keywordsTable.put("program", new Integer(Symbol.PROGRAM));
        keywordsTable.put("string", new Integer(Symbol.STRING));
        keywordsTable.put("True", new Integer(Symbol.TRUE));
        keywordsTable.put("while", new Integer(Symbol.WHILE));
                
    }
    
    public void nextToken(){
        char c;
        boolean flag = false;
        
        while((c = input[tokenPos]) == ' ' || c == '\r'
                || c == '\t' || c == '\n')
        {
            
            if(c == '\n')
                lineNumber++;
            tokenPos++;
            
        }
        //System.out.println(input[tokenPos]);
        if(c == '\0')
            token = Symbol.EOF;
        
        else{
            
            if(c == '#')
            {
                while(input[tokenPos] != '\n' && input[tokenPos] != '\0')
                {
                    tokenPos++;
                }
                nextToken();
            }
            
            else{
                if (Character.isLetter(c)){
                    StringBuffer ident = new StringBuffer();
                    ident.append(input[tokenPos]);
                    tokenPos++; 
                    while (Character.isLetter(input[tokenPos]) || Character.isDigit(input[tokenPos])){
                        ident.append(input[tokenPos]);
                        tokenPos++;
                        if (!Character.isDigit(input[tokenPos]) 
                            && !Character.isLetter(input[tokenPos]) && input[tokenPos] != ';' 
                            && input[tokenPos] != ','  && input[tokenPos] != ' ' 
                            && input[tokenPos] != ':'  && input[tokenPos] != '\n'
                            && input[tokenPos] != '\r' && input[tokenPos] != '\t'
                            && input[tokenPos] != ','  && input[tokenPos]  != ';'
                            && input[tokenPos] != ')'  && input[tokenPos]  != ']'
                            && input[tokenPos] != '}'  && input[tokenPos]  != 39
                            && input[tokenPos] != ' ' && input[tokenPos]  != '\0'
                            && input[tokenPos] != '{' && input[tokenPos] != '('
                            && input[tokenPos] != '['){
                            System.out.println(input[tokenPos]);
                            flag = true;
                        }
                    }
                    
                    StringValue = ident.toString();
                    
                    Object value = keywordsTable.get(StringValue);
                    if (value == null){
                        token = Symbol.VARSTRING;
                    }
                    else{
                        token = ((Integer) value).intValue();
                    }
                    
                    if (flag){
                        token = Symbol.ERRORSIMBOLO;
                    }
                }
                
                else if (Character.isDigit(c)){
              
                        
                    StringBuffer number = new StringBuffer();
                    
                    while (Character.isDigit(input[tokenPos])){
                        number.append(input[tokenPos]);
                        tokenPos++;
                    }
                    
                    if(number.length() > 5)
                    {
                        token = Symbol.ERROROUTOFLIMITS;
                        flagOutLimit = true;
                    }
                    else
                        numberInt = Integer.valueOf(number.toString()).intValue(); 
                    
                     if ( numberInt >= MaxValueInteger )
                     {
                         token = Symbol.ERROROUTOFLIMITS;
                         flagOutLimit = true;
                     }
                    
                    if (input[tokenPos] == '.'){
                        number.append(input[tokenPos]);
                        tokenPos++;
                        while (Character.isDigit(input[tokenPos])){
                            number.append(input[tokenPos]);
                            tokenPos++;
                        }
                                               
                        numberFloat = Float.valueOf(number.toString()).floatValue();
                        
                        if (input[tokenPos] == ' ' || input[tokenPos] == '>'
                            || input[tokenPos]  == '<' || input[tokenPos]  == '='
                            || input[tokenPos]  == ',' || input[tokenPos]  == ';'
                            || input[tokenPos]  == ')' || input[tokenPos]  == ']'
                            || input[tokenPos]  == '}' || input[tokenPos]  == 39
                            || input[tokenPos]  == '^' || input[tokenPos]  == '+'
                            || input[tokenPos]  == '-' || input[tokenPos]  == '*'
                            || input[tokenPos]  == '/'){
                            token = Symbol.NUMBERFLOAT;
                        }
                        else{
                            token = Symbol.ERRORNUMBERINVALID;
                        }
                    }
                    
                    else if ((input[tokenPos] == ' ' || input[tokenPos] == '>'
                            || input[tokenPos]  == '<' || input[tokenPos]  == '='
                            || input[tokenPos]  == ',' || input[tokenPos]  == ';'
                            || input[tokenPos]  == ')' || input[tokenPos]  == ']'
                            || input[tokenPos]  == '}' || input[tokenPos]  == 39
                            || input[tokenPos]  == '^' || input[tokenPos]  == '+'
                            || input[tokenPos]  == '-' || input[tokenPos]  == '*'
                            || input[tokenPos]  == '/') && !flagOutLimit){
                        token = Symbol.NUMBERINT;
                    }
                    
                    else if (!flagOutLimit){
                        token = Symbol.ERRORNUMBERINVALID;
                    }
                }
                
                else if (c == 39){
                    StringBuffer ident = new StringBuffer();
                    tokenPos++; 
                    while (input[tokenPos] != 39 && input[tokenPos] != '\0'){
                        
                        ident.append(input[tokenPos]);
                        tokenPos++;
                    }
                    
                    if(input[tokenPos] == '\0')
                        token = Symbol.ERRORASPAS;
                    else{ 
                        tokenPos++;
                    
                        StringValue = ident.toString();
                        token = Symbol.STRINGTEXT;
                    }
                }
                
                else{
                    tokenPos++;
                    switch(c){
                        case '+':
                            token = Symbol.PLUS;
                            break;
                        case '-':
                            token = Symbol.MINUS;
                            break;
                        case '*':
                            token = Symbol.MULT;
                            break;
                        case '/':
                            token = Symbol.DIV;
                            break;
                        case '<':
                            if (input[tokenPos] == '='){
                                tokenPos++;
                                token = Symbol.LOWEREQUAL;
                            }
                            else if (input[tokenPos] == '>'){
                                tokenPos++;
                                token = Symbol.DIFERENT;
                            }
                            else{                               
                                token = Symbol.LOWER;
                            }
                            break;
                        case '>':
                            if (input[tokenPos] == '='){
                                tokenPos++;
                                token = Symbol.UPPEREQUAL;
                            }
                            else{
                                token = Symbol.UPPER;
                            }
                            break;
                        case '=':
                            if (input[tokenPos] == '=') {
                                tokenPos++;
                                token = Symbol.EQUAL;
                            }
                            else{
                                token = Symbol.ASSIGN;
                            }
                            
                            break;
                        case '(':
                            token = Symbol.LEFTPAR;
                            break;
                        case ')':
                            token = Symbol.RIGHTPAR;
                            break;
                        case '[':
                            token = Symbol.LEFTCOLCHETE;
                            break;
                        case ']':
                            token = Symbol.RIGHTCOLCHETE;
                            break;
                        case '{':
                            token = Symbol.LEFTKEY;
                            break;
                        case '}':
                            token = Symbol.RIGHTKEY;
                            break;                
                        case ',':
                            token = Symbol.COMMA;
                            break;
                        case ';':
                            token = Symbol.SEMICOLON;
                            break;
                        case ':':
                            token = Symbol.COLON;
                            break;
                        case '^':
                            token = Symbol.CIRCUMFLEX;
                            break;
                        default:
                            // ERROR - INVALID CHARACTER
                            
                            
                    }
                }
            }
        }
        
        beforeLastTokenPos = lastTokenPos;
        lastTokenPos = tokenPos - 1;
    }
  
    public String getStringValue(){
        return StringValue;
    }
    
    public int getLineNumber(){
        return lineNumber;
    }
    
    public int getNumber(){
        return numberInt;
    }
    
    public float getNumberFloat(){
        return numberFloat;
    }
    
    public int getLineNumber(int index){
        int i, n, size;
        
        n = 1;
        i = 0;
        size = input.length;

        while ( i < size && i < index ) {
            if ( input[i] == '\n' ) n++;
            i++;
        }
        return n;
    }
    
    public int getLineNumberBeforeLastToken() {
        return getLineNumber( beforeLastTokenPos );
    }
    
    
}
