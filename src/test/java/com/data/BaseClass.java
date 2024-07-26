package com.data;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement findElement;

	public static void browserLaunch(String browser) {

		switch (browser) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		}

	}

	public static void maxWindow() {

		driver.manage().window().maximize();

	}

	public static void minWindow() {

		driver.manage().window().minimize();

	}

	public static void loadUrl(String url) {

		driver.get(url);

	}

	public static WebElement elementFind(String type, String value) {

		switch (type) {
		case "id":
			findElement = driver.findElement(By.id(value));
			break;
		case "name":
			findElement = driver.findElement(By.name(value));
			break;
		case "xpath":
			findElement = driver.findElement(By.xpath(value));
			break;
		case "linktext":
			findElement = driver.findElement(By.linkText(value));
			break;

		}
		return findElement;

	}

	public static void passValues(WebElement ref, String value) {

		ref.sendKeys(value);

	}

	public static void buttonClick(WebElement ref) {

		ref.click();

	}

	public static void navigatePage(String type, String value) {

		switch (type) {
		case "to":
			driver.navigate().to(value);
			break;
		case "back":
			driver.navigate().back();
			break;
		case "forward":
			driver.navigate().forward();
			break;
		case "refresh":
			driver.navigate().refresh();
			break;
		}

	}

	public static void closeWindow() {

		driver.close();

	}

	public static void closeBrowser() {

		driver.quit();

	}

	public static void webdriverWait(String action, String type, String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		if (action.equals("visibilityOfElementLocated")) {

			switch (type) {

			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;

			}

		}
		
		else if (action.equals("elementToBeClickable")) {

			switch (type) {

			case "id":
				wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				break;
			case "name":
				wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				break;

			}

		}

	}

	public static void implicitlyWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	public static String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static String getTheTitle() {

		String title = driver.getTitle();
		return title;

	}

	public static String getAttributeValue(WebElement ref) {

		String refValue = ref.getAttribute("value");
		return refValue;

	}

	public static String getText(WebElement ref) {

		String text = ref.getText();
		return text;

	}

	public static void handleAlert(String type, String value) {

		switch (type) {
		case "simple":
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
			break;

		case "confirm":
			Alert confirmAlert = driver.switchTo().alert();
			confirmAlert.dismiss();
			break;

		case "prompt":
			Alert promptAlert = driver.switchTo().alert();
			promptAlert.sendKeys(value);
			promptAlert.accept();
			break;

		}

	}

	public static void handlePopup(String type) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		switch (type) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;

		/*
		 * case "firefox": // FirefoxProfile profile = new FirefoxProfile(); //
		 * profile.setPreference(“dom.webnotifications.enabled”, false); // driver = new
		 * FirefoxDriver();
		 * 
		 * FirefoxProfile profile = new FirefoxProfile();
		 * profile.setPreference("permissions.default.desktop-notification", 1);
		 * DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		 * capabilities.setCapability(FirefoxDriver.PROFILE, profile); driver = new
		 * FirefoxDriver(capabilities);
		 * 
		 * break;
		 */

		case "edge":
			driver = new EdgeDriver();
			break;

		}

	}

	public static void dropdownSelect(WebElement ref, String type, String value) {

		Select s = new Select(ref);

		switch (type) {
		case "SelectByValue":
			s.selectByValue(value);
			break;
		case "SelectByVisibleText":
			s.selectByVisibleText(value);
			break;
		case "SelectByIndex":
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
			break;

		}

	}

	public static void mouseAction(String action, WebElement ref1, WebElement ref2) {

		Actions a = new Actions(driver);
		if (action.equals("click")) {
			a.click(ref1).perform();
		} else if (action.equals("mouseover")) {
			a.moveToElement(ref1).perform();
		} else if (action.equals("rightclick")) {
			a.contextClick(ref1).perform();
		} else if (action.equals("doubleclick")) {
			a.doubleClick(ref1).perform();
		} else if (action.equals("draganddrop")) {
			a.dragAndDrop(ref1, ref2).perform();
		}
	}

	public static void keyboardAction(String action) throws AWTException, InterruptedException {

		Robot robot = new Robot();

		if (action.equals("select")) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}

		else if (action.equals("cut")) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}

		else if (action.equals("copy")) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}

		else if (action.equals("paste")) {

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}

		else if (action.equals("tab")) {

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

		}

	}

	public static void takeScreenshot(String type) throws IOException {

		if (type.equals("visiblescreen")) {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File SourceFile = ts.getScreenshotAs(OutputType.FILE);

			File targetFile = new File("C:\\Users\\dilip\\OneDrive\\Desktop\\Amazon.jpeg");

			FileUtils.copyFile(SourceFile, targetFile);

		}

		else if (type.equals("fullscreen")) {

			Shutterbug.shootPage(driver, Capture.FULL, true)
					.save("C:\\Users\\dilip\\OneDrive\\Desktop\\ShutterAmazon.png");

		}

		else if (type.equals("splitscreen")) {

			Screenshot ref = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
					.takeScreenshot(driver);

			File target = new File("C:\\Users\\dilip\\OneDrive\\Desktop\\AShotAmazon.png");

			boolean write = ImageIO.write(ref.getImage(), "png", target);

			System.out.println(write);

		}

	}

	public static void handleFrames(String type, WebElement ref) {

		if (type.equals("innerframe")) {

			driver.switchTo().frame(ref);

		}

		else if (type.equals("parentframe")) {

			driver.switchTo().parentFrame();

		}

		else if (type.equals("defaultcontent")) {

			driver.switchTo().defaultContent();

		}

	}

	public static void scrollWindow(String type, WebElement ref) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll down

		if (type.equals("scrolldown2000")) {

			js.executeScript("window.scrollBy(0,2000)");

		}

		else if (type.equals("scrolldown1000")) {

			js.executeScript("window.scrollBy(0,1000)");

		}

		// scroll up

		else if (type.equals("scrollup2000")) {

			js.executeScript("window.scrollBy(0,-2000)");

		}

		else if (type.equals("scrollup1000")) {

			js.executeScript("window.scrollBy(0,-1000)");

		}

		// scroll down until an element is visible

		else if (type.equals("scrolltoview")) {

			js.executeScript("arguments[0].scrollIntoView();", ref);

		}

		// scroll down to the bottom of the page

		else if (type.equals("scrolltobottom")) {

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		}

		// scroll back to the top of the page

		// js.executeScript("window.scrollBy(0,-3500)");

		else if (type.equals("scrolltotop")) {

			js.executeScript("window.scrollTo(0, 0)");

		}

	}

	public static String excelRead(String path, String sheetName, int rowNumber, int cellNumber) throws IOException {

		String data = null;

		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		CellType cellType = cell.getCellType();

		switch (cellType) {

		case STRING:
			String scv = cell.getStringCellValue();
			data = scv;
			break;

		case NUMERIC:
			boolean cellDateFormatted = DateUtil.isCellDateFormatted(cell);
			if (cellDateFormatted) {

				Date dcv = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String format = sdf.format(dcv);
				data = format;

			}

			else {

				double ncv = cell.getNumericCellValue();
				long round = Math.round(ncv);

				if (round == ncv) {

					String string = Long.toString(round);
					data = string;

				}

				else {

					String string2 = Double.toString(ncv);
					data = string2;

				}

			}

		}

		return data;

	}

	public static void hotelBooking() {

	}

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		// browserLaunch("chrome");

		handlePopup("chrome");
		loadUrl("https://www.amazon.in/");
		maxWindow();
		implicitlyWait();

		// Code for Facebook Login

		/*
		 * WebElement username = elementFind("xpath", "//input[@type='text']");
		 * passValues(username, "8072830083"); WebElement password =
		 * elementFind("xpath", "//input[@type='password']"); passValues(password,
		 * "Testaccount@007"); WebElement login = elementFind("xpath",
		 * "//button[@name='login']"); buttonClick(login);
		 */

		// Code for Facebook SignUp

		// To Click Create Account button
		/*
		 * WebElement createAccount = elementFind("xpath",
		 * "//a[text()='Create new account']"); buttonClick(createAccount);
		 * 
		 * // To Wait until the page/webelement is loaded implicitlyWait();
		 * 
		 * // To Enter Firstname value WebElement firstname = elementFind("xpath",
		 * "//input[@name='firstname']"); passValues(firstname, "Ashok");
		 * 
		 * // To Enter Lastname value WebElement lastname = elementFind("xpath",
		 * "//input[@name='lastname']"); passValues(lastname, "Selva");
		 * 
		 * //To Enter Email Address WebElement emailAddress = elementFind("xpath",
		 * "//input[@name='reg_email__']"); passValues(emailAddress,
		 * "writetogenius2021@gmail.com");
		 * 
		 * // To Get Attribute Value String emailAddressValue =
		 * getAttributeValue(emailAddress); System.out.println(emailAddressValue);
		 * 
		 * // To Confirm Email Address // WebElement confirmEmail = elementFind("xpath",
		 * "//input[@name='reg_email_confirmation__']"); // passValues(confirmEmail,
		 * "writetogenius2021@gmail.com");
		 * 
		 * // To Select, Copy, Tab & Paste the value into another text field using Robot
		 * Class keyboardAction("select"); keyboardAction("copy");
		 * keyboardAction("tab"); keyboardAction("paste");
		 * 
		 * // To Enter Password Value WebElement password = elementFind("xpath",
		 * "//input[@name='reg_passwd__']"); passValues(password, "Newpassword@123");
		 * 
		 * // To Get Attribute Value String passwordValue = getAttributeValue(password);
		 * System.out.println(passwordValue);
		 * 
		 * //To Select Day WebElement day = elementFind("xpath", "//select[@id='day']");
		 * dropdownSelect(day, "SelectByValue", "16");
		 * 
		 * //To Select Month WebElement month = elementFind("xpath",
		 * "//select[@id='month']"); dropdownSelect(month, "SelectByVisibleText",
		 * "Oct");
		 * 
		 * //To Select Year WebElement year = elementFind("xpath",
		 * "//select[@id='year']"); dropdownSelect(year, "SelectByIndex", "37");
		 * 
		 * // To Select Gender WebElement gender = elementFind("xpath",
		 * "//label[text()='Male']"); buttonClick(gender);
		 * 
		 * String genderValue = getAttributeValue(gender);
		 * System.out.println(genderValue);
		 * 
		 * String genderType = gender.getText(); System.out.println(genderType);
		 */

		// To Click Sign Up button
		// WebElement signUp = elementFind("xpath", "(//button[text()='Sign Up'])[1]");
		// buttonClick(signUp);

		// Code for mouse actions in Amazon
		/*
		 * takeScreenshot(); WebElement prime = elementFind("xpath",
		 * "//span[text()='Prime']"); mouseAction("mouseover", prime, null); WebElement
		 * search = elementFind("id", "twotabsearchtextbox"); mouseAction("click",
		 * search, null); passValues(search, "iphone13"); mouseAction("doubleclick",
		 * search, null); mouseAction("rightclick", search, null);
		 * navigatePage("refresh", null); implicitlyWait();
		 */

		// Windows Handling

	}

}
