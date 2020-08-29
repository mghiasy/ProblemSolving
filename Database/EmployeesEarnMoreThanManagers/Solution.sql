Select name as emp_Name  from Employee e1
where Salary> (Select Salary from Employee e2 where Id = e1.ManagerId )