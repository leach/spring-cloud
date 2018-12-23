;!function(win){
    Api = function(){  
    },
    Api.prototype.url = {
        saveprofile: "http://localhost:8080/props/profile/add"
    }
    win.api = new Api();
  }(window)
  