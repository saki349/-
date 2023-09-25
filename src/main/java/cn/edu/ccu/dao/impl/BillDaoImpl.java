package cn.edu.ccu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccu.dao.BillDao;
import cn.edu.ccu.domain.Bill;
import cn.edu.ccu.utils.DatabaseUtil;

public class BillDaoImpl implements BillDao{


	public List<Bill> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from smbms_bill";
		List<Bill> list = new ArrayList<Bill>();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = DatabaseUtil.querySQL(pstmt, sql, null);
			

			while(rs.next()) {
				Bill bill = new Bill();
				
				bill.setId(rs.getLong("id"));
				bill.setBillCode(rs.getString("billCode"));
				bill.setProductName(rs.getString("productName"));
				bill.setProductDesc(rs.getString("productDesc"));
				bill.setProductUnit(rs.getString("productUnit"));
				bill.setProductCount(rs.getLong("productCount"));
				bill.setTotalPrice(rs.getLong("totalPrice"));
				bill.setIsPayment(rs.getInt("isPayment"));
				bill.setCreateBy(rs.getLong("createBy"));
				bill.setCreationDate(rs.getDate("creationDate"));
				bill.setModifyBy(rs.getLong("modifyBy"));
				bill.setModifyDate(rs.getDate("modifyDate"));
				list.add(bill);
			}
			
			DatabaseUtil.closeAll(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Bill> selectListByProductname(String productname) {
		String sql="select * from smbms_bill where productName like ?;";
		String like="%"+productname+"%";
		List<Bill> list=new ArrayList<Bill>();
		try{
			Connection conn=DatabaseUtil.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=DatabaseUtil.querySQL(pstmt,sql,new String[]{like});
			while (rs.next()){
				Bill bill = new Bill();
				bill.setId(rs.getLong("id"));
				bill.setBillCode(rs.getString("billCode"));
				bill.setProductName(rs.getString("productName"));
				bill.setProductDesc(rs.getString("productDesc"));
				bill.setProductUnit(rs.getString("productUnit"));
				bill.setProductCount(rs.getLong("productCount"));
				bill.setTotalPrice(rs.getLong("totalPrice"));
				bill.setIsPayment(rs.getInt("isPayment"));
				bill.setCreateBy(rs.getLong("createBy"));
				bill.setCreationDate(rs.getDate("creationDate"));
				bill.setModifyBy(rs.getLong("modifyBy"));
				bill.setModifyDate(rs.getDate("modifyDate"));
				list.add(bill);
			}
			DatabaseUtil.closeAll(conn,pstmt,rs);
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public int insertBill(Bill bill) {
		String sql="insert into smbms_bill(billCode,productName,productDesc,productUnit,productCount,totalPrice,isPayment,creationDate,modifyDate) value(?,?,?,?,?,?,?,?,?);";
		int rows=0;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String creationDate = format.format(bill.getCreationDate());
		String modifyDate = format.format(bill.getModifyDate());

		try {
			rows=DatabaseUtil.executeSQL(sql,new Object[]{
				bill.getBillCode(),
				bill.getProductName(),
				bill.getProductDesc(),
				bill.getProductUnit(),
				bill.getProductCount(),
				bill.getTotalPrice(),
				bill.getIsPayment(),
				creationDate,
				modifyDate
			});
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return rows;
	}

	public int updateBill(Bill bill) {
		String sql="Updata smbms_bill set billCode=?,productName=?,productDesc=?,productUnit=?,productCount=?,totalPrice=?,isPayment=?,modifyBy=?,modifyDate=? where id=?;";
		int rows=0;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String modifyDate = format.format(bill.getModifyDate());
		try{
			rows=DatabaseUtil.executeSQL(sql,new Object[]{
					bill.getBillCode(),
					bill.getProductName(),
					bill.getProductDesc(),
					bill.getProductUnit(),
					bill.getProductCount(),
					bill.getTotalPrice(),
					bill.getIsPayment(),
					bill.getModifyBy(),
					modifyDate
			});
		}catch (SQLException e){
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return rows;
	}

	public int deleteBill(Long id) {
		String sql="delete from smbms_bill where id=?;";
		int rows=0;
		try {
			rows=DatabaseUtil.executeSQL(sql,new Long[]{id});
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return rows;
	}

	public Bill selectBillById(Long id) {
		String sql="select * from smbms_bill where id=?;";
		Bill bill=null;
		try {
			Connection conn=DatabaseUtil.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=DatabaseUtil.querySQL(pstmt,sql,new Long[]{id});
			while (rs.next()){
				bill = new Bill();
				bill.setId(rs.getLong("id"));
				bill.setBillCode(rs.getString("billCode"));
				bill.setProductName(rs.getString("productName"));
				bill.setProductDesc(rs.getString("productDesc"));
				bill.setProductUnit(rs.getString("productUnit"));
				bill.setProductCount(rs.getLong("productCount"));
				bill.setTotalPrice(rs.getLong("totalPrice"));
				bill.setIsPayment(rs.getInt("isPayment"));
				bill.setCreateBy(rs.getLong("createBy"));
				bill.setCreationDate(rs.getDate("creationDate"));
				bill.setModifyBy(rs.getLong("modifyBy"));
				bill.setModifyDate(rs.getDate("modifyDate"));
			}
			DatabaseUtil.closeAll(conn,pstmt,rs);
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return bill;
	}

}











