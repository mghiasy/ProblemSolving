-- my Solution using HAVING and COUNT(*)
Select actor_id,director_id 
from (Select actor_id,director_id , Count(*) as num
      From ActorDirector
      group by actor_id,director_id
      Having num >=3) sub;
      
      
-- Better Solution using position number , IF in Count
Select actor_id,director_id 
From ActorDirector
group by 1,2
Having Count(IF(1=2 ,1,0))>=3