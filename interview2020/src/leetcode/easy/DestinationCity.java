package leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    //https://leetcode.com/problems/destination-city/discuss/609868/Java-tricky-4-lines-using-one-set
    public String destCity(List<List<String>> paths) {
        Set<String> setOfCities = new HashSet<>();
        for(List<String> s : paths){
            setOfCities.add(s.get(1));
        }

        for(List<String> s : paths){
            setOfCities.remove(s.get(0));
        }

        return setOfCities.iterator().next();
    }
}
