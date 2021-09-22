import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

public class UtilXML {

  //================================================================================
  // STRING TO DOCUMENT
  //================================================================================
  public static Document stringToDocument(String xmlString) throws Exception {

    //READ XML STRING
    InputSource            inputSource = new InputSource();
                           inputSource.setCharacterStream(new StringReader(xmlString));

    //CONVERT TO DOCUMENT
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                           documentBuilderFactory.setNamespaceAware(true);    //IMPORTANT
    DocumentBuilder        documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document               document        = documentBuilder.parse(inputSource);

    //RETURN DOCUMENT
    return document;

  }

  //================================================================================
  // SAVE XML TO FILE
  //================================================================================
  public static void saveXMLToFile(String fileName, Document document) throws Exception {

    //OPEN FILE FOR WRITING
    OutputStream       outputStream       = new FileOutputStream(fileName);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer        transformer        = transformerFactory.newTransformer();
                       transformer.transform(new DOMSource(document), new StreamResult(outputStream));

  }

}
