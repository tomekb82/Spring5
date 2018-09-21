package pl.spring.batch;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement(name = "Album")
@ToString
public class AlbumDTO {

  private static final SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

  private long id;
  private String name;
  private Date created;

  @XmlAttribute(name = "id")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @XmlAttribute(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlAttribute(name = "created")
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getCsvDate()  {
    return OUTPUT_DATE_FORMAT.format(getCreated());
  }
}
