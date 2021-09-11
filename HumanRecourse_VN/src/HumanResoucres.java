import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResoucres {
	static Scanner cs = new Scanner(System.in);
	static ArrayList<Staff> arrNhanVien = new ArrayList<Staff>();
	static ArrayList<Department> arrPhongBan = new ArrayList<Department>();

	public static void main(String[] args) {
		int menuId = 0, temp;
		boolean tiepTuc = false;
		testData();
		phongBan();

		// Loop menu
		do {
			showMenu();
			menuId = cs.nextInt();
			switch (menuId) {
			case 1: {
				// Them nhan vien moi
				themNhanVien();
				break;
			}
			case 2: {
				// Danh sach nhan vien toan cong ty
				hienThiToanBoNhanVien();
				break;
			}
			case 3: {
				// Danh sach phong ban trong cong ty
				hienThiPhongBan();
				break;
			}
			case 4: {
				// Nhan vien theo bo phan
				nhanVienTheoBoPhan();
				break;
			}
			case 5: {
				// Tim kiem nhan vien
				timKiemNhanVien();
				break;
			}
			case 6: {
				// Bang luong nhan vien toan cong ty
				showBangLuong();
				break;
			}
			case 7: {
				// Bang luong tang dan
				showBangLuongTangDan();
				break;
			}
			case 8: {
				// Bang luong giam dan
				showBangLuongGiamDan();
				break;
			}
			case 9: {
				// Xoa nhan vien
				xoaNhanVien();
				break;
			}
			case 10: {
				System.out.println("DA THOAT CHUONG TRINH!");
				System.exit(0);
			}
			default:
				System.out.println("SO NHAP VAO KHONG THICH HOP, HAY THU LAI!");
			}
			System.out.print("\nNHAP 1 DE HIEN THI MENU CHUC NANG, NHAP 2 DE KET THUC.");
			temp = cs.nextInt();
			if (temp == 1) {
				tiepTuc = true;
			} else {
				tiepTuc = false;
			}
		} while (tiepTuc);
		System.out.println("DA THOAT CHUONG TRINH!");
	}

	// du lieu ban dau de test chuc nang cua chuong trinh
	public static void testData() {
		arrNhanVien.add(new Employee(248, "NGUYEN VAN QUYET", 27, "PHONG NHAN SU", 12, "12/08/2019", 15.5, 2));
		arrNhanVien.add(new Employee(200, "NGUYEN VAN QUYET", 25, "PHONG NHAN SU", 12, "12/05/2017", 10, 1));
		arrNhanVien.add(new Employee(223, "TRAN THI THUY", 27, "PHONG KINH DOANH", 14, "12/08/2018", 12, 3));
		arrNhanVien.add(new Employee(169, "TRAN THANH MAN", 27, "PHONG KINH DOANH", 5, "12/08/2014", 5.5, 5));
		arrNhanVien.add(new Employee(242, "NGUYEN THI HIEN", 25, "PHONG MARKETING", 10, "12/08/2020", 15, 1));
		arrNhanVien.add(
				new Manager(357, "NGUYEN THI PHUONG", 35, "PHONG MARKETING", "Business Leader", "12/08/2015", 18, 4));
		arrNhanVien
				.add(new Manager(157, "TRAN THANH MAN", 27, "PHONG KINH DOANH", "Project Leader", "12/08/2014", 15, 5));

	}

	// Hien thi menu chuc nang
	static void showMenu() {

		System.out.println(
				"\n|----------------------------------------------------------------------------------------------------------|");
		System.out.println(
				"|*************************************** CHUONG TRINH QUAN LY NHAN VIEN ***********************************|");
		System.out.println(
				"|----------------------------------------------------------------------------------------------------------|");
		System.out.println(
				"| MENU:                                                                                                    |");
		System.out.println(
				"|       [1] THEM NHAN VIEN MOI                               [6] HIEN THI BANG LUONG NHAN VIEN             |");
		System.out.println(
				"|       [2] HIEN THI DANH SACH NHAN VIEN TOAN CONG TY        [7] HIEN THI BANG LUONG THEO THU TU TANG DAN  |");
		System.out.println(
				"|       [3] HIEN THI DANH SACH PHONG BAN                     [8] HIEN THI BANG LUONG THEO THU TU GIAM DAN  |");
		System.out.println(
				"|       [4] HIEN THI NHAN VIEN THEO BO PHAN                  [9] XOA NHAN VIEN                             |");
		System.out.println(
				"|       [5] TIM KIEM NHAN VIEN                               [10]THOAT CHUONG TRINH                       |");
		System.out.println(
				"|__________________________________________________________________________________________________________|");
		System.out.print("\n>> NHAP SO TUONG UNG VOI CHUC NANG: ");
	}

	// Hien thi danh sach nhan vien toan cong ty
	public static void hienThiToanBoNhanVien() {
		System.out.println("\n\n                                           ****DANH SACH NHAN VIEN TOAN CONG TY****");
		showTable();
		for (Staff nv : arrNhanVien) {
			nv.displayInformation();
		}
		System.out.println(
				"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
	}

	// Hien thi cac phong ban co trong cong ty
	public static void hienThiPhongBan() {
		System.out.println("\n *DANH SACH CAC PHONG BAN TRONG CONG TY*");
		System.out.println("|________________________________________|");
		System.out.println(String.format("|%5s|%20s|%13s|", "ID", "TEN PHONG BAN", "SO NHAN VIEN"));
		System.out.println("|----------------------------------------|");
		for (Department pb : arrPhongBan)
			System.out.println(pb.toString());
		System.out.println("|________________________________________|");
	}

	// Them nhan vien moi
	public static void themNhanVien() {
		int temp = 0;
		System.out.print("NHAP SO LUONG NHAN VIEN MUON THEM MOI: ");
		temp = cs.nextInt();
		for (int i = 0; i < temp; i++) {

			int loaiNV;
			System.out.print("NHAP 1 DE THEM NHAN VIEN, NHAP 2 DE THEM QUAN LY: ");
			loaiNV = cs.nextInt();

			switch (loaiNV) {
			case 1: {

				System.out.print("MA NHAN VIEN (000-999): ");
				int maNhanVien = idCheck();

				System.out.print("TEN: ");
				cs.nextLine();
				String tenNhanVien = cs.nextLine().toUpperCase();

				System.out.print("TUOI: ");
				int tuoi = intValidCheck();

				// Chon bo phan
				boolean boPhanNhanVienHopLe;
				String boPhan = "";
				do {
					System.out.print("CHON BO PHAN (1 = PHONG NHAN SU | 2 = PHONG KINH DOANH | 3 = PHONG MARKETING): ");
					int temp0 = cs.nextInt();
					boPhanNhanVienHopLe = false;
					switch (temp0) {
					case 1: {
						boPhan = "PHONG NHAN SU";
						arrPhongBan.get(0).setSoNhanVien(arrPhongBan.get(0).getSoNhanVien() + 1);
						break;
					}
					case 2: {
						boPhan = "PHONG KINH DOANH";
						arrPhongBan.get(1).setSoNhanVien(arrPhongBan.get(1).getSoNhanVien() + 1);
						break;
					}
					case 3: {
						boPhan = "PHONG MARKETING";
						arrPhongBan.get(2).setSoNhanVien(arrPhongBan.get(2).getSoNhanVien() + 1);
						break;
					}
					default:
						System.out.println("SO NHAP VAO KHONG THICH HOP, HAY THU LAI!");
						boPhanNhanVienHopLe = true;
					}
				} while (boPhanNhanVienHopLe);

				System.out.print("GIO LAM THEM: ");
				int gioLamThem = intValidCheck();

				System.out.print("NGAY VAO LAM (dd/mm/yyy): ");
				String ngayVaoLam = cs.next();

				System.out.print("SO NGAY PHEP: ");
				double ngayPhep = positiveValueCheck();

				System.out.print("HE SO LUONG: ");
				double heSoLuong = positiveValueCheck();

				arrNhanVien.add(new Employee(maNhanVien, tenNhanVien, tuoi, boPhan, gioLamThem, ngayVaoLam, ngayPhep,
						heSoLuong));
				System.out.println("DA THEM THANH CONG " + tenNhanVien + "\n");

				break;
			}

			case 2: {
				System.out.print("MA NHAN VIEN (000-999): ");
				int maNhanVien = idCheck();

				System.out.print("TEN: ");
				cs.nextLine();
				String tenNhanVien = cs.nextLine().toUpperCase();

				System.out.print("TUOI: ");
				int tuoi = intValidCheck();

				String boPhan = "";
				boolean boPhanQuanLyHopLe;

				do {
					System.out.print("CHON BO PHAN (1 = PHONG NHAN SU | 2 = PHONG KINH DOANH | 3 = PHONG MARKETING): ");
					int temp0 = cs.nextInt();
					boPhanQuanLyHopLe = false;
					switch (temp0) {
					case 1: {
						boPhan = "PHONG NHAN SU";
						arrPhongBan.get(0).setSoNhanVien(arrPhongBan.get(0).getSoNhanVien() + 1);
						break;
					}
					case 2: {
						boPhan = "PHONG KINH DOANH";
						arrPhongBan.get(1).setSoNhanVien(arrPhongBan.get(1).getSoNhanVien() + 1);
						break;
					}
					case 3: {
						boPhan = "PHONG MARKETING";
						arrPhongBan.get(2).setSoNhanVien(arrPhongBan.get(2).getSoNhanVien() + 1);
						break;
					}
					default:
						System.out.println("SO NHAP VAO KHONG THICH HOP, HAY THU LAI!");
						boPhanQuanLyHopLe = true;
					}
				} while (boPhanQuanLyHopLe);

				boolean chucDanhHopLe;
				String chucDanh = "";

				do {
					chucDanhHopLe = false;
					System.out.print(
							"CHON CHUC DANH (1 = Business Leader | 2 = Project Leader | 3 = Technical Leader): ");
					int temp1 = cs.nextInt();
					switch (temp1) {
					case 1: {
						chucDanh = "Business Leader";
						break;
					}
					case 2: {
						chucDanh = "Project Leader";
						break;
					}
					case 3: {
						chucDanh = "Technical Leader";
						break;
					}
					default:
						System.out.println("SO NHAP VAO KHONG THICH HOP, HAY THU LAI!");
						chucDanhHopLe = true;
					}
				} while (chucDanhHopLe);

				System.out.print("NGAY VAO LAM (dd/mm/yyy): ");
				String ngayVaoLam = cs.next();

				System.out.print("SO NGAY PHEP: ");
				double ngayPhep = positiveValueCheck();

				System.out.print("HE SO LUONG: ");
				double heSoLuong = positiveValueCheck();

				arrNhanVien.add(
						new Manager(maNhanVien, tenNhanVien, tuoi, boPhan, chucDanh, ngayVaoLam, ngayPhep, heSoLuong));
				System.out.println("DA THEM THANH CONG " + tenNhanVien + "\n");
				break;
			}
			}
		}
	}

	// Danh sach phong ban
	public static void phongBan() {
		int soLuongPhongNS = 0;
		for (int i = 0; i < arrNhanVien.size(); i++) {
			if (arrNhanVien.get(i).getBoPhan().equals("PHONG NHAN SU"))
				soLuongPhongNS += 1;
		}

		int soLuongPhongKD = 0;
		for (int i = 0; i < arrNhanVien.size(); i++) {
			if (arrNhanVien.get(i).getBoPhan().equals("PHONG KINH DOANH"))
				soLuongPhongKD += 1;
		}

		int soLuongPhongMK = 0;
		for (int i = 0; i < arrNhanVien.size(); i++) {
			if (arrNhanVien.get(i).getBoPhan().equals("PHONG MARKETING"))
				soLuongPhongMK += 1;
		}

		Department pB1 = new Department(001, "PHONG NHAN SU", soLuongPhongNS);
		Department pB2 = new Department(002, "PHONG KINH DOANH", soLuongPhongKD);
		Department pB3 = new Department(003, "PHONG MARKETING", soLuongPhongMK);

		arrPhongBan.add(pB1);
		arrPhongBan.add(pB2);
		arrPhongBan.add(pB3);
	}

	// Hien thi nhan vien theo bo ban
	public static void nhanVienTheoBoPhan() {

		for (Department bp : arrPhongBan) {
			String tenBoPhan = bp.getTenBoPhan();
			System.out.println(
					"\n\n                                                ***DANH SACH NHAN VIEN " + tenBoPhan + "***");
			showTable();
			for (Staff nv : arrNhanVien) {
				if (nv.getBoPhan().equals(tenBoPhan)) {
					nv.displayInformation();
				}
			}
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");

		}
	}

	// Tim kiem nhan vien theo ten hoac theo ma nhan vien
	public static void timKiemNhanVien() {
		System.out.print("CHON PHUONG THUC TIM KIEM ( 1 - TIM KIEM THEO TEN | 2 - TIM KIEM THEO MA NHAN VIEN): ");
		int phuongThucTimKiem = cs.nextInt();
		switch (phuongThucTimKiem) {
		case 1: {
			// Tim kiem bang ten
			boolean khongTonTai = true;
			System.out.print("MOI NHAP VAO TEN: ");
			cs.nextLine();
			String input = cs.nextLine().toUpperCase();
			System.out.println("\n\n                                                     ***KET QUA TIM KIEM***");
			showTable();
			for (int i = 0; i < arrNhanVien.size(); i++) {
				if (input.equals(arrNhanVien.get(i).getTenNhanVien())) {
					khongTonTai = false;
					arrNhanVien.get(i).displayInformation();
				}
			}

			if (khongTonTai == true)
				System.out.println(" KHONG TIM THAY NHAN VIEN " + input);
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
			break;
		}
		case 2: {
			// Tim kiem bang ma nhan vien
			boolean khongTonTai = true;
			System.out.print("MOI NHAP VAO MA NHAN VIEN: ");
			int input = cs.nextInt();
			System.out.println("\n\n                                                     ***KET QUA TIM KIEM***");
			showTable();
			for (int i = 0; i < arrNhanVien.size(); i++) {
				if (input == arrNhanVien.get(i).getMaNhanVien()) {
					khongTonTai = false;
					arrNhanVien.get(i).displayInformation();
				}
			}
			if (khongTonTai == true)
				System.out.println(" KHONG TIM THAY NHAN VIEN CO MA " + input);
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
			break;
		}
		default:
			System.out.println("SO NHAP VAO KHONG THICH HOP, HAY THU LAI!");
		}
	}

	// Xoa nhan vien
	public static void xoaNhanVien() {
		System.out.print(" 1 - XOA MOT NHAN VIEN | 2 - XOA TOAN BO NHAN VIEN");
		int phuongThucXoa = cs.nextInt();

		switch (phuongThucXoa) {
		case 1: {
			//Xoa tung nhan vien theo ID
			System.out.print("NHAP VAO ID NHAN VIEN CAN XOA: ");
			int input = cs.nextInt();
			boolean khongTonTai = true;
			for (int i = 0; i < arrNhanVien.size(); i++) {
				if (input == arrNhanVien.get(i).getMaNhanVien()) {
					khongTonTai = false;
					System.out.println("  |-NHAN VIEN CO ID " + input + " LA: [" + arrNhanVien.get(i).getTenNhanVien()
							+ "] THUOC " + arrNhanVien.get(i).getBoPhan());
					System.out.print("  |-BAN CO CHAC MUON XOA? (1 - XOA | 2 - HUY BO)");
					int tem = cs.nextInt();
					if (tem == 1) {
						System.out.print("  XOA THANH CONG " + arrNhanVien.get(i).getTenNhanVien());
						arrNhanVien.remove(i);

						// Giam so luong nhan vien cua tung phong ban khi xoa
						for (Department pb : arrPhongBan) {
							pb.setSoNhanVien(pb.getSoNhanVien() - 1);
						}
						i = arrNhanVien.size();
					}

				}
			}
			if (khongTonTai == true)
				System.out.println("[!] KHONG THANH CONG! MA NHAN VIEN KHONG TON TAI.");
			break;
		}
		case 2: {
			//Xoa toan bo du lieu nhan vien toan cong ty
			System.out.print("  |-BAN CO CHAC MUON XOA? (1 - XOA | 2 - HUY BO)");
			int tem = cs.nextInt();
			if (tem == 1)
				arrNhanVien.clear();
				System.out.print("  XOA THANH CONG TOAN BO NHAN VIEN");
			break;
		}

		}

	}

	// Bang luong nhan vien toan cong ty
	public static void showBangLuong() {
		System.out.println("\n\n              ****BANG LUONG NHAN VIEN TOAN CONG TY****");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "TEN NHAN VIEN", "BO PHAN",
				"HE SO LUONG", "MUC LUONG"));
		System.out.println("|-------------------------------------------------------------------------|");
		for (Staff nv : arrNhanVien) {
			nv.bangLuong();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Sap xep theo luong tang dan
	public static void showBangLuongTangDan() {
		System.out.println("\n\n                ****BANG LUONG NHAN VIEN TANG DAN****");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "TEN NHAN VIEN", "BO PHAN",
				"HE SO LUONG", "MUC LUONG"));
		System.out.println("|-------------------------------------------------------------------------|");

		@SuppressWarnings("unchecked")
		ArrayList<Staff> cloneArr = (ArrayList<Staff>) arrNhanVien.clone();
		Collections.sort(cloneArr, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.calculateSalary() > o2.calculateSalary()) {
					return 1;
				}
				if (o1.calculateSalary() < o2.calculateSalary()) {
					return -1;
				} else {
					return 0;
				}
			}

		});

		for (Staff nv : cloneArr) {
			nv.bangLuong();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Sap xep theo luong giam dan
	public static void showBangLuongGiamDan() {
		System.out.println("\n\n                ****BANG LUONG NHAN VIEN GIAM DAN****");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "TEN NHAN VIEN", "BO PHAN",
				"HE SO LUONG", "MUC LUONG"));
		System.out.println("|-------------------------------------------------------------------------|");

		@SuppressWarnings("unchecked")
		ArrayList<Staff> cloneArr = (ArrayList<Staff>) arrNhanVien.clone();
		Collections.sort(cloneArr, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.calculateSalary() > o2.calculateSalary()) {
					return -1;
				}
				if (o1.calculateSalary() < o2.calculateSalary()) {
					return 1;
				} else {
					return 0;
				}
			}

		});

		for (Staff nv : cloneArr) {
			nv.bangLuong();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Form table
	static // show table
	void showTable() {
		System.out.println(
				"|-------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", "ID", "TEN NHAN VIEN",
				"TUOI", "BO PHAN", "CHUC DANH", "NGAY VAO LAM", "SO NGAY NGHI", "GIO LAM THEM", "HE SO LUONG",
				"MUC LUONG"));
		System.out.println(
				"|-------------------------------------------------------------------------------------------------------------------------------------------|");
	}

	// Kiem tra gia tri int nhap vao
	public static int intValidCheck() {
		boolean temp = false;
		int num = 0;
		do {
			num = cs.nextInt();
			if (num <= 0) {
				temp = true;
				System.out.println("SO NHAP VAO PHAI LA SO NGUYEN DUONG!");
				System.out.print("MOI NHAP LAI: ");
			} else {
				temp = false;
			}
		} while (temp);

		return num;
	}

	// Check so duong
	public static double positiveValueCheck() {
		boolean temp = false;
		double num = 0;
		do {
			num = cs.nextDouble();
			if (num <= 0) {
				System.out.println("SO NHAP VAO PHAI LON HON 0!");
				System.out.print("MOI NHAP LAI: ");
				temp = true;
			} else {
				temp = false;
			}
		} while (temp);
		return num;
	}

	// Check ma nhan vien nhap vao da ton tai chua
	public static int idCheck() {
		boolean temp = false;
		int input = 0;
		do {
			input = cs.nextInt();
			for (int i = 0; i < arrNhanVien.size(); i++) {
				if (input == arrNhanVien.get(i).getMaNhanVien()) {
					temp = true;
					System.out.println("MA NHAN VIEN DA TON TAI!");
					System.out.print("MOI NHAP MA NHAN VIEN KHAC: ");
					i = arrNhanVien.size();
				} else {
					temp = false;
				}
			}
		} while (temp);

		return input;
	}

}
