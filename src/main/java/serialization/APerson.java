package serialization;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * * @Author: cuixin
 * * @Date: 2020/7/1 9:43
 */
public class APerson {
    private String first, last;
    public APerson(String first, String last){
        this.first = first;
        this.last = last;
    }

    //produce on XML Element from this APerson object
    public Element getXML(){
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    //Constructor restores a APerson from XML
    public APerson(Element person){
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    @Override
    public String toString() {
        return first+" "+last;
    }

    //Make it human-readable
    public static void format(OutputStream out, Document doc) throws IOException {
        Serializer serializer = new Serializer(out, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws IOException {
        List<APerson> people = Arrays.asList(
                new APerson("Dr. Bunsen", "Honeydew"),
                new APerson("Gonzo", "The Great"),
                new APerson("Philip J.", "Fry"));
        System.out.println(people);
        Element root = new Element("people");
        for(APerson p: people){
            root.appendChild(p.getXML());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
    }
}
