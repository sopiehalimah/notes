angular.module('aplikasiSpringboot')
        .factory('homeService', function ($http){
            return {
                    getNotes: function (){
                            return $http.get("/notes");
                        },
                    getListNotes: function (){
                            return $http.get("/listNotes");
                    },
                    getNotesFromDb:function (){
                        return $http.get("/api/notes");
                    },
                    save: function (data){
                        return $http.post("/api/notes",data);
                    },
                    delete:function(id){
                        return $http.delete("/api/notes/"+id);
                    },
                    update:function(id,data){
                        return $http.put("/api/notes/"+id,data);
                    },
                    getLoggedIn:function(){
                        return $http.get("/api/user/loggedin");
                    }
            };
});


