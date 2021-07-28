package com.avantica.tutorial.algorithmsdatastructures.queue;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.*;

public class QueueTest {
    private String readFolderName(){
        ConsoleReader console = mock(ConsoleReader.class);
        when(console.read()).thenReturn("c:\\test");
        return console.read();
    }

    @Test
    public void testNewQueueIsEmpty() {
        MyQueue<String> queue = new MyQueue<String>();
        Assert.assertTrue("Failure - expected queue is not empty", queue.isEmpty());
        Assert.assertEquals("Failure - expected queue is not empty", queue.size(), 0);
    }

    @Test
    public void testInsert5ItemsToEmptyQueue() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        int numberOfInserts = 5;
        for (int i = 0; i < numberOfInserts; i++) {
            queue.enqueue(new Integer(i));
        }
        Assert.assertTrue("Failure - expected queue is empty", !queue.isEmpty());
        Assert.assertEquals("Failure - expected queue size does not match", queue.size(), numberOfInserts);
    }

    @Test
    public void testEnqueueAndDequeue3Items(){
        MyQueue<String> queue = new MyQueue<String>();
        int numberOfItems = 3;
        for (int i = 0; i < numberOfItems; i++) {
            queue.enqueue("element" + String.valueOf(i));
        }

        for (int i = 0; i < numberOfItems; i++) {
            String item = queue.dequeue();
            Assert.assertEquals("Failure - expected item does not match", item, "element" + String.valueOf(i));
        }
    }

    @Test(expected=NoSuchElementException.class)
    public void testRemoveOnEmptyQueue() {
        MyQueue<String> queue = new MyQueue<String>();
        Assert.assertTrue("Failure - expected queue is not empty", queue.isEmpty());
        queue.dequeue();
    }

    @Test
    public void testFolderList(){
        FolderList myFolderList = new FolderList();
        myFolderList.listFolders(readFolderName());
        String levelsFolders[] = {
                "c:\\test\\test1",
                "c:\\test\\test1\\test11",
                "c:\\test\\test2",
                "c:\\test\\test3"
        };
        MyQueue<String> queueFolder = myFolderList.getQueueFolder();

        int index=0;
        while(!queueFolder.isEmpty()){
            String path = queueFolder.dequeue();
            Assert.assertEquals("Failure - expected queue of folders does not match", path, levelsFolders[index++]);
        }
    }

    @Test
    public void testFileList(){
        FolderList myFolderList = new FolderList();
        ArrayList<String> folderList = myFolderList.listFoldersAndFiles(readFolderName());

        String levelsFiles[] = {
                "\ttest1",
                "\t\texample11.txt",
                "\t\texample12.txt",
                "\t\ttest11",
                "\t\t\texample111.txt",
                "\ttest2",
                "\t\texample21.txt",
                "\t\texample22.txt",
                "\ttest3"
        };

        for (int index = 0; index < folderList.size(); index++) {
            Assert.assertEquals("Failure - expected queue of folders and files does not match", folderList.get(index), levelsFiles[index]);
        }
    }
}


