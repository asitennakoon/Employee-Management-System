window.onload = function () {
    document.getElementById("delete").addEventListener("submit",
            confirmFunction);

    function confirmFunction(event) {
        if (!confirm("Are you sure?")) {
            event.preventDefault();
        }
    }

}