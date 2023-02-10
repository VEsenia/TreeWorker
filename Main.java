import com.sun.source.tree.Tree;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static void DrawLine(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("---");
        }
    }
    private static void DrawFile(TreeFile file, int i)
    {
        DrawLine(i);
        if(file.getDirectory())
            System.out.println(ANSI_BLUE+file.getName()+ANSI_RESET);
        else
            System.out.println(file.getName());
    }
    private static void DrawTree(TreeFile tree, int i)
    {
        i++;
        DrawFile(tree, i);
        for(TreeFile file : tree.getFile())
        {
            if(file.getDirectory()) {
                DrawTree(file, i);
            }
            else
                DrawFile(file, i);
        }
    }
    public static TreeFile  processFilesFromFolder(File folder, TreeFile treeFile) {
        File[] folderEntries = folder.listFiles();
        ArrayList<TreeFile> lstFiles = new ArrayList<>();
        for (File entry : folderEntries) {
            TreeFile treeFileInside = new TreeFile(entry.getName(), entry.getPath(), entry.isDirectory());
            lstFiles.add(treeFileInside);
            if (entry.isDirectory()) {
                processFilesFromFolder(entry, treeFileInside);
            }
            else {
                    //simple file
            }
        }
        treeFile.setFile(lstFiles);
        return treeFile;
    }

    public static void main(String[] args) {
        File curDir = Paths.get("").toFile().getAbsoluteFile();
        TreeFile treeFile = new TreeFile(curDir.getName(), curDir.getPath(), curDir.isDirectory());
        TreeFile tree = processFilesFromFolder(curDir, treeFile);
        DrawTree(tree, 0);
    }
}
