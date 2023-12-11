package ru.ifmo.web3;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@SessionScoped
public class Point implements Serializable {
    private Integer id;
    private double x;
    private double y;
    private double radius = 1;
    private boolean result;
    private LocalDateTime currentTime;
    private double requestTime;

    public Point(Integer id, double x, double y, double radius, boolean result, LocalDateTime currentTime, double requestTime) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.result = result;
        this.currentTime = currentTime;
        this.requestTime = requestTime;
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

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public double getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(double requestTime) {
        this.requestTime = requestTime;
    }

}
