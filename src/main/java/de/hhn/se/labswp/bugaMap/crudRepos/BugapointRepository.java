package de.hhn.se.labswp.bugaMap.crudRepos;

import de.hhn.se.labswp.bugaMap.jpa.Bugapoint;
import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Repository interface for bugapoint table.
 */
@Repository
public interface BugapointRepository extends CrudRepository<Bugapoint,Integer> {
  @Transactional
  @Modifying
  @Query("""
      update Bugapoint b set b.latitude = ?1, b.longitude = ?2, b.description = ?3, b.adminID = ?4
      where b.id in ?5""")
  int updateLatitudeAndLongitudeAndDescriptionAndAdminIDByIdIn(Double latitude, Double longitude,
      String description, int adminID, int id);

  @Override
  void deleteById(Integer integer);
}