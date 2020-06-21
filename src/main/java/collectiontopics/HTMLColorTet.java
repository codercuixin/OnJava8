package collectiontopics;
import static onjava.HTMLColors.*;
/**
 * * @Author: cuixin
 * * @Date: 2020/6/10 15:06
 */
public class HTMLColorTet {
    static final int DISPLAY_SIZE = 20;
    public static void main(String[] args){
        show(MAP, DISPLAY_SIZE);
        border();
        showInv(INVMAP, DISPLAY_SIZE);
        border();
        show(LIST, DISPLAY_SIZE);
        border();
        showrgb(RGBLIST, DISPLAY_SIZE);
    }
}
