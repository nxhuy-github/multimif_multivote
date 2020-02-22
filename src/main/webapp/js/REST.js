
// REST.js
// Provides functions to fetch data from the server REST API.

// create an asynchrone request
// don't call directly
function createRequest() {
	var reqObj = null;
	if(window.ActiveXObject) {
		try {
			reqObj = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			reqObj = new ActiveXObject("Microsoft.XMLHTTP");
		}
	} else if(window.XMLHttpRequest) {
		reqObj = new XMLHttpRequest();
	} else {
		console.log("");
	}
	return reqObj;
}

// open an asynchrone request
// don't call directly
function openRequest(method, url) {
	var reqObj = createRequest(method, url);
	if(reqObj !== null) {
		reqObj.open(method, url, true);
	}
	return reqObj;
}

// request REST : get vote data by id
function getVoteDataREST(idVote, callback) {
	var reqObj = openRequest("GET","/votes/"+idVote+"/result");
	if(reqObj !== null) {
		reqObj.onreadystatechange = function() {
			if(reqObj.readyState == 4) {
				if(reqObj.status == 200 || reqObj.status == 0) {
					try{
                        callback(JSON.parse(reqObj.responseText));
					} catch (ex){
						callback(null);
					}
				} else if(reqObj.status == 404) {
					callback(null);
				}
			}
		};
		reqObj.send();
	}
}



