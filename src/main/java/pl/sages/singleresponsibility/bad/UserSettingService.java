package pl.sages.singleresponsibility.bad;

import pl.sages.singleresponsibility.good.IUserSettingService;

public class UserSettingService implements IUserSettingService {

  public void changeEmail(User user) {
    if (checkAccess(user)) {
      //Grant option to change
    }
  }

  public boolean checkAccess(User user) {
    //Verify if the user is valid.
    return false;
  }
}
