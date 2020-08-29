-- Runtime: 862 ms, faster than 11.82% of MySQL online submissions for Employees Earning More Than Their Managers.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
Select name as emp_Name  from Employee e1
where Salary> (Select Salary from Employee e2 where Id = e1.ManagerId );

-- Runtime: 695 ms, faster than 24.49% of MySQL online submissions for Employees Earning More Than Their Managers.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
Select e1.name as emp_name from Employee e1, Employee e2
where e1.ManagerId = e2.Id and e1.Salary> e2.Salary;

-- Runtime: 406 ms, faster than 59.14% of MySQL online submissions for Employees Earning More Than Their Managers.
Select e1.name as emp_name from Employee e1 join Employee e2
on e1.ManagerId = e2.Id and e1.Salary> e2.Salary;