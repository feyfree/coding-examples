select a.Score                                                                 as Score,
       (select count(distinct b.Score) from Scores b where b.Score >= a.Score) as `RANK`
from Scores a
order by a.Score DESC;


# mysql 8.0 支持 窗口函数
select Score,
       DENSE_RANK() OVER (
        ORDER BY Score desc
    ) `RANK`
FROM Scores;
