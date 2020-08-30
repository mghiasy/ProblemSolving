-- using left join
Select s.id, s.name 
	from Students s left join Departments d
	on s.department_id = d.id
	where d.id IS NULL;
    
    
-- using NOT IN
Select id, name 
	from Students s
	where department_id not in (Select id from Departments);
    
    
-- Using NOT EXISTS
Select id, name 
from Students s
where NOT EXISTS (select * from Departments d
                   where s.department_id = d.id);