/* Caio Henrique Giacomelli  RA: 620297
   Matheus Augusto Thomaz    RA: 620599  
 */
package Principal;
import java.util.*;

/**
 *
 * @author matheus
 */
public class VariablesTable {
    
        public static Hashtable VariableTable = new Hashtable();
        public static Hashtable ValuesTable = new Hashtable();
        public static ArrayList<String> string = new ArrayList<String>();
        public static boolean flag,last = false, flagcomp = false, first = false, print = false, printed = false;
        public static char []signal;
        public static boolean isString;
        
        public static void insert(String name, int symbol){
            VariableTable.put(name, symbol);
        }
        
        public static int getTable(String name){
            Object obj = VariableTable.get(name);
            
            if(obj == null)
                return -1;
            
            return ((Integer)obj).intValue();
        }
        
        public static void insertValues(String name, int value){
            ValuesTable.put(name, value);
        }
        
        public static int getTableValues(String name){
            Object obj = ValuesTable.get(name);
            
            if(obj == null)
                return -1;
            
            return ((Integer)obj).intValue();
        }
           
}
