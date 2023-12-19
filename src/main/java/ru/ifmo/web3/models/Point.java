package ru.ifmo.web3.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Named
@SessionScoped
@Entity
@Table
public class Point implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private double x;
    @Column
    private double y;
    @Column
    private double radius = 1;
    @Column
    private boolean result;
    @Column
    private Date currentTime;
    @Column
    private double requestTime;

    public Point(Integer id, double x, double y, double radius, boolean result, Date currentTime, double requestTime) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.result = result;
        this.currentTime = currentTime;
        this.requestTime = requestTime;
    }

    public Point(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Point() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public double getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(double requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", result=" + result +
                ", currentTime=" + currentTime +
                ", requestTime=" + requestTime +
                '}';
    }
}
