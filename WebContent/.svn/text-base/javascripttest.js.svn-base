$(document).ready(function() {
 $("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('PopulateTable',function(responseJson) {
            if(responseJson!=null){
                $("#countrytable").find("tr:gt(0)").remove();
                var table1 = $("#countrytable");
                $.each(responseJson, function(key,value) { 
                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text(value['code']); 
                        rowNew.children().eq(1).text(value['name']); 
                        rowNew.children().eq(2).text(value['continent']); 
                        rowNew.children().eq(3).text(value['region']); 
                        rowNew.children().eq(4).text(value['population']); 
                        rowNew.children().eq(5).text(value['capital']); 
                        rowNew.appendTo(table1);
                });
                }
            });
            $("#tablediv").show();          
  });      
});