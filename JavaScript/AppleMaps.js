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
   case 'Jan' :mm = '01'; break;
   case 'Feb' :mm = '02'; break;
   case 'Mar' :mm = '03'; break;
   case 'Apr' :mm = '04'; break;
   case 'May' :mm = '05'; break;
   case 'Jun' :mm = '06'; break;
   case 'Jul' :mm = '07'; break;
   case 'Aug' :mm = '08'; break;
   case 'Sep' :mm = '09'; break;
   case 'Oct' :mm = '10'; break;
   case 'Nov' :mm = '11'; break;
   case 'Dec' :mm = '12'; break;
  }
  
  // console.log(date[i].substring(date[i].length - 2)) break;
  
  if( date[i].substring(date[i].length - 2) < 9999
        || date[i].substring(date[i].length - 2) > 0 )
    dd = date[i].substring(date[i].length - 2);
  else
    dd = '0' + date[i].substring(date[i].length - 1);
  
  output[i] = yyyy + '-' + mm + '-' + dd;
}

console.log(output);