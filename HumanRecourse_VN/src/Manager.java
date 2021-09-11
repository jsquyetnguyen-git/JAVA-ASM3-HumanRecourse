
public class Manager extends Staff implements ICalculator {
	private String chucDanh;

	public Manager(int maNhanVien, String tenNhanVien, int tuoi, String boPhan, String chucDanh,
			String ngayVaoLam, double ngayPhep, double heSoLuong) {
		super(maNhanVien, tenNhanVien, tuoi, boPhan, ngayVaoLam, ngayPhep, heSoLuong);
		this.chucDanh = chucDanh;

	}

	public String getChucDanh() {
		return chucDanh;
	}

	@Override
	public void displayInformation() {
		System.out.println(String.format("|%03d|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", super.getMaNhanVien(),
				super.getTenNhanVien(), super.getTuoi(), super.getBoPhan(), getChucDanh(), super.getNgayVaoLam(), super.getNgayPhep(), "-",
				super.getHeSoLuong(),(int)calculateSalary()));
	}

	@Override
	public double calculateSalary() {
		int luongTrachNhiem = 0;
		if (getChucDanh().equals("Business Leader")) {
			luongTrachNhiem = 8000000;
		} else if (getChucDanh().equals("Project Leader")) {
			luongTrachNhiem = 5000000;
		} else if (getChucDanh().equals("Technical Leader")) {
			luongTrachNhiem = 6000000;
		}

		return super.getHeSoLuong() * 5000000 + luongTrachNhiem;
	}


}
