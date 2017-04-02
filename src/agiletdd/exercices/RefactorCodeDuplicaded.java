package agiletdd.exercices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefactorCodeDuplicaded {


    public List getDirectorieNames(String path) {
        List directoryNames = new ArrayList<>();
        File pathFile = new File(path);

        if(!pathFile.exists())
            throw new RuntimeException("Directory not exits.");

        File[] files = pathFile.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                directoryNames.add(file.getName());
            }
        }

        return directoryNames;
    }

    public List getDirectorieAbsolutePath(String pathName) {
        List allNames = new ArrayList<>();
        File rootFile = new File(pathName);

        if(!rootFile.exists())
            throw new RuntimeException("Directory not exits.");

        File[] allRootFiles = rootFile.listFiles();

        for(File fileNode : allRootFiles){
            if(fileNode.isDirectory()){
                allNames.add(fileNode.getAbsolutePath());
            }
        }

        return allNames;
    }

    public List getDirectorieCanonicalPath(String path) throws IOException {
        List directoryNames = new ArrayList<>();
        File pathFile = new File(path);

        if(!pathFile.exists())
            throw new RuntimeException("Directory not exits.");

        File[] files = pathFile.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                directoryNames.add(file.getCanonicalPath());
            }
        }

        return directoryNames;
    }


}
