package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.HocPhan;
import model.SinhVien;
import view.QLSVView;

public class QLSVController implements Action{

	public QLSVView view;
	
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Đã " + cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if (cm.equals("Sửa")) {
			this.view.hienThiThongTinSinhVienDaChon();
		}else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();
		}else if (cm.equals("Hủy Bỏ")) {
			this.view.xoaForm();
		}else if (cm.equals("Tìm Kiếm")) {
			this.view.thucHiemTim();
		}else if (cm.equals("Hủy Tìm")) {
			this.view.thucHienTaiLaiDuLieu();
		}else if (cm.equals("About me")) {
			this.view.hienThiABoutMe();
		}else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if (cm.equals("Open")) {
			this.view.thucHienOpen();
		}else if (cm.equals("Save")) {
			this.view.thucHienSave();
		}
				
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
