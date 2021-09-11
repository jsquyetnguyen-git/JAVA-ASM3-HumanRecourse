import java.util.Scanner;

public abstract class Staff implements ICalculator {
	private int maNhanVien;
	private String tenNhanVien;
	private int tuoi;
	private double heSoLuong;
	private String boPhan;
	private String ngayVaoLam;
	private double ngayPhep;
	Scanner cs = new Scanner(System.in);

	public Staff(int maNhanVien, String tenNhanVien, int tuoi, String boPhan, String ngayVaoLam, double ngayPhep,
			double heSoLuong) {
		this.tenNhanVien = tenNhanVien;
		this.maNhanVien = maNhanVien;
		this.tuoi = tuoi;
		this.heSoLuong = heSoLuong;
		this.boPhan = boPhan;
		this.ngayVaoLam = ngayVaoLam;
		this.ngayPhep = ngayPhep;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(String ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public double getNgayPhep() {
		return ngayPhep;
	}

	public void setNgayPhep(double ngayPhep) {
		this.ngayPhep = ngayPhep;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public String getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(String boPhan) {
		this.boPhan = boPhan;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public abstract void displayInformation();
	public void bangLuong() {
		System.out.println(String.format("|%03d|%20s|%18s|%11s|%13s VND|", getMaNhanVien(),
				getTenNhanVien(), getBoPhan(),getHeSoLuong(),(int)calculateSalary()));
	}
	
}
