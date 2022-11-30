package applyFuncsToCollectionsAndMonads.userQuiz;

class Account {
    private String id;
    private String type;

    public Account(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
