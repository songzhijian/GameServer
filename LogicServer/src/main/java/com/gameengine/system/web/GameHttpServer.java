package com.gameengine.system.web;


import com.gameengine.system.utils.GameLoggerFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;

/**
 * jetty http 服务
 */
public class GameHttpServer {
    private final Logger log = GameLoggerFactory.getLogger(this.getClass());
    private Server jettyServer = new Server(8080);

    private GameHttpServer INSTANCE = new GameHttpServer();

    public GameHttpServer getInstance() {
        return INSTANCE;
    }

    public void startJettyServer() throws Exception {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");
        XmlConfiguration jettyConfig = new XmlConfiguration(Resource.newSystemResource("jetty.xml"));
        jettyConfig.configure(jettyServer);
        jettyServer.setHandler(context);
        jettyServer.start();
    }

    public static void main(String[] args) throws Exception {
        GameHttpServer server = new GameHttpServer();
        server.startJettyServer();
    }
}
