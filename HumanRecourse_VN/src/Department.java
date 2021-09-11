
public class Department {
	int maBoPhan;
	int soNhanVien;
	String tenBoPhan;

	public Department(int maBoPhan, String tenBoPhan, int soNhanVien) {
		this.maBoPhan = maBoPhan;
		this.tenBoPhan = tenBoPhan;
		this.soNhanVien = soNhanVien;
	}

	public int getMaBoPhan() {
		return maBoPhan;
	}

	public void setMaBoPhan(int maBoPhan) {
		this.maBoPhan = maBoPhan;
	}

	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	public String getTenBoPhan() {
		return tenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}

	public String toString() {
		return String.format("|%5s|%20s|%13s|", maBoPhan, tenBoPhan, soNhanVien);
	}

}
