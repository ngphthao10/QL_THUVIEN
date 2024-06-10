package poly.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;

import poly.dao.SachDAO;
import poly.dto.SachDTO;
import poly.entity.Sach;

@Service
@Transactional
public class SachService {
	@Autowired
	SachDAO sachDAO;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	ServletContext context;
	
	public PagedListHolder<Sach> paging(List<Sach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(4);
		return pagedListHolder;
	}

	public List<Sach> getAllSach() {
		return sachDAO.getAllSach();
	}

	public List<Sach> getSearch(String keyword) {
		return sachDAO.getSearch(keyword);
	}

	public List<Sach> getAllSachTheoTinhTrang(int daAn) {
		return sachDAO.getAllSachTheoTinhTrang(daAn);
	}

	public int themSachMoi(SachDTO sachDTO, MultipartFile file) {
		String fileName = imageService.uploadFile(file);
		if (fileName != "0" && fileName != "") {
			sachDTO.getSach().setHinhAnh(fileName);
		} else if (fileName == "0") {
			return 2; // loi load file
		} else {
			sachDTO.getSach().setHinhAnh("default-image.png");
		}
		return sachDAO.themSachMoi(sachDTO);
	}

	public int themSachDaCo(SachDTO sachDTO) {
		return sachDAO.themSachDaCo(sachDTO);
	}

	public Sach getSachTheoId(Integer id) {
		return sachDAO.getSachTheoId(id);
	}

	public int editSach(SachDTO sachDTO, MultipartFile file) {
		String fileName = imageService.uploadFile(file);
		if (fileName != "0" && fileName != "") {
			sachDTO.getSach().setHinhAnh(fileName);
		} else if (fileName == "0") {
			return 2;
		}
		return sachDAO.editSach(sachDTO);
	}

	public List<Sach> getAllSachChoUser() {
		return sachDAO.getAllSachChoUser();
	}

	public List<Sach> getAllSachTheoTheLoai(int id) {
		return sachDAO.getAllSachTheoTheLoai(id);
	}

	public List<Sach> getAllSachTheoSLCL(int conlai) {
		return sachDAO.getAllSachTheoSLCL(conlai);
	}

	public List<Sach> getSearchChoUser(String keyword) {
		return sachDAO.getSearchChoUser(keyword);
	}

	public Long getSoLuongSach() {
		return sachDAO.getSoLuongSach();
	}

	public Sach getSachFromMaSach(String maSach) {
		return sachDAO.getSachFromMaSach(maSach);
	}

	public int editSach(Sach sach) {
		return sachDAO.editSach(sach);
	}

}
