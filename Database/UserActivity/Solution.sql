
-- Error Every derived table must have its own alias
select Avg(num) as average_sessions_per_user
from(
    Select user_id, Count(user_id) num
    from Activity
    where datediff('2019-07-27',activity_date) <30
    and activity_type='open_session'
    group by user_id);
    
    -- add name for derived table
    -- Output : {"headers": ["average_sessions_per_user"], "values": [[1.3333]]} 
select Avg(num) as average_sessions_per_user
from(
    Select user_id, Count(user_id) num
    from Activity
    where datediff('2019-07-27',activity_date) <30
    and activity_type='open_session'
    group by user_id) tbl_Name;
    
    -- Rounding up to 2 decimal places
    select Round(Avg(num),2) as average_sessions_per_user
from(
    Select user_id, Count(user_id) num
    from Activity
    where datediff('2019-07-27',activity_date) <30
    and activity_type='open_session'
    group by user_id) tbl_Name;
    
    -- can use distinct SessionId instead of user_id
    -- wrong Answer for {"headers": ["average_sessions_per_user"], "values": [[null]]}
    -- should return {"headers":["average_sessions_per_user"],"values":[[0.00000]]}
        select Round(Avg(num),2) as average_sessions_per_user
from(
    Select user_id, Count(distinct session_Id) num
    from Activity
    where datediff('2019-07-27',activity_date) <30
    group by user_id) tbl_Name;
    
    -- solve problem with IFNULL
        select IFNull(Round(Avg(num),2),0) as average_sessions_per_user
from(
    Select user_id, Count(distinct session_Id) num
    from Activity
    where datediff('2019-07-27',activity_date) <30
    group by user_id) tbl_Name;
    