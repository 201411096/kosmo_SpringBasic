(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsdept", this);
            obj._setContents("<ColumnInfo><Column id=\"deptno\" type=\"INT\" size=\"10\"/><Column id=\"dname\" type=\"STRING\" size=\"20\"/><Column id=\"loc\" type=\"STRING\" size=\"20\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","43","155","502","311",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("dsdept");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"deptno\"/><Cell col=\"1\" text=\"dname\"/><Cell col=\"2\" text=\"loc\"/></Band><Band id=\"body\"><Cell text=\"bind:deptno\"/><Cell col=\"1\" text=\"bind:dname\"/><Cell col=\"2\" text=\"bind:loc\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Combo("selectoption","44","80","171","51",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var selectoption_innerdataset = new nexacro.NormalDataset("selectoption_innerdataset", obj);
            selectoption_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">0</Col><Col id=\"datacolumn\">부서명</Col></Row><Row><Col id=\"codecolumn\">1</Col><Col id=\"datacolumn\">부서번호</Col></Row><Row><Col id=\"codecolumn\">2</Col><Col id=\"datacolumn\">부서위치</Col></Row></Rows>");
            obj.set_innerdataset(selectoption_innerdataset);
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Edit("searchword","245","80","100","50",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","395","80","150","51",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검색");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","579","135","118","51",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("부서입력폼");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","579","212","133","38",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("부서번호");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","580","290","137","36",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("부서명");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","580","351","127","39",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("부서위치");
            this.addChild(obj.name, obj);

            obj = new Edit("deptnov","741","212","223","38",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            this.addChild(obj.name, obj);

            obj = new Edit("dnamev","737","290","223","36",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            this.addChild(obj.name, obj);

            obj = new Edit("locv","737","352","223","38",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","569","413","158","47",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("입력");
            this.addChild(obj.name, obj);

            obj = new Button("Button01_00","737","413","216","47",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("출력");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        // 출력 버튼이 눌렸을 떄
        this.Button01_00_onclick = function(obj,e)
        {
        		this.transaction(
        		"urlTest01",	//strSvcID,
        		"strURL::all",	//strURL("http://localhost:8080/step01/all" 직접 링크는 됨)
        		"",	        //strInDatasets,
        		"dsdept=ar",  //strOutDatasets 데이터셋에 바인딩 될 부분,
        		"",		//"deptno=10dname=총무부", //strArgument  이부분은 파라미터 ,
        		"fn_callback"     //strCallbackFunc[,bAsync[,nDataType[,bCompress]]]
        	);
        	this.fn_callback = function(svcID, errCD, errMSG){
        		let ret = (errMSG=="FAILED" || svcID != "urlTest01") ? "error" : "success";
        		if(ret=="error")
        			this.alert("[폼이름_fn_callback] "+ret + " : " + svcID + ", " + errCD + ", " + errMSG);
        		else
        			this.alert(ret);
        	};

        };
        // 입력 버튼이 눌렸을 때
        this.Button01_onclick = function(obj,e)
        {
        	var deptno_val =  encodeURI(this.deptnov.value,"UTF-8");
        	var deptname_val = encodeURI(this.dnamev.value,"UTF-8");
        	var deptloc_val = encodeURI(this.locv.value,"UTF-8");
        	this.alert(deptno_val + ":"+ deptname_val)
        	var id = "urlTest02";
        	//var url = "strURL::deptAdd;
        	var url ="http://192.168.0.18:8080/step01/deptAdd?deptno="+deptno_val+"&dname="+deptname_val+"&loc="+deptloc_val;
        	var reqDs = "";
        	var respDs = "";
        	var args = "";
        	var callback = "received";
        	this.transaction(id, url, reqDs, respDs, args, callback);
        	this.received = function(id, code, message)
        	{
        		 alert(code);
        	}
        };

        this.Button00_onclick = function(obj,e)
        {
        	var selectopiton_val = encodeURI(this.selectoption.value);
        	var searchword_val = encodeURI(this.searchword.value);
        	console.log(selectopiton_val);
        	console.log(searchword_val);

        	this.transaction(
        		"urlTest03",	//strSvcID,
        		"strURL::http://192.168.0.18:8080/step01/selectwithoption?searchword="+searchword_val+"&selectoption="+selectopiton_val,	//strURL("http://localhost:8080/step01/all" 직접 링크는 됨)
        		"",	        //strInDatasets,
        		"dsdept=ar",  //strOutDatasets 데이터셋에 바인딩 될 부분,
        		"",		//"deptno=10dname=총무부", //strArgument  이부분은 파라미터 ,
        		"fn_callback"     //strCallbackFunc[,bAsync[,nDataType[,bCompress]]]
        	);
        	this.fn_callback = function(svcID, errCD, errMSG){
        		let ret = (errMSG=="FAILED" || svcID != "urlTest01") ? "error" : "success";
        	};
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
            this.Button01_00.addEventHandler("onclick",this.Button01_00_onclick,this);
        };

        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
