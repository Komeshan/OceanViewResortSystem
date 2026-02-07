document.getElementById('reservationForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const address = document.getElementById('address').value;
    const contact = document.getElementById('contact').value;
    const roomType = document.getElementById('roomType').value;
    const checkIn = document.getElementById('checkIn').value;
    const checkOut = document.getElementById('checkOut').value;

    const messageDiv = document.getElementById('message');

    // Basic validation
    if (!name || !address || !contact || !roomType || !checkIn || !checkOut) {
        messageDiv.textContent = "Please fill in all fields!";
        messageDiv.style.color = "red";
        return;
    }

    messageDiv.textContent = "Reservation added successfully!";
    messageDiv.style.color = "green";

    // Reset form
    this.reset();
});
