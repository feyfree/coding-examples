SELECT c.id AS id
FROM weather as c
         JOIN
     weather y ON DATEDIFF(c.recordDate, y.recordDate) = 1
         AND c.Temperature > y.Temperature;
