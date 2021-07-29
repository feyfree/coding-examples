DELETE
p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;

--方法2
DELETE
FROM Person
WHERE Id NOT IN (
    SELECT id
    FROM (
             SELECT MIN(Id) AS Id
             FROM Person
             GROUP BY Email
         ) AS temp
)


