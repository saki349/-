package cn.edu.ccu.dao;

import java.util.List;

import cn.edu.ccu.domain.Bill;

public interface BillDao {

	public List<Bill> selectAll();

	public List<Bill> selectListByProductname(String productname);

	public int insertBill(Bill bill);

	public int updateBill(Bill bill);

	public int deleteBill(Long id);

	public Bill selectBillById(Long id);
}
