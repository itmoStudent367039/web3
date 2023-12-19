package ru.ifmo.web3.dao;

import com.google.gson.Gson;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ru.ifmo.web3.models.Point;
import ru.ifmo.web3.utils.AreaChecker;

@Named
@SessionScoped
public class PointDAO implements Serializable {

  @PersistenceContext private EntityManager entityManager;
  @Inject
  private AreaChecker areaChecker;

  public List<Point> getPointsList() {
    return entityManager.createQuery("select point from Point point", Point.class).getResultList();
  }

  @Transactional
  public Point addPoint(Point point) {
    areaChecker.setResultAndTime(point);
    entityManager.merge(point);
    entityManager.flush();
    return point;
  }

  @Transactional
  public void addPoint(double pointRadius) {
    final Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

    try {
      var x = Double.parseDouble(params.get("x"));
      var y = Double.parseDouble(params.get("y"));

      final Point point = new Point(x, y, pointRadius);
      this.addPoint(point);
    } catch (IllegalArgumentException ignored) {}
  }

  @Transactional
  public void clearAttempts() {
    entityManager.createQuery("delete from Point").executeUpdate();
  }

  public int getAttemptsCount() {
    return entityManager
        .createQuery("select count(*) from Point", Number.class)
        .getSingleResult()
        .intValue();
  }

  public String getPointsAsJSON() {
    return new Gson().toJson(getPointsList());
  }
}
