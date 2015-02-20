$("#commentForm").submit(function (event) {
    event.preventDefault();

    var $form = $(this),
            id = $form.find("input[name='id']").val(),
            comment = $form.find("input[name='comment']").val(),
            url = $form.attr("action");
            
    $.post( url, { id: id, comment: comment } );

    onClickComment(id);
})