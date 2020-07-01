package serialization;

import nu.xom.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * * @Author: cuixin
 * * @Date: 2020/7/1 10:02
 */
public class People extends ArrayList<APerson> {
    public People(String fileName) throws ParsingException, IOException {
        Document doc = new Builder().build(new File(fileName));
        Elements elements = doc.getRootElement().getChildElements();
        for(int i=0; i<elements.size(); i++){
            add(new APerson(elements.get(i)));
        }
    }
    public static void main(String[] args) throws ParsingException, IOException {
        People p = new People("People.xml");
        System.out.println(p);
    }
}
