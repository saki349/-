package cn.edu.ccu.service;

import cn.edu.ccu.domain.Bill;

import java.util.List;

public interface IBillService {

    public List<Bill> selectAll();

    public List<Bill> selectBillByProductname(String productname);

    public Bill selectBillById(Long id);

    public Boolean insertBill(Bill bill);

    public Boolean updateBill(Bill bill);

    public Boolean deleteBill(Long id);
}
