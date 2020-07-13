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

            
            // UI Components Initialize
            obj = new Grid("Grid00","43","155","502","311",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj._setContents("");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","44","80","171","51",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Combo00");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","245","80","100","50",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","395","80","150","51",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검색");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","732","155","118","51",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("부서입력폼");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","732","232","133","38",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("부서번호");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","733","310","137","36",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("부서명");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","733","371","127","39",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("부서위치");
            this.addChild(obj.name, obj);

            obj = new Edit("deptnov","894","232","223","38",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            this.addChild(obj.name, obj);

            obj = new Edit("dnamev","890","310","223","36",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            this.addChild(obj.name, obj);

            obj = new Edit("locv","890","372","223","38",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","722","433","158","47",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("입력");
            this.addChild(obj.name, obj);

            obj = new Button("Button01_00","890","433","216","47",null,null,null,null,null,null,this);
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

        this.Button01_00_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Button01_00.addEventHandler("onclick",this.Button01_00_onclick,this);
        };

        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
