-- using case when
-- case when should be in paranthesis and have a name

Select x,y,z,
    (case when x+y>z and x+z>y and z+y>x 
     then 'Yes'
    else 'No' 
    end) as triangle
    from triangle;
    

    
    