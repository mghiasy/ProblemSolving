
-- using case/when
update salary 
set sex = case sex when 'f' then 'm'
           else 'f'
            end;
            
-- another way for case/when
update salary
set sex= case when sex='f' then 'm'
		else 'f'
        end;
            
-- another way for case/when
update salary
set sex= case when sex='f' then 'm'
		 when sex='m' then 'f'
        end;
        
-- another way for case/when
update salary
set sex= case sex
		when 'f' then 'm'
		when 'm' then 'f'
        else sex -- otherwise keep the value
        end;

-- use If(condition, then, else)
update salary 
set sex = if('f','m','m');


