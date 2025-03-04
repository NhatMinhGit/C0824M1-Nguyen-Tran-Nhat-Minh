function openModal(imageSrc) {
    document.getElementById("modalImage").src = imageSrc;
    var myModal = new bootstrap.Modal(document.getElementById('imageModal'));
    myModal.show();
}
