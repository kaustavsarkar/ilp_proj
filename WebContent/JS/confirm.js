function deleteRecord(id){
	
    var doIt=confirm('Do you want to delete the record?');
  if(doIt){
   var f=document.deleteconfirm;
    f.method="post";
    alert("Before action.");
    f.action='../AdminController?Id='+id;
    alert("INto validate after action.");
    f.submit();
    }
  else{
	  //window.location.href="<%=request.getContextPath()%>/jsp/view.jsp";
  }
}
