package com.tyj.com;


import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
/**
 * 判断java 文件如果是GBK进行转换为UTF8，如果不是，直接复制文件到新目录
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
    {
     
    	 

    	      //GBK编码格式源码路径
    			String srcDirPath = "E:\\src";
    			//转为UTF-8编码格式源码路径
    			String utf8DirPath = "E:\\src_utf8";
    			//获取所有java文件 
    			Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(srcDirPath), new String[] { "java" }, true);
    	 
    			for (File javaGbkFile:javaGbkFileCol) {
    				//UTF8格式文件路径 
    				String utf8FilePath = utf8DirPath + javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
    				// System.out.println(utf8FilePath );
    				 
    				 try {
    					 String srcgbkpath=srcDirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
    					 String encodeType = EncodeUtils.getEncode(  srcgbkpath, true);
    					if (encodeType.equals("GBK"))
    					{
    						
    						FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
    						 System.out.print( "源文件"+srcgbkpath +"   "  );	
    						 System.out.println( utf8FilePath +"转换UTF8成功！" );
    						
    					}
    					else {
    						//FileUtils.writeLines(new File(utf8FilePath) ,"UTF-8",FileUtils.readLines(javaGbkFile, "UTF-8"));
    						 
    						  File streamsrc = new File(srcgbkpath);
    						  File streamutf = new File(utf8FilePath);
    					 
    							 FileUtils.copyFile(streamsrc, streamutf);
    							 
    						 System.out.println( srcgbkpath +"  "+encodeType+"不用转换直接进行复制" );
						}
    					 
    					 
    					 
    					 
    					// System.out.println( srcgbkpath +"_____"+encodeType );
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.toString());
						// System.out.println( "________");
						
					}
    				
    				 
    				 
    				 
    				//使用GBK读取数据，然后用UTF-8写入数据 
    				//FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
    				
    				 
    			}

    	
    	
        System.out.println( "Hello World!aaa" );
    }
}
    
}
