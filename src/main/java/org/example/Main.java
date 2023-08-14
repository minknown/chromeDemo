package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {

    public static void main(String[] args) {
        // 当文本光标位于高亮显示的文本处时按 Alt+Enter，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        System.out.printf("Hello and welcome!");
        //如果没有配置环境变量，需要调用
        //第一个参数固定写法，第二个参数是chromedriver的安装位置
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        try {
            //设置不弹出浏览器
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("disable-gpu");
            //不搞service这个可能控制台无法显示一些端口之类的。
            ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
            //Chrome设置代理
            // if (zsyzbConfig.proxyHost != null && !zsyzbConfig.proxyHost.equals("") && z<syzb>Config.proxyPort != null) {
            //    options.addArguments("--proxy-server=http://" + proxyIP);
            //}
            ChromeDriver driver = new ChromeDriver(service,options);
            driver.get("https://mayizt.com/cnzz");

            //打开第二个
            /*((JavascriptExecutor)driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); //switches to new tab
            driver.get("https://www.facebook.com");*/
            //获取页面源码
            String content = driver.getPageSource();
            //使用jsoup解析页面
            Document document = Jsoup.parse(content);
            //String classTxt = document.getElementsByClass("Class属性").txt;
            //Elements contenttwo = document.getElementById("ID属性").select("js选择器");
            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}