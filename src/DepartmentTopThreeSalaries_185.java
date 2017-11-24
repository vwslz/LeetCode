public class DepartmentTopThreeSalaries_185 {
    /**
    * mysql
    */
//    SELECT d.Name as Department, e.Name as Employee, e.Salary as Salary
//    FROM Employee E, Department D
//    WHERE (
//            SELECT count(distinct(Salary))
//    FROM Employee
//    WHERE DepartmentId = e.DepartmentId and Salary > e.Salary
//    ) < 3 AND e.DepartmentId = d.Id
//    ORDER BY e.DepartmentId, e.Salary DESC;
}
