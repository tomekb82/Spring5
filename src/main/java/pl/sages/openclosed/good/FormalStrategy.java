package pl.sages.openclosed.good;

public class FormalStrategy implements IGreetingStrategy {
    @Override
    public String sayHello() {
        return "Good evening, sir.";
    }
}
