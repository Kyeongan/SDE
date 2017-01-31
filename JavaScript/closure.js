// Jan 30, 2017
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures

var me = "Karl Kwon";
function hello() {
	console.log(me);
}

hello();


function init() {
    var name = "Mozilla"; // name is a local variable created by init
    function displayName() { // displayName() is the inner function, a closure
        console.log (name); // displayName() uses variable declared in the parent function    
    }
    displayName();    
}
init();
