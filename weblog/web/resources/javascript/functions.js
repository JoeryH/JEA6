function onClickComment(id) {
    $.get("/weblog/comments?id=" + id, function (data) {
        var html = "";
        $(data).find('comment').each(function () {
            html += "<div class=\"comment\">";
            html += $(this).find('content').text();
            html += "</div></br>";
        });
        html += "<br/></div><br/><br/><form method=\"POST\" action=\"weblog/addComment\" class=\"center\" id=\"commentForm\">";
        html += "<input type=\"text\" name=\"comment\" id=\"comment\"/> <br/>";
        html += "<input type=\"submit\" value=\"add Comment\"/>";
        html += "<input type=\"hidden\" name=\"id\" id=\"addCommentButton\" value=\"" + id + "\"/>";
        html += "</form>";

        $("#comments" + id).html(html);
        
        $("#commentForm").unbind();
        $.getScript("/weblog/resources/javascript/postform.js");
    });
}
