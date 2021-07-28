package com.avantica.tutorial.algorithmsdatastructures.queue;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class FolderList {
    MyQueue<String> queueFolder = new MyQueue<String>();

    public MyQueue<String> getQueueFolder() {
        return queueFolder;
    }

    private FileFilter folderFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };

    private FileFilter fileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isFile();
        }
    };

    private String getTabsSeparator(final int countSeparators){
        String result = "";
        for (int i=0; i<countSeparators; i++){ result += "\t"; }
        return result;
    }

    private String indentFolder(String path){
        int lastSeparator = path.lastIndexOf("\\") + 1;
        int countSeparators = path.length() - path.replace("\\", "").length() - 1;
        return getTabsSeparator(countSeparators) + path.substring(lastSeparator);
    }

    private String indentFile(String path, String fileName){
        int countSeparators = path.length() - path.replace("\\", "").length() ;
        return getTabsSeparator(countSeparators) + fileName;
    }

    public ArrayList<String> listFoldersAndFiles(String path){
        listFolders(path);
        ArrayList<String> result = new ArrayList<String>();
        while(!queueFolder.isEmpty()){
            path = queueFolder.dequeue();
            result.add(indentFolder(path));

            File folder = new File(path);
            for (File file:folder.listFiles(fileFilter)) {
                result.add(indentFile(path, file.getName()));
            }
        }
        return result;
    }

    public void listFolders(final String dirPath) {
        File folder = new File(dirPath);
        File[] firstLevelFolders = folder.listFiles(folderFilter);
        if (firstLevelFolders != null && firstLevelFolders.length > 0) {
            for (File myFolder : firstLevelFolders) {
                queueFolder.enqueue(myFolder.getAbsolutePath());
                listFolders(myFolder.getAbsolutePath());
            }
        }
    }
}
