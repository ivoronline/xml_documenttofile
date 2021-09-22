import org.w3c.dom.Document;

public class Main {

  //XML STRING
  static String xmlString =
    "<person Id='1'>\n" +
    "  <name> John </name>\n" +
    "  <age>  20   </age>\n" +
    "</person>";

  //OUTPUT FILE
  static String fileXMLOutput = "src/main/resources/Person.xml";

  //================================================================================
  // MAIN
  //================================================================================
  public static void main(String[] args) throws Exception {

    //GET DOCUMENT
    Document document = UtilXML.stringToDocument(xmlString);

    //SAVE XML TO FILE
    UtilXML.saveXMLToFile(fileXMLOutput, document);

  }

}
