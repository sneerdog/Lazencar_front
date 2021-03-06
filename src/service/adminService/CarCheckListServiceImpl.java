package service.adminService;

import java.util.List;

import dao.adminDao.CarCheckListDao;
import dao.adminDao.CarCheckListDaoImpl;
import util.Paging;
import dto.adminDto.CarManage;

public class CarCheckListServiceImpl implements CarCheckListService {
	CarCheckListDao dao = new CarCheckListDaoImpl();

	@Override
	public List getCarList(Paging paging, CarManage cm) {
		return dao.getList(paging, cm);
	}

	@Override
	public void editCarData(CarManage cm) {
		if(cm.getEditCar().equals("updateCar")) {
			dao.updateCar(cm);
		}else if(cm.getEditCar().equals("deleteCar")) {
			dao.deleteCar(cm);
		}
	}
}

