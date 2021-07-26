select Email
from (select Email, count(*) as num
      from Person
      group by Email)
where num > 1;