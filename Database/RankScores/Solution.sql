-- This function will assign rank to each row within a partition without gaps
Select Score, DENSE_RANK() over(order by Score desc) as drnk
from LeetCode.Scores


-- Rank() over(order by Score desc) as rnk
-- This function will assign rank to each row within a partition with gaps.
-- may have some gaps between Ranks