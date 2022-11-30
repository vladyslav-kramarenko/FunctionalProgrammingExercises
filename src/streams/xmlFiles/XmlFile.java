package streams.xmlFiles;

import java.util.List;

class XmlFile {
    private final String id;
    private final String encoding;
    private final List<Tag> tags;

    XmlFile(String id, String encoding, List<Tag> tags) {
        this.id = id;
        this.encoding = encoding;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getEncoding() {
        return encoding;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public static void main(String[] args) {
        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column"), new Tag("row")))
        );

        XmlUtils.countAllByTagName(xmlFiles, "sheet"); // returns ​{"UTF-8"=0, "ASCII"=5}
    }
}