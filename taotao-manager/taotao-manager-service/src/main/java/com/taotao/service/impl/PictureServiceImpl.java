package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.IPictureService;

@Service
public class PictureServiceImpl implements IPictureService {

	//服务器地址
	@Value("${SERVER_URL}")
	private String SERVER_URL;
	
	@Override
	public PictureResult uploadPicture(MultipartFile picFile) {

		PictureResult result = new PictureResult();
		// 判断上传图片是否为空
		if (null == picFile || picFile.isEmpty()) {
			result.setError(1);
			result.setMessage("图片为空");
		} else {
			// 取文件原始名称
			String originalFilename = picFile.getOriginalFilename();
			// 取文件扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			FastDFSClient fastDFSClient;
			try {
				fastDFSClient = new FastDFSClient("classpath:properties/client.conf");
				String url = SERVER_URL + fastDFSClient.uploadFile(picFile.getBytes(), extName);
				// 把url响应给客户端
				result.setError(0);
				result.setUrl(url);
				result.setMessage("图片上传成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.setError(1);
				result.setMessage("图片上传失败");
			}
		}
		return result;
	}

}
