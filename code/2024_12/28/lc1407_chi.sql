# Write your MySQL query statement below
with total as (select user_id, sum(distance) as total_distance from Rides group by user_id)
select name, IFNULL(total_distance, 0) as travelled_distance
from Users left join total on Users.id = total.user_id
order by travelled_distance desc, name