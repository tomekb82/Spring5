package pl.sages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by acacko on 21.08.18
 */
@Component
public class Leg {

    @Value("#{'test leg'}")
    private String test;


    @Override
    public String toString() {
        return "Leg{" +
                "test='" + test + '\'' +
                '}';
    }
}
