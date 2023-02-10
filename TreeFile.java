import java.util.ArrayList;

//тест ветки
public class TreeFile {
    private String name;
    private String path;
    private ArrayList<TreeFile> lstFile;
    private Boolean isDirectory;

    public TreeFile(String name, String path, Boolean isDirectory) {
        this.name = name;
        this.path = path;
        this.isDirectory = isDirectory;
        lstFile = new ArrayList<TreeFile>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<TreeFile> getFile() {
        return lstFile;
    }

    public void setFile(ArrayList<TreeFile> file) {
        this.lstFile = file;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }
}
