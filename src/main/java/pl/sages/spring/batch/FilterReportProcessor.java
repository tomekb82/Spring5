package pl.sages.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class FilterReportProcessor implements ItemProcessor<Weather, Weather> {
    @Override
    public Weather process(Weather weather) throws Exception {

        System.out.println("Processing..." + weather);
        if(weather.getQuantity() > 5)
            return weather;
        else{
            System.out.println("Omitting .." + weather.getCity());
            return null;
        }
    }
}
