package cn.edu.ccu.service.impl;

import cn.edu.ccu.dao.BillDao;
import cn.edu.ccu.dao.impl.BillDaoImpl;
import cn.edu.ccu.domain.Bill;
import cn.edu.ccu.service.IBillService;

import java.util.List;

public class BillServiceImpl implements IBillService {
    @Override
    public List<Bill> selectAll() {
        BillDao bill=new BillDaoImpl();
        return bill.selectAll();
    }

    @Override
    public List<Bill> selectBillByProductname(String productname) {
        BillDao billDao=new BillDaoImpl();
        return billDao.selectListByProductname(productname);
    }

    @Override
    public Bill selectBillById(Long id) {
        BillDao billDao=new BillDaoImpl();
        return billDao.selectBillById(id);
    }

    @Override
    public Boolean insertBill(Bill bill) {
        BillDao billDao=new BillDaoImpl();
        return billDao.insertBill(bill)>0?true:false;
    }

    @Override
    public Boolean updateBill(Bill bill) {
        BillDao billDao=new BillDaoImpl();
        return billDao.updateBill(bill)>0?true:false;
    }

    @Override
    public Boolean deleteBill(Long id) {
        BillDao billDao=new BillDaoImpl();
        return billDao.deleteBill(id)>0?true:false;
    }
}
