package ru.ifmo.web3.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import ru.ifmo.web3.dao.PointDAO;

@Named
@SessionScoped
public class PointDataModel extends LazyDataModel<Point> {
  @Inject private PointDAO pointDAO;

  @Override
  public int count(Map<String, FilterMeta> filterBy) {
    return pointDAO.getAttemptsCount();
  }

  @Override
  public List<Point> load(
      int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
    return pointDAO.getPointsList();
  }
}
