package pl.sages.spring.batch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weather")
public class Weather {

  private static final SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyy");
  private static final SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

  private int sensorId;
  private String city;
  private int quantity;
  private String date;
  private String value;

  @XmlAttribute(name = "sensorId")
  public int getSensorId() {
    return sensorId;
  }

  public void setSensorId(int sensorId) {
    this.sensorId = sensorId;
  }

  @XmlElement(name = "quantity")
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @XmlElement(name = "city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @XmlElement(name = "date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @XmlElement(name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getCsvDate() throws ParseException {
    return OUTPUT_DATE_FORMAT.format(INPUT_DATE_FORMAT.parse(getDate()));
  }

}

