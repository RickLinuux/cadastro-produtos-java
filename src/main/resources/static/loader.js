function showLoading() {
    var loadingModal = new
    bootstrap.Modal(document.getElementById('loadingModal'));
    loadingModal.show();


    setTimeout(function() {
        document.querySelector('form').submit();
    }, 1000);

    return false; 
}

function confirmDelete(url) {
    if (confirm("Tem certeza que deseja excluir este produto?")) {
        showLoading();
        setTimeout(function() {
            window.location.href = url;
        }, 1000);
    }
    return false;
}

