package com.taotao.ftp;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FTPClientTest {

	// 测试图片上传到fastDFS
	@Test
	public void testUpload() throws Exception {
		// 1、把FastDFS提供的jar包添加到工程中
		// 2、初始化全局配置。加载一个配置文件。
		ClientGlobal.init(
				"D:\\WorkSpace\\TaoTao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		// 3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		// 4、创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、声明一个StorageServer对象，null。
		StorageServer storageServer = null;
		// 6、获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 7、直接调用StorageClient对象方法上传文件即可。
		String[] strings = storageClient
				.upload_file("D:\\Dropbox\\Image\\Wallpaper\\881cd8f6407a0499c6e336b845ea2a22_r.png", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}

	}
	
	 @Test
	    public void testFastDFS() throws Exception{
	        FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/client.conf");///taotao-manager-web/src/test/resources/properties/client.conf
	        String url = fastDFSClient.uploadFile("D:\\Dropbox\\Image\\Wallpaper\\76OAPLJ62G1V0031.jpg");
	        System.out.println(url); //group1/M00/00/00/76OAPLJ62G1V0031.png
	    }
}
