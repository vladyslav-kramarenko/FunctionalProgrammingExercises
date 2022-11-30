package streams.xmlFiles;

import java.util.List;
import java.util.Map;

public class XmlUtils {
    /**
     * produces a map whose keys are the XML file encoding,
     * and the corresponding values are the total numbers of tags in the files
     * that contain the specified tag.
     * If the XML file tags do not contain the specified tag name,
     * the value should be equal to 0.
     * @param files a list of XML files
     * @param tagName a tag name
     * @return a map <XML file encoding,numbers of tags>
     */
    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        Map<String, Long>result = null;
        files.stream();
        // write your code here
        return result;
    }
}
