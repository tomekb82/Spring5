package pl.spring.batch;

import org.springframework.batch.item.ItemProcessor;
import pl.spring.model.Album;

import java.util.Calendar;

public class AlbumItemProcessor implements ItemProcessor<Album, AlbumDTO> {

  @Override
  public AlbumDTO process(Album album) throws Exception {
    AlbumDTO albumDTO = new AlbumDTO();
    albumDTO.setId(album.getId());
    albumDTO.setName(album.getName().toUpperCase());
    albumDTO.setCreated(Calendar.getInstance().getTime());
    System.out.println("Processing..." + albumDTO);
    return albumDTO;
  }
}
