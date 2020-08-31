-- using with and Join
with Sub1 as (
    Select team_id,Count(team_id) as team_size
    From Employee 
    group by team_id) 
    
Select e.employee_id,s.team_size
    from Sub1 s join Employee e
    on s.team_id=e.team_id;
    
    
