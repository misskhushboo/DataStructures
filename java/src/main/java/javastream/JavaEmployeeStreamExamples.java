package javastream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Practice source: https://www.youtube.com/watch?v=7vmdkQtRGzQ&t=4246s
 */
public class JavaEmployeeStreamExamples {

    Employees emp1=new Employees(1,"Alex","Mary",30,"Finance");
    Employees emp2=new Employees(2,"Bob","Jim",100,"Sales");
    Employees emp3=new Employees(3,"John","Mary",60,"Finance");
    Employees emp4=new Employees(4,"John","Mary",70,"Sales");
    Employees emp5=new Employees(5,"John","Mary",100,"IT");
    public static void main(){
        JavaEmployeeStreamExamples streamEx=new JavaEmployeeStreamExamples();
        //streamEx.sortEmployeesBySalary();
        //streamEx.averageSalaryOfEmployees();
        //streamEx.averageSalaryOfEmployees();
       // streamEx.groupEmployeesByDeptAndCalculateSalaryofDepartments();
        //streamEx.highestSalaryinEachDepartment();
        streamEx.countEmployeesInEachDepartment();
    }

    private void sortEmployeesBySalary(){
        List<Employees> emplList=List.of(emp1,emp2,emp3,emp4,emp5);

       emplList.stream().sorted(Comparator.comparing(emp->emp.getSalary())).
                forEach(emp-> System.out.println(emp.toString()));          //30,60,70,100,100,

        emplList.stream().sorted(Comparator.comparing(Employees::getSalary).reversed())
                .forEach(emp-> System.out.println(emp.toString()));
    }

    private void averageSalaryOfEmployees(){
        List<Employees> empList=List.of(emp1,emp2,emp3,emp4,emp5);
        //For avg, we need int and not Integer. We need int salary stream.

        empList.stream().mapToInt(e->e.getSalary()).average()
                .ifPresent(n->System.out.println("Average salary of employees: "+n));  //360%5=72

    }

    private void groupEmployeesByDeptAndCalculateSalaryofDepartments(){
        List<Employees> empList=List.of(emp1,emp2,emp3,emp4,emp5);

        Map<String, Double> mapData= empList.stream().collect(Collectors
                .groupingBy(Employees:: getDepartment,
                        Collectors.averagingDouble(Employees::getSalary)));

        System.out.println("Map="+mapData);
        //Map={Sales=85.0, Finance=45.0, IT=100.0}

    }

    //FInd highest salary of the employee of each department. Group by department as key, value will be

    private void highestSalaryinEachDepartment(){
        List<Employees> empList=List.of(emp1,emp2,emp3,emp4,emp5);

        Map<String, Optional<Employees>> mapData= empList.stream().collect(Collectors
                .groupingBy(Employees:: getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employees::getSalary))));

        System.out.println("Map="+mapData);
    // Map=
        // {Sales=Optional[Employees{employeeName='Bob', employeeId=2, gender='Jim', Salary=100}],
    // Finance=Optional[Employees{employeeName='John', employeeId=3, gender='Mary', Salary=60}],
    // IT=Optional[Employees{employeeName='John', employeeId=5, gender='Mary', Salary=100}]}

  }

    private void countEmployeesInEachDepartment(){

        List<Employees> empList=List.of(emp1,emp2,emp3,emp4,emp5);
        Map<String, Long> mapData= empList.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));
        System.out.println("Map="+mapData);
        //Map={Sales=2, Finance=2, IT=1}

        List<String> list=mapData.entrySet().stream()
                .filter(e->e.getValue()>=2).
                map(e->e.getKey()).toList();

        System.out.println("Department with more than 2 employees="+list);
        //Department with more than 2 employees=[Sales, Finance]

        Optional<Map.Entry<String, Long>> max=mapData.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Maximum employee in department="+max.get());
        // Maximum employee in department=Sales=2
  }
}
