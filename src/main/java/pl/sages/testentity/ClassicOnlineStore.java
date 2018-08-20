package pl.sages.testentity;


import java.io.File;

import javax.xml.bind.JAXB;

public class ClassicOnlineStore {

  protected final OnlineShoppingMall mall =
      JAXB.unmarshal(new File(ClassicOnlineStore.class.getClassLoader().getResource("data.xml").getFile()), OnlineShoppingMall.class);
}
