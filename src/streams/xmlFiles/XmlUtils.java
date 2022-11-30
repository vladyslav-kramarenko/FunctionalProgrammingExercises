package streams.xmlFiles;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class XmlUtils {
    /**
     * produces a map whose keys are the XML file encoding,
     * and the corresponding values are the total numbers of tags in the files
     * that contain the specified tag.
     * If the XML file tags do not contain the specified tag name,
     * the value should be equal to 0.
     *
     * @param files   a list of XML files
     * @param tagName a tag name
     * @return a map <XML file encoding,numbers of tags>
     */
    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        Map<String, Long> result = null;
//        var 1
//        result = files.stream()
//                .collect(groupingBy(XmlFile::getEncoding))
//                .entrySet().stream().collect(Collectors.toMap(
//                                entry -> entry.getKey(),
//                                entry -> entry.getValue().stream()
//                                        .filter(x -> x.getTags().stream().map(Tag::getName)
//                                                        .anyMatch(tagName::equals)
////                                                      .toList().contains(tagName)
//                                        )
//                                        .flatMap(x -> x.getTags().stream())
//                                        .count()
//                        )
//                );
//        var 2
        result = files.stream()
                .collect(groupingBy(XmlFile::getEncoding,
                                mapping(XmlFile::getTags,
                                        filtering(tags -> tags.stream().map(Tag::getName).anyMatch(tagName::equals),
                                                flatMapping(Collection::stream, counting())
                                        )
                                )
                        )
                );
        return result;
    }

    /**
     * produces a map whose keys are the XML file encoding,
     * and the corresponding values are the total numbers of specified tags in the files
     * If the XML file tags do not contain the specified tag name,
     * the value should be equal to 0.
     *
     * @param files   a list of XML files
     * @param tagName a tag name
     * @return a map <XML file encoding,numbers of tags>
     */
    public static Map<String, Long> countAllTagName(List<XmlFile> files, String tagName) {
        Map<String, Long> result =
                files.stream().collect(groupingBy(XmlFile::getEncoding))
                        .entrySet().stream().collect(Collectors.toMap(
                                        entry -> entry.getKey(),
                                        entry -> entry.getValue().stream()
                                                .flatMap(x -> x.getTags().stream())
                                                .filter(tag -> tag.getName().equals(tagName))
                                                .count()
                                )
                        );
        return result;
    }
}
