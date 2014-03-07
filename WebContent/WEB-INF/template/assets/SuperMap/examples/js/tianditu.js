
    var map=null,markerLayer=null,lyvec,lyimg,lylblv,lylbli,projection="EPSG:4326",maptype="vec",level=10;
	var sigleMarker=null;
    function dowork(){
        map = new SuperMap.Map("map", { controls:[
            new SuperMap.Control.Attribution(),
            new SuperMap.Control.ScaleLine(),
            new SuperMap.Control.Zoom(),
//            new SuperMap.Control.OverviewMap(),
            new SuperMap.Control.Navigation({
                dragPanOptions:{
                    enableKinetic:true
                }
            })],
            allOverlays:true,
            projection:projection//"EPSG:900913"//
        });
        
    
        lyvec=new SuperMap.Layer.Tianditu({"layerType":"vec"});//img,ter
        lyvec.name="vec";
        lyimg = new SuperMap.Layer.Tianditu({"layerType":"img"});//img,ter
        lyimg.name="img";
        lylblv = new SuperMap.Layer.Tianditu({"layerType":"vec","isLabel":true});
        lylblv.name="lblvec";
        lylbli = new SuperMap.Layer.Tianditu({"layerType":"img","isLabel":true});
        lylbli.name="lblimg";
        markerLayer = new SuperMap.Layer.Markers("Markers");
        map.addLayers([lyvec,markerLayer,lylblv,lylbli]);
        map.setCenter(new SuperMap.LonLat(112.56987,37.894834), level);
        
	}

	this.addEventListener=function(type){
		switch(type){
			case "marker_sigle":{
				$("#map").one("click",function(e){
		        	if(markerLayer==null)return;
		        	markerLayer.clearMarkers();
		        	var l=e.pageX-$(this).position().left;
		        	var t=e.pageY-$(this).position().top;
		        	var pix=new SuperMap.Pixel(
		        			parseFloat(l),parseFloat(t));
		        	var pt=map.getLonLatFromPixel(pix);
		        	addSingleSimpleMarker(pt.lon,pt.lat);
		        });
				break;
			}
		};
		
	};
	
	this.addSingleSimpleMarker=function(lon,lat){
		
		var size = new SuperMap.Size(32, 32);
		var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
		var icon = new SuperMap.Icon("assets/SuperMap/examples/images/markerbig_select.png", size, offset);
		var marker = new SuperMap.Marker(new SuperMap.LonLat(lon,lat),icon);
		marker.id = "single";
		marker.events.on({
			   //"click":openInfoWin,
			   "scope": marker
			});
		sigleMarker=marker;
		markerLayer.addMarker(marker);
	};
	
	this.addMarker=function(id,lon,lat,attr){
		var size = new SuperMap.Size(32, 32);
		var offset = new SuperMap.Pixel(-(size.w / 2), -(size.h/2));
		//var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
		var icon = new SuperMap.Icon("assets/img/marker/"+
				markerNameFormater(attr.industry,attr.projecttype), size, offset);
		var marker = new SuperMap.Marker(new SuperMap.LonLat(lon,lat),icon);
		if(id==null||id=="null"||id==""){
			id="mark_"+markerLayer.markers.length+1;	
		}
		marker.id = id;
		marker.events.on({
			   "click":openInfoWin,
			   "scope": marker
			});
		marker.attr=attr;
		markerLayer.addMarker(marker);
	};
	
	function markerNameFormater(industry,type){
//		一、农林水利,
//		二、城建环保
//		三、服务业
//		四、社会事业
//		五、交通
//		六、旅游
//		七、煤层气、天然气
//		八、工业
//		1、煤炭 
//		2、电力
//		3、冶金
//		4、焦化
//		5、煤化工
//		6、装备制造
//		7、材料工业
//		8、高新技术
//		9、医药及其它
//		九、其它

		var rename="",level="";
		switch(industry){
			case "一、农林水利":
			case "（一）农林水利":
			{
				rename="10";
			}break;
			case "二、城建环保":
			case "（二）城建环保":{
				rename="20";
			}break;
			case "三、服务业":
			case "（三）服务业":{
				rename="30";
			}break;
			case "四、社会事业":
			case "（四）社会事业":{
				rename="40";
			}break;
			case "五、交通":
			case "（五）交通":{
				rename="50";
			}break;
			case "六、旅游":
			case "（六）旅游":{
				rename="60";
			}break;
			case "七、煤层气、天然气":
			case "（七）煤层气、天然气":{
				rename="70";
			}break;
			case "八、工业":
			case "（八）工业":{
				rename="80";
			}break;
			case "1、煤炭":{
				rename="81";
			}break;
			case "2、电力":{
				rename="82";
			}break;
			case "3、冶金":{
				rename="83";
			}break;
			case "4、焦化":{
				rename="84";
			}break;
			case "5、煤化工":{
				rename="85";
			}break;
			case "6、装备制造":{
				rename="86";
			}break;
			case "7、材料工业":{
				rename="87";
			}break;
			case "8、高新技术":{
				rename="88";
			}break;
			case "9、医药及其它":{
				rename="89";
			}break;
			case "九、其它":
			case "（九）其它":{
				rename="90";
			}break;
			default:rename="90";
		}
		switch(type){
			case "初步意向":{
				level="1";
			}break;
			case "策划项目":{
				level="2";
			}break;
			case "前期工作项目":{
				level="3";
			}break;
			case "当年可开工项目":{
				level="4";
			}break;
			case "在建项目":{
				level="5";
			}break;
			default: level="1";
		}
		
		return rename+"-"+level+".png";
	};
	
	
	function clearMarkers(){
		markerLayer.clearMarkers();
		sigleMarker=null;
	}
	var popup;
	function openInfoWin(){
		var marker=this;
		var lonlat = marker.getLonLat();
		
	    var contentHTML = "<div style=\'font-size:.8em; opacity: 0.8; overflow-y:hidden;\'>";
	    contentHTML += "<div></div>";
	    contentHTML += "<div>"+marker.attr.name+"<br/></div>";
	    contentHTML += "<div>隶属行业："+validString(marker.attr.industry)+"</div>";
	    contentHTML += "<div>总投资 ："+validString(marker.attr.investall)+"万元</div>";
	    contentHTML += "<div>项目类别："+validString(marker.attr.projecttype)+"</div>";
	    contentHTML += "</div>";
	    if(popup){
	    	 map.removePopup(popup);
	    }
	    popup = new SuperMap.Popup.FramedCloud("popwin",
	    		new SuperMap.LonLat(lonlat.lon,lonlat.lat),
	    		null,
	    		contentHTML,
	    		null,
	    		true);
	  
	    if(popup){
	    	 map.removePopup(popup);
	    }
        map.addPopup(popup);
       
    };
    
    function validString(va){
    	if(!va){
    		va="";
		}
    	return va;
    }
    
    function addColumns(){

    	//小店区,迎泽区,杏花岭区,尖草坪区,万柏林区,晋源区,清徐县,阳曲县,娄烦县,古交市
//    	尖草坪：112.475263,37.947438
//		万柏林区：112.519819,37.86544
//    	迎泽区：112.568112,37.869428
//    	古交：112.178894,37.913853
//    	阳曲：112.676771,38.068557
//    	娄烦：111.796,38.079464
//    	杏花岭：112.576735,37.901098
//    	晋源区：112.481299,37.722294
//    	小店：112.570986,37.743299
//    	清徐县：112.373215,37.611692
    	var size = new SuperMap.Size(50, 50);
		var offset = new SuperMap.Pixel(-(size.w / 2), -size.h);
		var zones="[";
		zones+="{\"name\":\" 尖草坪区\",\"location\":\"112.475263,37.947438\"},";
		zones+="{\"name\":\" 迎泽区\",\"location\":\"112.568112,37.869428\"},";
		zones+="{\"name\":\" 万柏林区\",\"location\":\"112.519819,37.86544\"},";
		zones+="{\"name\":\" 古交市\",\"location\":\"112.178894,37.913853\"},";
		zones+="{\"name\":\" 阳曲县\",\"location\":\"112.676771,38.068557\"},";
		zones+="{\"name\":\" 娄烦\",\"location\":\"111.796,38.079464\"},";
		zones+="{\"name\":\" 杏花岭区\",\"location\":\"112.576735,37.901098\"},";
		zones+="{\"name\":\" 晋源区\",\"location\":\"112.481299,37.722294\"},";
		zones+="{\"name\":\" 小店区\",\"location\":\"112.570986,37.743299\"},";
		zones+="{\"name\":\" 清徐县\",\"location\":\"112.373215,37.611692\"},";
		zones=zones.substring(0, zones.length-1)+"]";
		var jzs=$.parseJSON(zones);
		//alert(jzs);
		$.each(jzs,function(i,obj){
			icon= new SuperMap.Icon("assets/img/columns/"+i+".png", size, offset);
			marker = new SuperMap.Marker(new SuperMap.LonLat(
										obj.location.split(",")[0],
										obj.location.split(",")[1]),icon);
			marker.id="column_"+i;
			marker.events.on({
				   "scope": marker
				});
			//marker.attr=attr;
			markerLayer.addMarker(marker);
		});
		
		
    }
    dowork();
