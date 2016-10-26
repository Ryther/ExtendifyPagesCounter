package utilities;



import utilities.OddEvenPages;
import java.util.concurrent.Callable;

/**
 *
 * @author Edoardo Zanoni
 */
public class ExtenderThread implements Callable {

    private final String minifiedString;
    private String result;
    
    public ExtenderThread (String data) {
        
        this.minifiedString = data;
    }
    
    @Override
    public String call() {
        
        this.result = null;
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        int end = 0;
        OddEvenPages oddOrEvenPages = null;
        
        for (int i=0; i<this.minifiedString.length();i++) {
            
            char actualChar = this.minifiedString.charAt(i);
            if (actualChar == 'o') {
                
                end = i;
                for (int j = i-1; j >= 0; j--) {
                    
                    if (j == 0) {
                        
                        start = j;
                        oddOrEvenPages = new OddEvenPages(this.minifiedString.substring(start,end), true);
                        break;
                    } else if (this.minifiedString.charAt(j-1) == ',') {
                        
                        start = j;
                        oddOrEvenPages = new OddEvenPages(this.minifiedString.substring(start,end), true);
                        break;
                    }
                }
                
                //i = i + 2;
                stringBuilder.delete(
                        stringBuilder.indexOf(this.minifiedString.substring(start,end)),
                        stringBuilder.length());
                stringBuilder.append(oddOrEvenPages.getcPages());
                continue;
            } else if (actualChar == 'e') {
                
                end = i;
                for (int j = i-1; j >= 0; j--) {
                    
                    if (j == 0) {
                        
                        start = j;
                        oddOrEvenPages = new OddEvenPages(this.minifiedString.substring(start,end), false);
                        break;
                    } else if (this.minifiedString.charAt(j-1) == ',') {
                        
                        start = j;
                        oddOrEvenPages = new OddEvenPages(this.minifiedString.substring(start,end), false);
                        break;
                    }
                }
                
                //i = i + 2;
                stringBuilder.delete(
                        stringBuilder.indexOf(this.minifiedString.substring(start,end)),
                        stringBuilder.length());
                stringBuilder.append(oddOrEvenPages.getcPages());
                continue;
            } else {
                
                stringBuilder.append(actualChar);
            }
        }
        
        this.result = stringBuilder.toString();
        System.out.println(this.result);
        return this.result;
    }   
}
