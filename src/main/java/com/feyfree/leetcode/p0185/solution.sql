select base.Department,
       base.Employee,
       base.Salary
from (
         select Department.Name as 'Department', Employee.Name as 'Employee', Employee.Salary,
                dense_rank() over(partition by Employee.DepartmentId order by Employee.Salary desc) as 'Ranking'
         from Employee
                  inner join Department
                             on Employee.DepartmentId = Department.Id
     ) as base
where base.Ranking <= 3