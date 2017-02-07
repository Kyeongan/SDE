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
















// # input
// # date1 = c('2004Jan2','2012Nov24','2014September13','07August1','98Apr3')

// # desired output format 'yyyy-mm-dd'
// # "2004-01-02" "2012-11-24" "2014-09-13" "2007-08-01" "1998-04-03" 


var date = ['2004Jan2','2012Nov24','2014September13','07August1','98Apr3'];
var yyyy;
var mm;
var dd;
var output = [];

for( var i=0 ; i<date.length ; i++ ) {
  
  if( date[i].substring(0,4) < 9999 || date[i].substring(0,4) > 0 )
  {
    yyyy = date[i].substring(0,4);
    mm_index = 4;
  }
  else
  {
    yyyy = '19' + date[i].substring(0,2);
    mm_index = 2;
  }

  
  // console.log(date[i].substring(mm_index, mm_index+3) );
  // month
  switch(date[i].substring(mm_index, mm_index+3))
  {
   case 'Jan' :mm = 1;
   case 'Feb' :mm = 2;
   case 'Mar' :mm = 3;
   case 'Apr' :mm = 4;
   case 'May' :mm = 5;
   case 'Jun' :mm = 6;
   case 'Jul' :mm = 7;
   case 'Aug' :mm = 8;
   case 'Sep' :mm = 9;
   case 'Oct' :mm = 10;
   case 'Nov' :mm = 11;
   case 'Dec' :mm = 12;
  }
  
  // console.log(date[i].substring(date[i].length - 2));
  
  if( date[i].substring(date[i].length - 2) < 9999
        || date[i].substring(date[i].length - 2) > 0 )
    dd = date[i].substring(date[i].length - 2);
  else
    dd = '0' + date[i].substring(date[i].length - 1);
  
  output[i] = yyyy + '-' + mm + '-' + dd;
}

console.log(output);


