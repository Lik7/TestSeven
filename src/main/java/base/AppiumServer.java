package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {

    //private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    //private DesiredCapabilities cap;
    private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public int port = 4723;


    public void startServer() {
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

        service.start();
    }


    public void stopServer() {
        service.stop();
    }


    public boolean serverIsRunning() {

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
}
