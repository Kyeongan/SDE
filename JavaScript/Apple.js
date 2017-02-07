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

