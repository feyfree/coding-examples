select Trips.Request_at as 'Day', round(count(if(Trips.Status!='completed', 1, NULL)) / count(*),2) as 'Cancellation Rate'
from Trips #此处内连接作用非禁止乘客与日期筛选
         inner join Users as Client
                    on Trips.Client_Id = Client.Users_Id
                        and Client.Banned = 'No'
                        and (Trips.Request_at between '2013-10-01' and '2013-10-03') #此处内连接作用非禁止司机
    inner join Users as Driver
on Trips.Driver_Id = Driver.Users_Id
    and Driver.Banned = 'No'
    #分组
group by Trips.Request_at