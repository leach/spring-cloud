;!function(win){
  BaseUtil = function(){  
  },
  /**
   * 重置接口返回数据格式
   */
  BaseUtil.prototype.parsedata = function (res) { //res 即为原始返回的数据
    return {
      "code": res.code, //解析接口状态
      "msg": res.msg, //解析提示文本
      "count": res.totalCount, //解析数据长度
      "data": res.data.list //解析数据列表
    };
  },
  BaseUtil.prototype.isEmpty = function (v) { //res 即为原始返回的数据
    return v == null || v == "";
  }
  win.baseUtil = new BaseUtil();
}(window)
