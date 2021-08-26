package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, Trip> passengerTrip;
    Map<String, Route> routeMap;

    public UndergroundSystem() {
        passengerTrip = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!passengerTrip.containsKey(id)) {
            Trip trip = new Trip();
            trip.setCheckIn(stationName, t);
            passengerTrip.put(id, trip);
        }

    }

    public void checkOut(int id, String stationName, int t) {
        if (passengerTrip.containsKey(id)) {
            Trip trip = passengerTrip.get(id);
            trip.setCheckout(stationName, t);
            String routeName = trip.getDepartureCity() + "_" + stationName;
            Route route = routeMap.getOrDefault(routeName, new Route(routeName));
            route.addTrip(trip.getEndTime() - trip.getStartTime());
            routeMap.put(routeName, route);
            passengerTrip.remove(id);
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "_" + endStation;
        Route route = routeMap.get(routeName);
        return route.getAverageTime();
    }
}

class Trip {
    private String start;
    private int startTime;
    private String end;
    private int endTime;

    void setCheckIn(String start, int startTime) {
        this.start = start;
        this.startTime = startTime;
    }

    void setCheckout(String end, int endTime) {
        this.end = end;
        this.endTime = endTime;
    }

    int getStartTime() {
        return startTime;
    }

    int getEndTime() {
        return endTime;
    }

    String getDepartureCity() {
        return start;
    }

}

class Route {
    private String route;
    private int numberOfTimes = 0;
    private int totalTime = 0;

    Route(String route) {
        this.route = route;
    }

    void addTrip(int t) {
        numberOfTimes++;
        totalTime += t;

    }


    double getAverageTime() {
        return (double) totalTime / numberOfTimes;
    }
}

