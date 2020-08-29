-- This function will assign rank to each row within a partition without gaps
Select Score, DENSE_RANK() over(order by Score desc) as drnk
from LeetCode.Scores;

-- Rank() over(order by Score desc) as rnk
-- This function will assign rank to each row within a partition with gaps.
-- may have some gaps between Ranks

-- ??
SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) 'Rank'
FROM LeetCode.Scores s
ORDER BY Score desc;

