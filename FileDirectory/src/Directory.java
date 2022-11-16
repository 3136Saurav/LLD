import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.fileSystemList = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println("Directory Name: " + this.directoryName);
        for (FileSystem fs : fileSystemList) {
            fs.ls();
        }
    }

    public void add(FileSystem fs) {
        this.fileSystemList.add(fs);
    }


}
