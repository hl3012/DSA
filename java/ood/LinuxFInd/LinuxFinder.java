package LinuxFInd;

import java.util.*;

// ls(path)
// mkdir(path)
// addContentToFile(filePath, content)
// readContentFromFile(filePath)

// Follow-up
// 如何支持删除？
// 如何支持权限？
// 如何支持大文件？

class File{
    String path;
    String type;//txt, mp3...
    int size; //XXmb
    boolean isDirectory; //is folder or file
    List<File> subFiles = new ArrayList<>(); //if folder, list of file; if file then empty
}

interface Filter {
    boolean match(File file);
}

class SizeFilter implements Filter {
    int requireSize;
    SizeFilter(int size){
        requireSize=size;
    }
  @Override
  public boolean match(File file){
      return file.size<=requireSize;
  
    }
}

class TypeFilter implements Filter {
    String type;
    TypeFilter(String type){
        this.type=type;
    }
  @Override
  public boolean match(File file){
      return file.type!=null  && file.type.equals(this.type);  
    }
}

public class LinuxFinder {

    List<File> find(File root, Filter filter) {
        List<File> res = new ArrayList<>();
        dfs(root, res, filter);
        return res;
    }

    private void dfs(File file, List<File> res, Filter filter) {
        if(file==null) return;
        if(!file.isDirectory&&filter.match(file)) {
            res.add(file);
            return;
        }
        for(File f: file.subFiles) {
            dfs(f,res,filter);
        }
    }  
    
}


class Main {
    public static void main(String[] args) {
        LinuxFinder finder = new LinuxFinder();
        File root = new File();
        List<File> txts = finder.find(root, new TypeFilter("txt"));
        List<File> less5mb = finder.find(root, new SizeFilter(5));
    }
}
