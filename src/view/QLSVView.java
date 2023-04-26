package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import model.HocPhan;
import model.QLSVmodel;
import model.SinhVien;

public class QLSVView extends JFrame {
	
	public QLSVmodel model;
	public JTextField textField_timMSV;
	public JTextField textField_timDiemTB;
	public JTable table;
	public JTextField textField_stt;
	public JTextField textField_msv;
	public JTextField textField_hoten;
	public JTextField textField_diemTB;
	public JComboBox comboBox_dangKyHocPhan;
	public JComboBox comboBox_timHocPhan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVmodel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 747);
		
		Action action = new QLSVController(this);	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);
		getContentPane().setLayout(null);
		
		JLabel label_hocPhan = new JLabel("Học Phần ");
		label_hocPhan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_hocPhan.setBounds(10, 15, 99, 52);
		getContentPane().add(label_hocPhan);
		
		JLabel label_msv = new JLabel("MSV");
		label_msv.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_msv.setBounds(299, 15, 54, 52);
		getContentPane().add(label_msv);
		
		JLabel label_diemTB = new JLabel("Điểm Trung Bình ");
		label_diemTB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_diemTB.setBounds(559, 23, 149, 37);
		getContentPane().add(label_diemTB);
		
		textField_timMSV = new JTextField();
		textField_timMSV.setColumns(10);
		textField_timMSV.setBounds(347, 23, 160, 35);
		getContentPane().add(textField_timMSV);
		
		textField_timDiemTB = new JTextField();
		textField_timDiemTB.setBounds(718, 23, 80, 35);
		getContentPane().add(textField_timDiemTB);
		textField_timDiemTB.setColumns(10);
		
		JButton button_timKiem = new JButton("Tìm Kiếm");
		button_timKiem.addActionListener(action);
		button_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_timKiem.setBounds(888, 10, 115, 35);
		getContentPane().add(button_timKiem);
		
		comboBox_timHocPhan = new JComboBox();
		ArrayList<HocPhan> listHocPhan = HocPhan.getDSHocPhan();
		comboBox_timHocPhan.addItem("");
		for(HocPhan hocphan : listHocPhan) {
			comboBox_timHocPhan.addItem(hocphan.getTenHocPhan());
		}
		comboBox_timHocPhan.setBounds(100, 23, 160, 35);
		getContentPane().add(comboBox_timHocPhan);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 100, 1046, 2);
		getContentPane().add(separator_1);
		
		JLabel label_DanhSachSinhVien = new JLabel("Danh Sách Sinh Viên");
		label_DanhSachSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_DanhSachSinhVien.setBounds(10, 92, 218, 52);
		getContentPane().add(label_DanhSachSinhVien);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 Sinh Vi\u00EAn", "H\u1ECD T\u00EAn", "\u0110i\u1EC3m Trung B\u00ECnh", "H\u1ECDc ph\u1EA7n \u0111\u0103ng k\u00ED"
			}
		));
		table.setRowHeight(25);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 1036, 165);
		getContentPane().add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 319, 1046, 2);
		getContentPane().add(separator_1_1);
		
		JLabel label_ThongTinSinhVien = new JLabel("Thông Tin Sinh Viên");
		label_ThongTinSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ThongTinSinhVien.setBounds(10, 313, 218, 52);
		getContentPane().add(label_ThongTinSinhVien);
		
		JLabel label_stt = new JLabel("STT");
		label_stt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_stt.setBounds(10, 375, 99, 52);
		getContentPane().add(label_stt);
		
		JLabel label_msv_2 = new JLabel("MSV");
		label_msv_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_msv_2.setBounds(10, 437, 99, 52);
		getContentPane().add(label_msv_2);
		
		JLabel label_hoTen = new JLabel("Họ Tên");
		label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_hoTen.setBounds(10, 515, 99, 52);
		getContentPane().add(label_hoTen);
		
		JLabel label_diemTB_1 = new JLabel("Điểm Trung Bình");
		label_diemTB_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_diemTB_1.setBounds(337, 388, 187, 52);
		getContentPane().add(label_diemTB_1);
		
		textField_stt = new JTextField();
		textField_stt.setColumns(10);
		textField_stt.setBounds(86, 388, 160, 35);
		getContentPane().add(textField_stt);
		
		textField_msv = new JTextField();
		textField_msv.setColumns(10);
		textField_msv.setBounds(86, 454, 160, 35);
		getContentPane().add(textField_msv);
		
		textField_hoten = new JTextField();
		textField_hoten.setColumns(10);
		textField_hoten.setBounds(86, 515, 160, 35);
		getContentPane().add(textField_hoten);
		
		textField_diemTB = new JTextField();
		textField_diemTB.setColumns(10);
		textField_diemTB.setBounds(504, 390, 160, 35);
		getContentPane().add(textField_diemTB);
		
		JLabel label_DangKyHocPhan = new JLabel("Đăng Ký Học Phần");
		label_DangKyHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_DangKyHocPhan.setBounds(337, 450, 170, 52);
		getContentPane().add(label_DangKyHocPhan);
		
		comboBox_dangKyHocPhan = new JComboBox();
		comboBox_dangKyHocPhan.addItem("");
		for(HocPhan hocphan : listHocPhan) {
			comboBox_dangKyHocPhan.addItem(hocphan.getTenHocPhan());
		}
		comboBox_dangKyHocPhan.setBounds(504, 463, 160, 35);
		getContentPane().add(comboBox_dangKyHocPhan);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 577, 1046, 2);
		getContentPane().add(separator_1_1_1);
		
		JButton button_them = new JButton("Thêm");
		button_them.addActionListener(action);
		button_them.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_them.setBounds(10, 602, 131, 37);
		getContentPane().add(button_them);
		
		JButton button_sua = new JButton("Sửa");
		button_sua.addActionListener(action);
		button_sua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_sua.setBounds(221, 602, 131, 37);
		getContentPane().add(button_sua);
		
		JButton button_xoa = new JButton("Xóa");
		button_xoa.addActionListener(action);
		button_xoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_xoa.setBounds(451, 602, 131, 37);
		getContentPane().add(button_xoa);
		
		JButton button_luu = new JButton("Lưu");
		button_luu.addActionListener(action);
		button_luu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_luu.setBounds(687, 602, 131, 37);
		getContentPane().add(button_luu);
		
		JButton button_huyBo = new JButton("Hủy Bỏ");
		button_huyBo.addActionListener(action);
		button_huyBo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_huyBo.setBounds(890, 602, 131, 37);
		getContentPane().add(button_huyBo);
		
		JButton button_huyTim = new JButton("Hủy Tìm");
		button_huyTim.addActionListener(action);
		button_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_huyTim.setBounds(888, 55, 115, 35);
		getContentPane().add(button_huyTim);
		
		this.setVisible(true);
	}

	// xoa cac form thong tin dang co san 
	public void xoaForm() {
		textField_stt.setText("");
		textField_msv.setText("");
		textField_hoten.setText("");
		textField_diemTB.setText("");
		comboBox_dangKyHocPhan.setSelectedIndex(-1);
	}
	
	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				sv.getStt()+"",
				sv.getMsv()+"",
				sv.getTen(),
				sv.getDiemTB()+"",
				sv.getHocPhan().getTenHocPhan()
				});
	}

	public void themHoacCapNhatSinhVien(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
			this.themSinhVienVaoTable(sv);
		} else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 1)+"";
				if (id.equals(sv.getMsv()+"")) {
					model_table.setValueAt(sv.getStt()+"", i, 0);
					model_table.setValueAt(sv.getMsv()+"", i, 1);
					model_table.setValueAt(sv.getTen()+"", i, 2);
					model_table.setValueAt(sv.getDiemTB()+"", i, 3);
					model_table.setValueAt(sv.getHocPhan().getTenHocPhan(), i, 4);
				}
			}
		}
	}
	
	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int stt = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		int msv = Integer.valueOf(model_table.getValueAt(i_row, 1)+"");
		String ten = model_table.getValueAt(i_row, 2)+"";
		float diemTB = Float.valueOf(model_table.getValueAt(i_row, 3)+"");
		HocPhan hocPhan = HocPhan.getHocPhanByTen(model_table.getValueAt(i_row, 4));

		this.textField_stt.setText(stt+"");
		this.textField_msv.setText(msv+"");
		this.textField_hoten.setText(ten+"");
		this.textField_diemTB.setText(diemTB+"");
		this.comboBox_dangKyHocPhan.setSelectedItem(hocPhan.getTenHocPhan());
		
		SinhVien sv = new SinhVien(stt, msv, ten, hocPhan, diemTB);
		return sv;
	}
	
	public void hienThiThongTinSinhVienDaChon() {
		SinhVien sv = getSinhVienDangChon();
		
		this.textField_stt.setText(sv.getStt()+"");
		this.textField_msv.setText(sv.getMsv()+"");
		this.textField_hoten.setText(sv.getTen()+"");
		this.textField_diemTB.setText(sv.getDiemTB()+"");
		this.comboBox_dangKyHocPhan.setSelectedItem(sv.getHocPhan().getTenHocPhan());
		
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa");
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVienDangChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThem() {
		int stt = Integer.valueOf(this.textField_stt.getText());
		int msv = Integer.valueOf(this.textField_msv.getText());
		String ten = this.textField_hoten.getText();
		int hocPhan = this.comboBox_dangKyHocPhan.getSelectedIndex()-1;
		HocPhan monHoc = HocPhan.getHocPhanById(hocPhan);
		float diemTB = Float.valueOf(this.textField_diemTB.getText());
		
		SinhVien sv = new SinhVien(stt, msv, ten, monHoc, diemTB);
		this.themHoacCapNhatSinhVien(sv);

		
	}

	public void thucHiemTim() {
		// goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		// thuc hien tim kiem
		int hocPhan = this.comboBox_timHocPhan.getSelectedIndex() - 1;
		String maSinhVienTimKiem = this.textField_timMSV.getText();
		String diemSinhVienTimKiem = this.textField_timDiemTB.getText();
		
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<Integer>();
		
		if (hocPhan >= 0) {
			HocPhan hocPhanDaChon = HocPhan.getHocPhanById(hocPhan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenHocPhan = model_table.getValueAt(i, 4)+"";
				String id = model_table.getValueAt(i, 1)+"";
				if (!tenHocPhan.equals(hocPhanDaChon.getTenHocPhan())) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}	
			}
		}
		if(maSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 1)+"";
				if (!id.equals(maSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}	
			}
		}
		if(diemSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 1)+"";
				String diemTB = model_table.getValueAt(i, 3)+"";
				if(Float.valueOf(diemTB) < Float.valueOf(diemSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 1)+ "";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}	
					break;
				}
			}
		}
	}

	
	public void thucHienTaiLaiDuLieu() {
//		comboBox_timHocPhan.setSelectedIndex(-1);
//		textField_timMSV.setText("");
//		textField_timDiemTB.setText("");
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong == 0) {
				break;
			} else 
				try {
					model_table.removeRow(0);

				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for(SinhVien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
		
		
	}

	public void hienThiABoutMe() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý sinh viên");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this,
				"Bạn có muốn thoát khỏi chương trình ?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSave() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	public void openFile(File file) {
		ArrayList <SinhVien> ds = new ArrayList<SinhVien>();

		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!= null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsSinhVien(ds);
	}
	
	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}
}
