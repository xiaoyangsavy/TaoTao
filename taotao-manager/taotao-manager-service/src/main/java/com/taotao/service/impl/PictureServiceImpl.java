package com.taotao.service.impl;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.IPictureService;

public class PictureServiceImpl implements IPictureService {

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
			String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
			FastDFSClient fastDFSClient;
			try {
				fastDFSClient = new FastDFSClient("classpath:properties/client.conf");
				String url = fastDFSClient.uploadFile(picFile.getBytes(), extName);
				// 把url响应给客户端
				result.setError(0);
				result.setUrl(url);
			} catch (Exception e) {
				e.printStackTrace();
				result.setError(1);
				result.setMessage("图片上传失败");
			}
		}
		return result;
	}

}
