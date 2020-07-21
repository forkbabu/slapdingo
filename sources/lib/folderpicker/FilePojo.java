package lib.folderpicker;

public class FilePojo {
    private boolean folder;
    private String name;

    public FilePojo(String str, boolean z) {
        this.name = str;
        this.folder = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isFolder() {
        return this.folder;
    }

    public void setFolder(boolean z) {
        this.folder = z;
    }
}
