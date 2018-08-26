package pl.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.spring.model.Album;
import pl.spring.service.springdata.AlbumService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AlbumRestController {

  private final AlbumService albumService;

  @Autowired()
  public AlbumRestController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @GetMapping(value = "/albums")
  public List<Album> findAll() {
    return albumService.findAll();
  }

  @GetMapping(value = "/album/{id}")
  public Album findById(@PathVariable("id") Long id) {
      return albumService.findById(id).get();
  }

  @GetMapping(value = "/album")
  public Album findByName(@RequestParam("name") String name) {
    return albumService.findByName(name);
  }

  @PostMapping(value = "/album")
  public void save(@RequestBody() Album album) {
      albumService.save(album);
  }

  @DeleteMapping(value = "/album/{id}")
  public void deleteById(@PathVariable("id") Long id) {
      albumService.deleteById(id);
  }

  // run Spring Batch Job
  @GetMapping(value = "/album-job")
  public void runJob() throws Exception {
    albumService.runJob();
  }
}
