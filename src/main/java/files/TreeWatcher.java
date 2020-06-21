package files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @Author: cuixin
 * * @Date: 2020/6/9 16:27
 */
public class TreeWatcher {
    static void watchDir(Path dir){
        try{
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(()->{
                try{
                    WatchKey key = watcher.take();
                    for(WatchEvent evt: key.pollEvents()){
                        System.out.println("evt.context(): "+evt.context()+
                                "\nevt.count(): "+ evt.count()
                                +"\nevt.kind(): "+evt.kind());
//                        System.exit(0);
                    }
                }catch (InterruptedException e){
                    return;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(Paths.get("test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();
    }
}
