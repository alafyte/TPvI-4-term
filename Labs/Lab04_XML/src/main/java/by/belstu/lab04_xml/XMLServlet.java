package Servlet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class XMLServlet extends javax.servlet.http.HttpServlet {
    private static ArrayList<Person> people = new ArrayList<>();

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        MyHandler myHandler = new MyHandler();
        try {
            parser.parse(new File("D:\\2 курс\\Java\\Xml\\web\\myXml.xml"), myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        for (Person person : people) {
            Element persons = document.createElement("persons");

            root.appendChild(persons);
            persons.setAttribute("name", person.name);
            persons.setAttribute("nubmer", person.number);
            persons.setAttribute("sum", person.sum);
        }

        Transformer t = null;
        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        if (t != null) {
            t.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        try {
            if (t != null) {
                t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("D:\\2 курс\\Java\\Xml\\web/ewXml.xml")));
            }
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        private String element, name, number, sum;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if((name != null && !name.isEmpty()) && (number != null && !number.isEmpty()) && (sum != null && !sum.isEmpty())){
                people.add(new Person(name, number, sum));
                name = null;
                number = null;
                sum = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String inf = new String(ch, start, length);
            inf = inf.replace("/n", "").trim();

            if(!inf.isEmpty()){
                if(element.equals("name")){
                    name = inf;
                }
                if(element.equals("number")){
                    number = inf;
                }
                if(element.equals("sum")){
                    sum = inf;
                }
            }
        }
    }


    public static class Person{
        private String name;
        private String number;
        private String sum;

        public Person(String name, String number, String sum){
            this.name = name;
            this.number = number;
            this.sum = sum;
        }
    }
}
