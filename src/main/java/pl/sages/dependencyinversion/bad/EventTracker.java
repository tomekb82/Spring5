package pl.sages.dependencyinversion.bad;

import pl.sages.dependencyinversion.good.IClient;

public class EventTracker {

  private String currentStatus;
  private IClient errorClient;
  private IClient warningClient;

  public EventTracker(IClient errorClient, IClient warningClient) {
    this.errorClient = errorClient; //new ErrorClient();
    this.warningClient = warningClient;//new WarningClient();
  }

  public void setCurrentStatus(String actualState) {
    this.currentStatus = actualState;
    if (actualState.equals("error")) {
      String alert = errorClient.sendAlert(actualState);
      System.out.print(alert);
    }
    if (actualState.equals("warning")) {
      String alert = warningClient.sendAlert(actualState);
      System.out.print(alert);
    }
  }
}