package model;

import java.util.ArrayList;

public class QLSVmodel {
	private ArrayList<SinhVien> dsSinhVien;
	private String luaChon;
	private String tenFile;

	public QLSVmodel() {
		this.dsSinhVien = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public QLSVmodel(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public void insert(SinhVien sinhVien) {
		this.dsSinhVien.add(sinhVien);
	}
	
	public void delete(SinhVien sinhVien) {
		this.dsSinhVien.remove(sinhVien);
	}
	
	public void update(SinhVien sinhVien) {
		this.dsSinhVien.remove(sinhVien);
		this.dsSinhVien.add(sinhVien);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		for (SinhVien sinhVien : dsSinhVien) {
			if (sinhVien.getMsv() == sv.getMsv())
				return true;
		}
		return false;
	}

	

	
	
}
