<script th:inline="javascript">

    /*<![CDATA[*/

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $(document).ready(function(){
    $("#searchbtn").on("click", function(ev) {
        $.ajax({
            url : "/setSearch/search",
            type : "post",
            data : {
                "newSearch" : $("#newSearch").val()
            },
            success : function(data) {
                console.log(data);
            },
            error : function() {
                console.log("There was an error");
            }

        });
    });
  });
/*]]>*/
</script>