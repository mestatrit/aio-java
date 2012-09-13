String.prototype.trim = function() {
	return this.replace(/(^\s+)|(\s+$)/g, "");
};

String.prototype.format = function() {
	var a = arguments;
	return this.replace(/\{(\d+)\}/g, function(c, b) {
		return a[b];
	});
};

function StringBuilder() {
	this.arr = [];
}

StringBuilder.prototype.append = function(a) {
	this.arr.push(a);
};

StringBuilder.prototype.appendFormat = function() {
	for ( var a = arguments[0], c = 0; c < arguments.length - 1; c++)
		a = a.replace(new RegExp("\\{" + c + "\\}"), arguments[c + 1]);
	this.arr.push(a);
};

StringBuilder.prototype.toString = function() {
	return this.arr.join("");
};

function max_window(){
	window.moveTo(0, 0);
	window.resizeTo(screen.availWidth, screen.availHeight);
}

function full_screen(e) {
	
}
