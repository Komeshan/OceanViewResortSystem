window.onload = function() {
    const params = new URLSearchParams(window.location.search);
    const messageDiv = document.getElementById("message");

    if (params.get("success") === "true") {
        messageDiv.textContent = "Guest added successfully!";
        messageDiv.style.color = "green";
    } else if (params.get("error") === "true") {
        messageDiv.textContent = "Error adding guest. Try again.";
        messageDiv.style.color = "red";
    }
};

function goBack() {
    window.history.back();
}
