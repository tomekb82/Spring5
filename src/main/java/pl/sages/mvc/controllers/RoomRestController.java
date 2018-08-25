package pl.sages.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sages.persistance.model.Room;
import pl.sages.service.RoomService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RoomRestController {

  private final RoomService roomService;

  @Autowired
  public RoomRestController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping(value = "/rooms")
  public List<Room> geRooms() {
    return roomService.findAll();
  }

  @GetMapping(value = "/room")
  public Room getRoomByIdRequestParam(@RequestParam("id") Long id) {
    return roomService.findById(id);
  }

  @GetMapping(value = "/room/{id}")
  public Room getRoomById(@PathVariable("id") Long id) {
    return roomService.findById(id);
  }

  @PostMapping(value = "/room")
  public void addRoom(@RequestBody() Room room) {
    roomService.addRoom(room);
  }

  @DeleteMapping(value = "/room/{id}")
  public void removeRoom(@PathVariable("id") Long id) {
    roomService.removeRoom(id);
  }

 /* @GetMapping(value = "/room")
  public Room getRommByIdObject(Room room) {
    return roomService.findById(room.getId());
  }*/

}
