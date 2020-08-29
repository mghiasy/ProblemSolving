-- on db-> functions, right click then createFunction

CREATE DEFINER=`root`@`localhost` FUNCTION `getNthHighestSalary`(N INT) RETURNS int
BEGIN
DECLARE M INTEGER;
SET M = N-1;

RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary
      FROM LeetCode.Employee
      ORDER BY Salary DESC
      LIMIT 1 OFFSET M
  );
END