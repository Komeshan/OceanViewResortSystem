document.getElementById("loginForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Simple client-side check (replace with backend authentication later)
    if(username === "admin" && password === "1234") {
        window.location.href = "reservation.html";
    } else {
        document.getElementById("loginMessage").innerText = "Invalid username or password!";
    }
});
