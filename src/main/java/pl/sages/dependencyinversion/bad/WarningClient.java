package pl.sages.dependencyinversion.bad;

import pl.sages.dependencyinversion.good.IClient;

public class WarningClient implements IClient {

  public String sendAlert(String weatherConditions) {
    return "It is " + weatherConditions;
  }
}
