package com.pandy.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Pandy
 * @Date: 2019/5/20 18:06
 * @Version 1.0
 */
public class LuceneFirst {


    /**
     * 创建directory对象 指定索引库保存的位置
     * 基于directory对象创建一个indexwriter对象
     * 读取磁盘上的文件 对象每个文件创建一个文档对象
     * 向文档对象中添加域
     * 把文件对象写入索引库
     * 关闭indexwriter对象
     */
    @Test
    public void createIndex() throws IOException {
        Directory directory = FSDirectory.open(new File("G:\\ideaProject\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig());
        File dir = new File("G:\\ideaProject\\searchsource");
        File[] files = dir.listFiles();
        for (File file : files) {
            //取文件名
            String name = file.getName();
            //路径
            String path = file.getPath();
            //内容
            String fileContent = FileUtils.readFileToString(file, "utf-8");
            //大小
            long fileSize = FileUtils.sizeOf(file);
            //创建Field  名称 内容 是否存储
            Field fieldName = new TextField("name",name, Field.Store.YES);

            Field fieldPath = new TextField("path",path, Field.Store.YES);

            Field fieldContent = new TextField("content",fileContent, Field.Store.YES);

            Field fieldSize = new TextField("size",fileSize + "",TextField.Store.YES);

            //创建文档对象
            Document document = new Document();
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSize);
            //文档对象写入索引库
            indexWriter.addDocument(document);
        }
        indexWriter.close();
    }

}
