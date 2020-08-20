package pagesUI;

public class ExportCylinderPageUI {
	public static final String EXPORT_CYLINDER_BUTTON = "//button[contains(text(),'Xuất hàng')]";
	public static final String UPLOADFILE_EXPORT_CYLINDER = "//div[@id='export-modal']//div//div//div//form//div//div//div//div//div//input[@name='upload_file']";
	public static final String CONTINUE_BUTTON = "//div[@id='export-modal']//div//div//div//button[contains(text(),'Tiếp tục')]";
	public static final String DRIVER_DROPDOWN = "//body/div[@id='root']/div/main[@id='mainContent']/div/div[@id='export-driver']/div/div/div/form/div/div/div[1]/div[1]/div[1]/div[1]";
	public static final String DRIVER_001 = "//li[contains(text(),'Tài xế 001')]";
	public static final String CUSTOMERTYPE_DROPDOWN = "//body/div[@id='root']/div/main[@id='mainContent']/div/div[@id='export-driver']/div/div/div/form/div/div/div[3]/div[1]/div[1]/div[1]";
	public static final String DISTRIBUTION_AGENCY = "//li[contains(text(),'Đại lý phân phối')]";
	public static final String CUSTOME_NAME_DROPDOWN = "//select[@placeholder='Chọn khách hàng...']";
	public static final String CUSTOMER_CHILD_DROPDOWN = "//span[@id='react-select-8--value']//div//input";
	public static final String LICENSEPLATE_INPUT = "//div[@id='export-driver']//div//div//div//form//div//div//div//div//div//input[@id='license_plate']";
	public static final String SAVE_BUTTON = "//div[@id='export-driver']//div//div//div//button[contains(text(),'Lưu')]";
	public static final String CLOSE_BUTTON = "//div[@id='export-driver']//div//div//div//button[contains(text(),'Đóng')]";
	public static final String NOTIFICATION_EMPTY_MESSAGE = "//label[contains(text(),'Empty request cylinder_serials, cylinder_serials must be id array')]";
	public static final String NOTIFICATION_STATUS_MESSAGE = "//label[contains(text(),'Những mã này đang vận chuyển, đã bán, bình rỗng, hoặc đang không ở doanh nghiệp sở tại nên không thể xuất :')]";
	public static final String NOTIFICATION_SUCCESS_MESSAGE = "//div[contains(text(),'Xuất hàng thành công!')]";
	public static final String RESET_BUTTON = "";
}
