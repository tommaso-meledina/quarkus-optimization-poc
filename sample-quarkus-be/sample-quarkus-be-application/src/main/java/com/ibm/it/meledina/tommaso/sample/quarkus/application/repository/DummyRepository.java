package com.ibm.it.meledina.tommaso.sample.quarkus.application.repository;

import com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy;
import io.micrometer.core.annotation.Counted;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DummyRepository extends BaseUuidRepository<Dummy> {

  @Transactional
  public boolean addDummy(String dummyName) {
    try {
      persist(new Dummy(dummyName));
      return true;
    } catch (Exception e) {
      Log.error(
          String.format("Could not persist dummy with name %s: %s", dummyName, e.getMessage()), e);
      return false;
    }
  }

  @Transactional
  public Dummy updateDummy(Dummy updatedDummy) {
    try {
      return getEntityManager().merge(updatedDummy);
    } catch (Exception e) {
      Log.error(
          String.format(
              "Could not update dummy with uuid %s: %s", updatedDummy.getUuid(), e.getMessage()),
          e);
      return null;
    }
  }

  public List<Dummy> getDummies() {
    return listAll();
  }
}
