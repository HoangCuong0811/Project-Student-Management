package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class HocPhan implements Serializable {
	private String tenHocPhan;
	private int maHocPhan;
	
	
	public HocPhan(int maHocPhan, String tenHocPhan) {
		this.maHocPhan = maHocPhan;
		this.tenHocPhan = tenHocPhan;
	}
	

	public String getTenHocPhan() {
		return tenHocPhan;
	}
	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
	}
	public int getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(int maHocPhan) {
		this.maHocPhan = maHocPhan;
	}
	
	@Override
	public String toString() {
		return "HocPhan [tenHocPhan=" + tenHocPhan + ", maHocPhan=" + maHocPhan + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(maHocPhan, tenHocPhan);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocPhan other = (HocPhan) obj;
		return maHocPhan == other.maHocPhan && Objects.equals(tenHocPhan, other.tenHocPhan);
	}
	
	public static ArrayList<HocPhan> getDSHocPhan() {
		String[] arr_hocphan = {"Toán",
								"Văn",
								"Anh",
								"Lý", 
								"Hóa", 
								"Sinh",
								"Sử", 
								"Địa"};
		
		ArrayList<HocPhan> listHocPhan = new ArrayList <HocPhan>();
		int i = 0;
		for (String tenHocPhan : arr_hocphan) {
			HocPhan h = new HocPhan(i, tenHocPhan);
			listHocPhan.add(h);
		}
		return listHocPhan;
	}


	public static HocPhan getHocPhanById(int hocphan) {
		return HocPhan.getDSHocPhan().get(hocphan);
	}


	public static HocPhan getHocPhanByTen(Object tenHocPhan) {	
		ArrayList<HocPhan> listHocPhan = HocPhan.getDSHocPhan();
		for(HocPhan hocPhan : listHocPhan) {
			if(hocPhan.tenHocPhan.equals(tenHocPhan))
				return hocPhan;
		}
		return null;
	}
	
}
