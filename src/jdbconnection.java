import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.ResultSet;


public class jdbconnection {

	public static void main(String[] args) throws SQLException {
		
		String host ="localhost";
		String port="3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "Billgates1*");
		
		Statement s = con.createStatement();
		
		ResultSet rs = s.executeQuery("Select * from credentials where scenario='rewardscard'");
		
		while(rs.next()) // Point base index to first index
		{
		
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium with Java\\Software Installs_IMP\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		
		}
		
	}

}
