select a.Name as Employee
from Employee as a
         join Employee as b on a.ManagerId = b.Id
where a.ManagerId is not null
  and a.Salary > b.Salary;