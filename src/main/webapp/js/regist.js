/**
 * 
 */

var conversation;
var step;

function initConversation(){
	var request = new XMLHttpRequest();
	request.open("Get","/regist/speak");
	request.setRequestHeader("Content-Type","application/json");
	request.onreadystatechange=function(){
		if(request.readyState ===4 && request.status===200){
			var type = request.getResponseHeader("Content-Type");
			if(type.indexOf("application/json")>=0){
				conversation=JSON.parse(request.responseText);
				speak(0);
			}
		}
	}
	request.send(null);
}



function speak(step){
	if(step==conversation.length){
		return;
	}
	document.getElementById("statement").innerHTML=conversation[step].sentence;
	document.getElementById("statement").className +=" "+"active"
	this.step=step;
}

function nextStatement(){
	speak(++step);
}

initConversation();