package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.IOException;
import java.net.ServerSocket;
// *** СТАРАЯ ВЕРСИЯ. НОВАЯ ВЕРСИЯ AppiumServerManager
public class AppiumServer {

    //private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    //private DesiredCapabilities cap;
    private static AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();

    public static int port = 4723;


    public static void startServer() {

        if (!serverIsRunning()) {
            boolean servIsRun = serverIsRunning();
            System.out.println("AppiumServer is running: " + servIsRun);
            //appiumServer.startServer();
            appiumService.start();
            System.out.println("AppiumServer started on port: " + port);
        } else {
            System.out.println("Appium Server already running on Port: " + port);
            //appiumServer.stopServer();
        }
        /*Capabilities cap = new Capabilities();
        cap.setCapability("noReset", "false");

        // Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(port);
        //builder.withCapabilities(new Capabilities().getCapabilities());
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        //builder.usingDriverExecutable(new File("C:/Users/QA/local/bin/node"));
        //builder.withAppiumJS(new File("C:/Users/QA/local/lib/node_modules/appium/build/lib/main.js"));*/

        // Start the server with the builder
        //service = AppiumDriverLocalService.buildDefaultService();
        //service = AppiumDriverLocalService.buildService(builder);
    }


    public static void stopServer() {
        boolean servIsRun = serverIsRunning();
        System.out.println("AppiumServer is running: " + servIsRun);
        appiumService.stop();
        System.out.println("AppiumServer stopped");
    }


    public static boolean serverIsRunning() {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    //Запуск сервера через командную строку
    public static void startServerCMD() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
            Thread.sleep(8000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Остановка серевера через командную строку
    public void stopServerCMD() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
