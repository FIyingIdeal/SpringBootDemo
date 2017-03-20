var socket;
$(document).ready(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});
});

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	socket = new SockJS("/normalwebsocket");
	
	socket.onopen = function(e) {
		onOpen(e);
	}
	
	socket.onmessage = function(e) {
		console.log(e);
		showGreeting(e.data);
	}
	
	socket.onclose = function() {
		disconnect()
	}
}

function onOpen(e) {
	setConnected(true);
	console.log("onopen ==> " + e);
}

function showGreeting(message) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function sendName() {
	socket.send($("#name").val());
}

function disconnect() {
	if (socket != null) {
		socket.close();
		console.log("close connection!");
	}
	setConnected(false);
}
