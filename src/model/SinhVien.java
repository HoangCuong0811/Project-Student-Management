package model;

import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Serializable{
	
	private int stt;
	private int msv;
	private String ten;
	private HocPhan hocPhan;
	private float diemTB;
	
	public SinhVien(){
	}
	
	public SinhVien(int stt, int msv, String ten, HocPhan hocPhan, float diemTB) {
		this.stt = stt;
		this.msv = msv;
		this.ten = ten;
		this.hocPhan = hocPhan;
		this.diemTB = diemTB;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public int getMsv() {
		return msv;
	}

	public void setMsv(int msv) {
		this.msv = msv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public HocPhan getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(HocPhan hocPhan) {
		this.hocPhan = hocPhan;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "SinhVien [stt=" + stt + ", msv=" + msv + ", ten=" + ten + ", hocPhan=" + hocPhan + ", diemTB=" + diemTB
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemTB, hocPhan, msv, stt, ten);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Float.floatToIntBits(diemTB) == Float.floatToIntBits(other.diemTB)
				&& Objects.equals(hocPhan, other.hocPhan) && msv == other.msv && stt == other.stt
				&& Objects.equals(ten, other.ten);
	}
	
	
	
	
}
