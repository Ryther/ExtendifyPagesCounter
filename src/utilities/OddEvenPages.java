package utilities;

/**
 *
 * @author Edoardo Zanoni
 */
public class OddEvenPages {
    
    String cPages;

    public OddEvenPages(String sPages, boolean isOdd) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] pages = sPages.split("-");
        if (isOdd) {
            
            if (Integer.parseInt(pages[0])%2 == 0) {
                
                pages[0] = String.valueOf(Integer.parseInt(pages[0])+1);
            }
        } else {
            
            if (Integer.parseInt(pages[0])%2 != 0) {
                
                pages[0] = String.valueOf(Integer.parseInt(pages[0])+1);
            }
        }
        for (int i = Integer.parseInt(pages[0]); i <= Integer.parseInt(pages[1]); i = i + 2) {
            
            stringBuilder.append(i).append(",");
        }
        this.cPages = stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")).toString();
    }

    public String getcPages() {
        return cPages;
    }

    public void setcPages(String cPages) {
        this.cPages = cPages;
    }    
}
