package pl.sages.dependencyinversion.bad;

import pl.sages.dependencyinversion.good.IClient;

public class ErrorClient implements IClient{
  public String sendAlert(String weatherConditions) {
    return "It is " + weatherConditions;
  }
}
