package ru.ifmo.web3.dao;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ru.ifmo.web3.models.Point;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PointDAO implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Point> getPointsList() {
        return entityManager.createQuery("select point from Point point", Point.class).getResultList();
    }

    @Transactional
    public Point addPoint(Point point) {
        entityManager.merge(point);
        entityManager.flush();
        return point;
    }

    @Transactional
    public void clearAttempts() {
        entityManager.createQuery("delete from Point").executeUpdate();
    }

}
