package pl.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class FilterAlbumProcessor implements ItemProcessor<AlbumDTO, AlbumDTO> {

    @Override
    public AlbumDTO process(AlbumDTO album) throws Exception {

        System.out.println("Processing FilterAlbumProcessor..." + album);
        if(album.getName().toLowerCase().contains("mysql"))
            return album;
        else{
            System.out.println("Omitting .." + album.getName());
            return null;
        }
    }
}
