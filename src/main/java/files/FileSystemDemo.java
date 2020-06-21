package files;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 15:49
 */
public class FileSystemDemo {
    static void show(String id, Object o){
        System.out.println(id+": "+o);
    }
    public static void main(String[] args){
        System.out.println(System.getProperty("os.name"));
        FileSystem fileSystem = FileSystems.getDefault();
        for(FileStore fs: fileSystem.getFileStores()){
            show("FileStore", fs);
        }
        for(Path rd: fileSystem.getRootDirectories()){
            show("Root Directory", rd);
        }
        show("Separator", fileSystem.getSeparator());
        show("UserPrincipalLookupService", fileSystem.getUserPrincipalLookupService());
        show("isOpen", fileSystem.isOpen());
        show("isReadOnly", fileSystem.isReadOnly());
        show("FileSystemProvider", fileSystem.provider());
        show("File Attribute views", fileSystem.supportedFileAttributeViews());
    }
}
