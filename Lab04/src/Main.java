import Company.Company;
import Staff.Engineer;
import Staff.ProgType;
import Staff.Programmer;
import Staff.SysAdmin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        //2. Произвести проверку валидности XML-документа с привлечением XSD.
        String filename = "files/info.xml";
        String schemaName = "files/info.xsd";
        Schema schemas = null;

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);

        Company ITCompany = new Company();
        Company.Director director = ITCompany.new Director("Bill Gates");
        ITCompany.addWorker(new Engineer("Симонов", "Андрей", 20, 5, 3));
        ITCompany.addWorker(new SysAdmin("Иванов", "Иван", 28, 3000, 6));
        ITCompany.addWorker(new Programmer("Петров", "Петр", 27, 4000,
                7, ProgType.Middle));
        ITCompany.addWorker(new Programmer("Васильев", "Василий", 30, 4500,
                10, ProgType.Senior));
        ITCompany.addWorker(new Programmer("Данилевич", "Анастасия", 29, 4500,
                10, ProgType.Senior));

        try {
            schemas = factory.newSchema(new File(schemaName));
            Validator validator = schemas.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            LOG.info(filename + " is valid");
        }
        catch (SAXException e) {
            LOG.error(filename + " SAX error " + e.getMessage());
        }
        catch (IOException e) {
            LOG.error(" io error " + e.getMessage());
        }

        //4. Для разбора использовать на выбор один из: SAX (Simpl API for XML),
        //DOM (Document Object Model), StAX (Streaming API foe XML) парсеры
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            Parser parser = new Parser();
            reader.setContentHandler(parser);
            reader.parse("files/info.xml");
        }
        catch (SAXException e){
            LOG.error(filename + " SAX error " + e.getMessage());
        }
        catch (IOException e){
            LOG.error(" io error " + e.getMessage());
        }

        //5. Добавьте методы сериализация и десериализации в JSON файл
        //(используйте любую библиотеку)
        try(FileWriter writer = new FileWriter("json/task5.json", false)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();;
            String json = gson.toJson(ITCompany.getStaff());
            writer.write(json);
            writer.flush();

            List<String> lines = Files.readAllLines(Paths.get("json/task5.json"));
            String text = String.join(System.lineSeparator(), lines);
            JsonParser parser = new JsonParser();
            var jsonElement = parser.parse(text);
            System.out.println(jsonElement);
        }
        catch (IOException e){
            LOG.error(" io error " + e.getMessage());
        }
        //6. Добавьте в проект работу со StreamAPI для обработки данных в
        //функциональном стиле
        System.out.println();
        var result = ITCompany.getStaff().stream().filter(w -> w.getAge() > 28).toArray();
        for (var w: result) {
            System.out.println(w);
        }
    }
}