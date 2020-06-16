package com.edu.distr.sys.server;

import com.edu.distr.sys.server.utils.LogSecurityManager;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  public static void main(String[] args) {
    Logger.getGlobal().setLevel(Level.FINE);
    Logger logger = Logger.getLogger(Main.class.getName());

    if(System.getSecurityManager() == null) {
      System.setSecurityManager(new LogSecurityManager());
    }
    try {
      ServerEngine server = null;
      if(args.length == 2) {
        String remoteReferenceName = args[0];
        int port = Integer.parseInt(args[1]);
        server = new ServerEngine(port, remoteReferenceName);
      } else {
        server = new ServerEngine();
      }

      server.init();
      logger.info("Server engine is ready.");
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
