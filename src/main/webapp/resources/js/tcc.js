/**
 * ***************************************
 * Busy Status
 */
if (!window["busystatus"]) {
	var busystatus = {};
}
 
busystatus.onStatusChange = function onStatusChange(data) {
	var status = data.status;
 
	alert("ajax event triggered");
	if (status === "begin") { // turn on busy indicator
		document.body.style.cursor = 'wait';
	} else { // turn off busy indicator, on either "complete" or "success"
		document.body.style.cursor = 'auto';
	}
};
 
jsf.ajax.addOnEvent(busystatus.onStatusChange);


/**
 * ***************************************
 * Modal FIX
 */
function modalFix(){
	
	$("#dialog").removeClass("ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-draggable ui-resizable");
	$('#dialog').addClass("modal");
	
	//arrumando o header
	$("#dialog div.ui-dialog-titlebar").addClass("modal-header");
	$("#dialog div.ui-dialog-titlebar").removeClass("ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top");
	$("#dialog div.modal-header span.ui-dialog-title").removeClass("ui-dialog-title");

	//fix mid
	$("#dialog div.ui-dialog-content").addClass("modal-body");
	$("#dialog div.ui-dialog-content").removeClass("ui-dialog-content ui-widget-content");
	
	//fix footer
	$("#dialog div.ui-dialog-footer").addClass("modal-footer");
	$("#dialog div.ui-dialog-footer").removeClass("ui-dialog-footer ui-widget-content");
}


	

