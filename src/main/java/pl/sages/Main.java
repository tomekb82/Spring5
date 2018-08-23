package pl.sages;

import org.apache.log4j.Logger;
/**
 * Created by acacko on 21.08.18
 */
public class Main {

  static final  Logger logger = Logger.getLogger(Main.class);

  public static void main(String[] args) throws InterruptedException {
    for(int i = 0; i < 100; i++){
      logger.info("Hello");
      Thread.sleep(2000);
    }
  }

  public boolean method() {
    logger.info("aaaa");
    return true;
  }
}
