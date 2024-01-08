function showConfirmTable(content, id, action){
    document.getElementById("confirmTable").style.display = "grid";
    document.getElementById("content").innerHTML = content;
    document.getElementById("confirmId").value = id;
    document.getElementById("confirmAction").value = action;
}
function closeConfirmTable(){
    document.getElementById("confirmTable").style.display = "none";
}
function confirmTable(){
    let id = +document.getElementById("confirmId").value;
    let action = document.getElementById("confirmAction").value;
    switch (action) {
        case "delete":
            window.location.href = `/delete/` + id;
            break;

    }
}
function create(){
    window.location.href = "/create";
}
function backToMainPage(){
    window.location.href = "/";
}
function deleteProduct(id, name){
    showConfirmTable("delete " + name, id, 'delete');
}
function editProduct(id){
    let title = document.getElementById("title" + id).innerHTML;
    let type = document.getElementById("type" + id).innerHTML;
    let content = document.getElementById("content" + id).innerHTML;
    let date = document.getElementById("date" + id).innerHTML;
    let own = document.getElementById("own" + id).innerHTML;

    document.getElementById("tieu_de").innerHTML = title;
    document.getElementById("danh_muc").innerHTML = type;
    document.getElementById("noi_dung").innerHTML = content;
    document.getElementById("ngay_dang").innerHTML = date;
    document.getElementById("phong_vien").innerHTML = own;

    document.getElementById("detail-table").style.display = "grid";
}
function closeTable(){
    document.getElementById("detail-table").style.display = "none";

}
function search(){
    let keyword = document.getElementById("search").value;
    window.location.href = `?key=${keyword}`;
}
function checkDate(){
    let date = document.getElementById("dateInput").value;
    let alertText = document.getElementById("checkDate");
    let dateInput = new Date(date);
    let now = new Date();
    if (dateInput > now){
        alertText.innerHTML = "Ngày không được sau thời gian hiện tại"
    } else {
        alertText.innerHTML = "";
    }
}