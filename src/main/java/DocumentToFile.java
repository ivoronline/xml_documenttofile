import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DocumentToFile {

  static String fileXMLInput  = "src/main/resources/PersonInput.xml";
  static String fileXMLOutput = "src/main/resources/PersonOutput.xml";

  //================================================================================
  // MAIN
  //================================================================================
  public static void main(String[] args) throws Exception {

    //REA XML FROM FILE
    Document document = readXMLFromFile(fileXMLInput);

    //SAVE XML TO FILE
    saveXMLToFile(document, fileXMLOutput);

  }

  //================================================================================
  // SAVE XML TO FILE
  //================================================================================
  public static void saveXMLToFile(Document document, String fileName) throws Exception {

    //OPEN DESTINATION FILE
    OutputStream        outputStream      = new FileOutputStream(fileName);

    //SAVE DOCUMENT
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer        transformer        = transformerFactory.newTransformer();
                       transformer.transform(new DOMSource(document), new StreamResult(outputStream));

  }

  //================================================================================
  // READ XML FROM FILE
  //================================================================================
  // Document document = readXMLFromFile(fileXMLInput);
  public static Document readXMLFromFile(String fileName) throws Exception {

    //OPEN XML FILE FOR READING
    FileInputStream        fileInputStream        = new FileInputStream(fileName);

    //CREATE DOCUMENT
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                           documentBuilderFactory.setNamespaceAware(true);    //IMPORTANT
    DocumentBuilder        documentBuilder        = documentBuilderFactory.newDocumentBuilder();
    Document               document               = documentBuilder.parse(fileInputStream);

    //RETURN DOCUMENT
    return document;

  }


}
