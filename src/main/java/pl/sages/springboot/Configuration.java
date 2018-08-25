package pl.sages.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@org.springframework.context.annotation.Configuration
public class Configuration {

//  @Bean
//  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//    MappingJackson2HttpMessageConverter converter =
//        new MappingJackson2HttpMessageConverter(mapper);
//    return converter;
//  }
}
