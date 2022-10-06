$(function () {
    $('#authorTableId').DataTable();

    $('#newBtnId').val('New Author');

    $('#newAuthorDialogId').dialog({
        title: 'New Author',
        modal: true,
        autoOpen: false,
        height: 400,
        width: 400,
        buttons: {
            "Save": function () {
                addAuthor();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newBtnId').click(function () {
        $('#newAuthorDialogId').load('views/newAuthor.jsp', function () {
            $(this).dialog('open');
        });

    })

});

function addAuthor() {
    let name = $('#nameId').val();
    let surname = $('#surnameId').val();
    let dob = $('#dobId').val();

    let request = {
        name: name,
        surname: surname,
        dob: dob,
    };

    $.ajax({
        url: 'as?action=addAuthor',
        type: 'POST',
        data: request,
        dataType: 'text', // xml, json , text , html
        success: function (response) {
            if (response == 'success') {
                alert('Author has been successfully added!');
                getAuthorList();
            } else {
                alert('Problem!Author has not been successfully added!');
            }
        }
    });

}

function getAuthorList() {

    $.ajax({
        url: 'as?action=getAuthorData',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }

    })

}