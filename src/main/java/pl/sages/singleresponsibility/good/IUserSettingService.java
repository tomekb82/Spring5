package pl.sages.singleresponsibility.good;

import pl.sages.singleresponsibility.bad.User;

public interface IUserSettingService {
    public void changeEmail(User user) ;

    public boolean checkAccess(User user) ;
}
