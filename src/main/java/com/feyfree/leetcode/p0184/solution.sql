select d.Name as Department, e.Name as Employee, e.Salary as Salary
from Employee as e
         join (select DepartmentId, MAX(Salary) as MaxSalary
               from Employee
               group by DepartmentId) as a on e.DepartmentId = a.DepartmentId
         join Department as d on a.DepartmentId = d.Id
where e.Salary = a.MaxSalary