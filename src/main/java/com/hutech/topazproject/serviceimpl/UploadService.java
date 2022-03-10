package com.hutech.topazproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.model.UploadLogo;
import com.hutech.topazproject.repository.UploadLogoRepo;

@Service
public class UploadService {

	@Autowired
	private UploadLogoRepo uploadRepo;

	// private UploadLogo uploadlogo;

	public UploadLogo saveLogo(UploadLogo logo) {

		return uploadRepo.save(logo);

	}

}

//	public String updateLogo(MultipartFile fileData, Long id) throws IOException {
//		ManufacturerOnboardDetails objFromDB = uploadRepo.getById(id);
//		System.out.print("#################@@@@@@@@@@@");
//		if (objFromDB != null && uploadRepo.findById(id).isPresent()) {
//			uploadlogo.setFileData(fileData.getBytes());
//			uploadRepo.save(objFromDB);
//		}
//
//		return "saved";
//
//	}
//}

//
//		UploadLogo uploadLogo = null;
//		try {
//			uploadLogo = new UploadLogo();
//			uploadLogo.setFileName(file);
//			uploadLogo.setFileData(id.getBytes());
//		} catch (Exception e) {
//			
//			return null;
//		}
//		return uploadRepo.save(uploadLogo);
//
//	}
//}