// var person = {
// 		first: "Karl",
// 		action: ["tennis", "bike", "trekking"],
// 		printAction() {
// 			this.action.forEach(action => {
// 				var str = this.first + " likes to " + action;
// 				console.log(str);
// 			});
// 		}
// 	};

// person.printAction();



var people = {
	firstname: "Karl",
	action: ["Tennis", "Bike", "Drink"],
	printAction() {
		this.action.forEach(action => {
			var string = this.firstname + " do " + action;
			console.log(string);
		})
	}
}

people.printAction();


//================

var nameBuilder = function(firstName="John", lastName="Doe") {
			console.log(firstName + " " + lastName);
		};

nameBuilder();

var nameBuilder2 =  (param1, param2) => {
	console.log(param1 + " " + param2);
};

nameBuilder2("Karl", "Kwon");

console.log("=================");


var users = [
	{names: "K" , ages: "10", city: "Houston"},
	{names: "J" , ages: "20", city: "Dallas"},
	{names: "M" , ages: "30", city: "Boston"}
]


var users = [
  {name: 'Jerry', age: '3', city: 'Chicago'},
  {name: 'Martha', age: 42, city: 'Seattle'},
  {name: 'Sheldon', age: 29, city: 'Chicago'},
  {name: 'Maria', age: 3, city: 'Seattle'},
  {name: 'Jerry', age: '3', city: 'Chicago'}
]



for(var i=0 ; i<users.length ; i++ ) {
  console.log(users[i]["name"], users[i]["age"], users[i]["city"]);  
}

console.log(Object.keys(users[0]));






















