package pl.sages.vavr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

  public List<String> readFile(Path path) throws IOException {
    if (!Files.exists(path)) {
      throw new IOException("Baeh file " + path.toString() + " does not exist!");
    }

    return Files.readAllLines(path);
  }
}
