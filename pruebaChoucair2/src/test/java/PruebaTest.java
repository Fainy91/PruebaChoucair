import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class PruebaTest {
    private WebDriver firefoxDriver;

    @Test
    public void hacer_una_busqueda(){
        //encontrar archivo de geckodriver
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

        //crear opciones sobre el drive
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        //nueva instancia del navegador
        firefoxDriver = new FirefoxDriver(options);

        //creando tiempo de espera
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //abrir página web
        firefoxDriver.get("http://automationpractice.com/index.php");

        //encontrar los elementos

        //dar clic sobre la pestaña T-Shirt
        firefoxDriver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")).click();

        // al ingresar a la página T-Shirt, dar clic sobre el botón Add to cart
        firefoxDriver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();

        //en la ventana con el resumen de la venta, dar clic sobre el botón Checkout
        firefoxDriver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")).click();

        //en el paso 1 presioanr el botón Proceed
        firefoxDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")).click();

        //ingresar email para iniciar sesión
        firefoxDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("prueba456@gmail.com");
        firefoxDriver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456");
        firefoxDriver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

        //en el paso 3 presionar el botón Proceed
        firefoxDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")).click();

        //aceptar los términos
        firefoxDriver.findElement(By.xpath("//input[@id='cgv']")).click();
        firefoxDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]")).click();

        //seleccionar el método de pago
        firefoxDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")).click();

        //confirmar pago
        WebElement frase = firefoxDriver.findElement(By.xpath("//h3[contains(text(),'Bank-wire payment.')]"));
        Assert.assertTrue(frase.getText().contains("BANK-WIRE"));
    }
}
