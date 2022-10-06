$(function () {
    $('#genreTableId').DataTable();

    $('#newBtnId').val('New Genre');

    $('#newGenreDialogId').dialog({
        title: 'New Genre',
        modal: true,
        autoOpen: false,
        height: 400,
        width: 400,
        buttons: {
            "Save": function () {
                addGenre();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newBtnId').click(function () {
        $('#newGenreDialogId').load('views/newGenre.jsp', function () {
            $(this).dialog('open');
        });
    })

});

function addGenre() {
    let name = $('#nameId').val();

    let request = {
        name: name,
    };

    $.ajax({
        url: 'gs?action=addGenre',
        type: 'POST',
        data: request,
        dataType: 'text', // xml, json , text , html
        success: function (response) {
            if (response == 'success') {
                alert('Genre has been successfully added!');
                getGenreList();
            } else {
                alert('Problem!Genre has not been successfully added!');
            }
        }
    });

}

function getGenreList() {

    $.ajax({
        url: 'gs?action=getGenreData',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }

    })

}