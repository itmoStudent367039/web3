package ru.ifmo.web3;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PointService implements Serializable {
  private List<Point> pointList;

  {
    pointList = new ArrayList<>();
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
    pointList.add(new Point(1, 2, 3,4, true, LocalDateTime.now(), (double) System.nanoTime() / 1000));
  }

  public List<Point> getPointList() {
    return pointList;
  }

  public void setPointList(List<Point> pointList) {
    this.pointList = pointList;
  }
}
