select distinct (Name) as Customers
from Customers
where id not in (select distinct (CustomerId) from Orders);