package leetcode.easy;

import java.util.List;

public class EmployeeImportance {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        for(Employee e: employees){
            if(e.id==id){
                importance+=e.importance;
                for(int i:e.subordinates){
                    importance+=getImportance(employees,i);
                }
            }
        }

    return importance;
    }
}
