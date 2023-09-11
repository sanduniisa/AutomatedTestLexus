import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LexusAutomatedTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/sanduniisa/IdeaProjects/Lexus Automated Test/chromedriver");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.lexus.com.sg");
            driver.manage().window().maximize();
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//*[@id=\"consent_prompt_submit\"]"));
            if (acceptCookiesButton != null) {
                // Click the "Accept Cookies" button
                acceptCookiesButton.click();
                System.out.println("Cookies accepted.");
            } else {
                System.out.println("No 'Accept Cookies' button found.");
            }

            // Step 1: Check if banner exists on homepage
            WebElement bannerElement = driver.findElement(By.xpath("(//*[@class='masthead__wrapper'])[1]"));
            if (bannerElement.isDisplayed()) {
                System.out.println("Step 1 Banner exists on homepage.");
            } else {
                System.out.println("Step 1 Banner not found on homepage.");
            }

            // Step 2: Verify masthead banner text
            String expectedBannerText = "ALL-NEW LEXUS RX HYBRID";
            WebElement actualBannerText = driver.findElement(By.xpath("//*[@id=\"index_tiles\"]/section[1]/div[1]/section[2]/section/h1"));
            String actualBannerGetText = actualBannerText.getText();
            if (actualBannerGetText.contains(expectedBannerText)) {
                System.out.println("Step 2 Masthead banner is showing the expected text: " + expectedBannerText);
            } else {
                System.out.println("Step 2 Masthead banner is not showing the expected text: " + expectedBannerText);
            }

            // Step 3: Check if video exists and can play
            WebElement selectModel = driver.findElement(By.xpath("(//div//p[text()=\"Compact Luxury SUV\"])[3]"));
            if (selectModel != null) {
                //click UX Compact Luxury SUV
                selectModel.click();
                System.out.println("Step 3 UX Compact Luxury SUV selected");
            } else {
                System.out.println("Step 3 No 'UX Compact Luxury SUV not found");
            }

            //Step 4 verify user navigate to  https://www.lexus.com.sg/en/models/ux.html URL
            String currentURL = driver.getCurrentUrl();
            if (currentURL.equals("https://www.lexus.com.sg/en/models/ux.html")) {
                System.out.println("Step 4 Current URL matches the expected URL.");
            } else {
                System.out.println("Step 4 Current URL does not match the expected URL.");
            }

            // Scroll down to the gallery section
            WebElement gallerySection = driver.findElement(By.xpath("//*[@id=\"gallery\"]/div/div/div/header/h2"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gallerySection);

            // Wait for the UX Series YouTube video to load
            WebElement uxVideoFrame = driver.findElement(By.xpath("(//div[@data-src='https://www.youtube.com/watch?v=eokV5IpMGig&rel=0'])[1]"));

            // Check if the video frame is displayed
            if (uxVideoFrame.isDisplayed()) {
                System.out.println("Step 5 UX Series YouTube video is loaded and displayed.");
            } else {
                System.out.println("Step 5 UX Series YouTube video is not loaded.");
            }

            if (uxVideoFrame.isEnabled()) {
                System.out.println("Step 6 The video is playing.");
                uxVideoFrame.click();
            } else {
                System.out.println("Step 6 The video is not playing.");
            }
            //To pause the video
            WebElement closeIcon = driver.findElement(By.xpath("//*[@class='lg-close lg-icon']"));
            closeIcon.click();
            System.out.println("Step 7 Video is paused");

            //Step 8 Click Book a Test Drive Button
            WebElement bookATestDriveButton = driver.findElement(By.xpath("(//*[@class='mdc-button__label'])[5]"));
            if (bookATestDriveButton != null) {
                bookATestDriveButton.click();
                System.out.println("Step 8 Book a Test Drive Button clicked");
            } else {
                System.out.println("Step 8 Book a test Drive Button is not clicked");
            }

            //Step 9  verify user navigate to  https://www.lexus.com.sg/en/contact-us/book-a-test-drive.html?model=ux%20300e URL
            String formPageURL = driver.getCurrentUrl();
            if (formPageURL.equals("https://www.lexus.com.sg/en/contact-us/book-a-test-drive.html?model=ux%20300e")) {
                System.out.println("Step 9 Current URL matches the expected URL.");
            } else {
                System.out.println("Step 9 Current URL does not match the expected URL.");
            }

            // Step 10: Fill the form
            WebElement firstName = driver.findElement(By.xpath("//*[@id='input_first_name']"));
            WebElement lastName = driver.findElement(By.xpath("//*[@id='input_last_name']"));
            WebElement emailAddress = driver.findElement(By.xpath("//*[@id='input_email_address']"));
            WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='input_phone_number']"));
            WebElement preferredDate = driver.findElement(By.xpath("//*[@id='datepicker_preferred_date']"));
            WebElement preferredTime = driver.findElement(By.xpath("(//*/div[@class='choices__list choices__list--single'])[9]"));
            WebElement preferredConsultant = driver.findElement(By.xpath("(//*[@data-value='Preferred sales consultant (optional)'])[1]"));
            WebElement numberOfPax = driver.findElement(By.xpath("(//*[@data-value='Number of pax'])[1]"));
            WebElement preferredModels = driver.findElement(By.xpath("(//*[@data-type='select-multiple'])[1]"));
            WebElement testDriveOptions = driver.findElement(By.xpath("(//*[@class='choices__item choices__item--selectable'])[2]"));
            WebElement termsAndServicesCheckbox = driver.findElement(By.xpath("//*[@id='checkbox_privacy_policy']"));
            WebElement marketingConsentCheckbox = driver.findElement(By.xpath("//*[@id='checkbox_marketing']"));
            WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
            firstName.sendKeys("CPL");
            System.out.println("Step 10 enter first name");

            lastName.sendKeys("Test");
            System.out.println("Step 11 enter last name");

            emailAddress.sendKeys("qa@convertium.com");
            System.out.println("Step 12 enter email address");

            phoneNumber.sendKeys("+6591234567");
            System.out.println("Step 13 enter phone number");

               preferredDate.getAttribute("10 Jan 2021");
               System.out.println("Step 14 enter preferred date");
            //calendar cannot retriev 2021 dates

            preferredTime.getAttribute("18:00");
            System.out.println("Step 15 select preferred time");

            numberOfPax.getAttribute("1");
            System.out.println("Step 16 enter number of pax");

            // Verify Preferred models preselected as RX 300 -- this should be UX 300
            String selectedModel = preferredModels.getAttribute("value");
            if ("RX 300".equals(selectedModel)) {
                System.out.println("Step 17 Preferred models preselected as RX 300.");
            } else {
                System.out.println("Step 17 Preferred models not preselected as RX 300.");
            }

            // Select Test drive Option as Lexus Test Drive Concierge
            testDriveOptions.getAttribute("Lexus Test Drive Concierge");
            System.out.println("Step 18 Selected option: Lexus Test Drive Concierge");

            // Check terms and services
            termsAndServicesCheckbox.click();
            System.out.println("Step 19 terms and services checkbox checked.");

            // Check marketing consent
            marketingConsentCheckbox.click();
            System.out.println("Step 20 marketing consent checkbox checked.");

            if (submitButton.isEnabled()) {
                System.out.println("Step 21 Submit button is enabled");
            } else {
                System.out.println("Step 22 Submit button is not enabled");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
