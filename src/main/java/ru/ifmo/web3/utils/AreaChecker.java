package ru.ifmo.web3.utils;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import ru.ifmo.web3.models.Point;

@Named
@SessionScoped
public class AreaChecker implements Serializable {
  public void setResultAndTime(Point point) {
    long startTime = System.nanoTime();
    point.setCurrentTime(new Date(System.currentTimeMillis()));
    boolean isInside = isInside(point.getX(), point.getY(), point.getRadius());
    point.setResult(isInside);
    point.setRequestTime(System.nanoTime() - startTime);
  }

  private boolean isInside(double x, double y, double r) {
    return Double.compare(x, 0.0) <= 0
            && Double.compare(y, 0.0) >= 0
            && Double.compare(y, 0.5 * (x + r)) <= 0
        || Double.compare(y, 0.0) >= 0
            && Double.compare(x, 0.0) >= 0
            && Double.compare(x * x + y * y, r * r / 4) <= 0
        || Double.compare(x, 0.0) <= 0
            && Double.compare(y, 0.0) <= 0
            && Double.compare(x, -r / 2) >= 0
            && Double.compare(y, -r) >= 0;
  }
}
