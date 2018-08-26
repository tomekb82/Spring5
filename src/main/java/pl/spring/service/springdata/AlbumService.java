package pl.spring.service.springdata;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.spring.dao.springdata.AlbumDao;
import pl.spring.model.Album;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService  {

  private AlbumDao albumDao;
  private JobLauncher jobLauncher;

  @Autowired
  @Qualifier(value="readAlbumsJob")
  private Job readAlbumsJob;

  @Autowired
  public AlbumService(AlbumDao albumDao, JobLauncher jobLauncher/*, Job readAlbumsJob*/) {
    this.albumDao = albumDao;
    this.jobLauncher = jobLauncher;
    //this.readAlbumsJob = readAlbumsJob;
  }

  public Album findByName(String name) {
    return albumDao.findByName(name);
  }

  public Optional<Album> findById(Long id) {
    return albumDao.findById(id);
  }

  public List<Album> findAll() {
    return albumDao.findAll();
  }

  public Album save(Album album) {
    return albumDao.save(album);
  }

  public void deleteById(Long id) {
    albumDao.deleteById(id);
  }

  public void delete(Album album) {
    albumDao.delete(album);
  }

  public void runJob() throws Exception {
    JobExecution execution = this.jobLauncher.run(this.readAlbumsJob, new JobParameters());
    System.out.println("Exit Status : " + execution.getStatus());
  }

}
