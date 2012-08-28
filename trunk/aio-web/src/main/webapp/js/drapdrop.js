// JavaScript Document
var content_panel_lm, content_panel_mx;
var content_panel_md=false;
var content_panel_sh=0;
var content_panel_en=false;
window.onload = function() {
	for(i = 0; i < 5; i++){
		var content_panel = document.getElementsById("content_panel_" + i);
		if(content_panel) {
			content_panel.onmousedown = function(e){
				if(!content_panel_en) {
					if(!e) {
						e = e || window.event;
					}
					content_panel_lm = this.offsetLeft;
					content_panel_mx = (e.pageX) ? e.pageX : e.x;
					this.style.cursor = "w-resize";
					content_panel_md = true;
					if(document.all) {
						this.setCapture();
					} else {
						window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
					}
				}
			}
			
			content_panel.onmousemove=function(e){
				if(content_panel_md) {
					content_panel_en=true;
					if(!e) {
						e = e || window.event;
					}
					var ex = (e.pageX) ? e.pageX : e.x;
					this.style.left = ex - (content_panel_mx - content_panel_lm) + 350;
		
					if(this.offsetLeft < 75){
						var cu = (this.i == 0) ? page.length - 1 : this.i - 1;
						page[sh].style.zIndex = 0;
						page[cu].style.zIndex = 1;
						this.style.zIndex = 2;
						sh = cu;
					}
					if(this.offsetLeft > 75){
						var cu = (this.i == page.length - 1) ? 0 : this.i + 1;
						page[sh].style.zIndex = 0;
						page[cu].style.zIndex = 1;
						this.style.zIndex = 2;
						sh = cu;
					}				
				}
			}
			
			content_panel.onmouseup=function(){
				this.style.cursor = "default";
				md = false;
				if(document.all) {
					this.releaseCapture();
				} else {
					window.releaseEvents(Event.MOUSEMOVE | Event.MOUSEUP);
				}
				flyout(this);
			}
		}
	}
};

function get_object_by_oid(oid){
	return document.getElementById(obj);
}

function flyout(obj){
	if(obj.offsetLeft < 75){
		if((obj.offsetLeft + 350 - 20) > -275){
			obj.style.left = obj.offsetLeft + 350 - 20;
			window.setTimeout("flyout(get_object_by_oid('"+obj.id+"'));",0);
		}else{
			obj.style.left=-275;
			obj.style.zIndex=0;
			flyin(id(obj.id));
		}
	}
	if(obj.offsetLeft>75){
		if((obj.offsetLeft + 350 + 20) < 1125){
			obj.style.left=obj.offsetLeft + 350 + 20;
			window.setTimeout("flyout(get_object_by_oid('"+obj.id+"'));",0);
		}else{
			obj.style.left=1125;
			obj.style.zIndex=0;
			flyin(id(obj.id));
		}
	}
}

function flyin(obj){
	if(obj.offsetLeft<75){
		if((obj.offsetLeft + 350 + 20) < 425){
			obj.style.left=obj.offsetLeft + 350 + 20;
			window.setTimeout("flyin(get_object_by_oid('"+obj.id+"'));",0);
		}else{
			obj.style.left=425;
			en=false;
		}
	}
	if(obj.offsetLeft>75){
		if((obj.offsetLeft + 350 - 20) > 425 ){
			obj.style.left=obj.offsetLeft + 350 - 20;
			window.setTimeout("flyin(get_object_by_oid('"+obj.id+"'));",0);
		}else{
			obj.style.left=425;
			en=false;
		}
	}
}