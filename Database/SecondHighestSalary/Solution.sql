SELECT Max(Salary) as SecondHighestSalary from LeetCode.Employee 
 where Salary<(Select Max(Salary) from LeetCode.Employee);

SELECT Max(Salary) as SecondHighestSalary from LeetCode.Employee 
where Salary not in(Select Max(Salary) from LeetCode.Employee);

Select Salary from LeetCode.Employee
order by Salary desc limit 1 offset 1;



 