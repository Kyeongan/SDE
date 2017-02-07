// Apple Maps Interview

map_search
+------+---------------------+----------------------+---------+-------------+ 
| id   | ts                  | query                | country | query_score | 
+------+---------------------+----------------------+---------+-------------+ 
|    1 | 2013-07-21 12:42:40 | starbucks            | JP      |         234 | 
|    2 | 2013-07-21 18:32:08 | Home dept            | CA      |         130 | 
|    3 | 2013-07-21 08:22:40 | 2341 stevens street  | US      |         289 | AM
|    4 | 2013-07-21 22:16:35 | sfo                  | US      |         260 | PM
|    5 | 2013-07-22 17:32:09 | abc shopping mall    | UK      |         170 | 
|    6 | 2013-07-22 18:32:00 | 5050 abc avenue      | FR      |         180 | 
|    7 | 2013-07-24 18:10:10 | 4th street, san jose | US      |         290 | PM
+------+---------------------+----------------------+---------+-------------+ 
 
country_mapping; 
+---------+---------------+ 
| country | continent     | 
+---------+---------------+ 
| US      | North America | 
| CA      | North America | 
| JP      | Asia          | 
| UK      | Europe        | 
| FR      | Europe        | 
+---------+---------------+ 


(1) Find average score of each continent

select avg(query_score), b.continent
from map_search a, country_mapping b
where a.country = b.country
group by b.continet



(2) The top 2 query scores of each country

select max(query_score), country, query
from map_search 
group by country, query
order by query_schore desc
limit 2

select query_score, country, query
from (
  select rank() over (partition by country order by query_score desc) as rank
  from map_search order by query_score
  ) sub
where sub.rank <= 2



(3) Query the average score difference between AM and PM for each country

SELECT AM.a - PM.a
FROM
(
  SELECT avg(query_score) as a from map_search
  WHERE hours(ts) between 0 and 11
  GROUP BY country
) AM, 
(
  SELECT avg(query_score) as a from map_search
  WHERE hours(ts) between 12 and 23
  GROUP BY country
) PM
WHERE AM.country = PM.country













# input
# date1 = c('2004Jan2','2012Nov24','2014September13','07August1','98Apr3')

# desired output format 'yyyy-mm-dd'
# "2004-01-02" "2012-11-24" "2014-09-13" "2007-08-01" "1998-04-03" 

var yyyy;
var mm;
var dd;

for( int i=0 ; i<date1.length  i++ ) {
  
  // yyyy -> 2 or 4 
  if( left(date1[i],4) < 9999 || )
  {
    yyyy = left(date1[i],4);
    mm_index = 4;
  }
  eles
  {
    yyyy = left(date1[i],2);
    mm_index = 
  }
  
  // month
  if(  )
  {
    switch()
    {
     case left(mm,mm_index,  3) == 'Jan' : mm = 1;
     case left(mm,mm_index, 3) == 'Jan' : mm = 1;
    }
  }
  
  
  //
  if( left(date1[i],-2) < 9999 || )
  {
    dd = left(date1[i],-2);
  }
  eles
  {
    dd = left(date1[i],-1);
  }
  
  
  
  output[i] = yyyy 

}


