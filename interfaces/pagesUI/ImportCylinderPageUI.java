package pagesUI;

public class ImportCylinderPageUI {
	public static final String UPLOADFILE_BUTTON = "//div[@id='import-modal']//div//div//div//form//div//div//div//div//div//input[@name='upload_file']";
	public static final String IMPORTCYLINDER_BUTTON = "//button[@class='btn btn-sm btn-create kiemdinh']";
	public static final String CONTINUE_BUTTON = "//div[@id='import-modal']//div//div//div//button[contains(text(),'Tiếp tục')]";
	public static final String CLOSE_BUTTON = "//div[@id='import-modal']//div//div//div//button[contains(text(),'Đóng')]";
	public static final String DRIVER_DROPDOWN = "//body/div[@id='root']/div/main[@id='mainContent']/div/div[@id='import-driver']/div/div/div/form/div/div/div/div/div/div[1]";
	public static final String DRIVER_001 = "//li[contains(text(),'Tài xế 001')]";
	public static final String LICENSEPLATE_TEXTBOX = "//div[@id='import-driver']//div//div//div//form//div//div//div//div//div//input[@id='license_plate']";
	public static final String SAVE_BUTTON = "//div[@id='import-driver']//div//div//div//button[contains(text(),'Lưu')]";
	public static final String SUCCESS_MESSAGE = "//div[contains(text(),'Nhập hàng thành công!')]";
	public static final String NOTIFICATION_EMPTY_MESSAGE = "//label[contains(text(),'Empty request cylinder_serials, cylinder_serials must be id array')]";
	public static final String CANNOT_FOUND_MESSAGE = "//div[@class='text']";
	public static final String NOTIFICATION_STATUS_MESSAGE = "//label[contains(text(),'Những mã này chưa xuất nên không thể nhập :')]";
}

