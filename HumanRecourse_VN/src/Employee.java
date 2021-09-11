public class Employee extends Staff implements ICalculator {
	private int gioLamThem;

	public Employee(int maNhanVien, String tenNhanVien, int tuoi, String boPhan, int gioLamThem,
			String ngayVaoLam, double ngayPhep,double heSoLuong) {
		super(maNhanVien, tenNhanVien, tuoi, boPhan, ngayVaoLam, ngayPhep, heSoLuong);
		this.gioLamThem = gioLamThem;
	}

	public void setGioLamThem(int gioLamThem) {
		this.gioLamThem = gioLamThem;
	}

	public int getGioLamThem() {
		return gioLamThem;
	}

	@Override
	public void displayInformation() {
		System.out.println(String.format("|%03d|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", super.getMaNhanVien(),
				super.getTenNhanVien(), super.getTuoi(), super.getBoPhan(), "Nhan Vien", super.getNgayVaoLam(), super.getNgayPhep(), getGioLamThem(),
				super.getHeSoLuong(),(int)calculateSalary()));
	}

	@Override
	public double calculateSalary() {
		return getHeSoLuong() * 3000000 + this.getGioLamThem() * 200000;
	}
	
}
