// Get reservation number from query string
const params = new URLSearchParams(window.location.search);
const resNumber = params.get("reservationNumber");

const invoiceDiv = document.getElementById("invoiceDetails");

if (!resNumber) {
    invoiceDiv.innerHTML = "<p style='color:red;'>No reservation selected!</p>";
} else {
    // Fetch reservation details from backend
    fetch(`/OceanViewResort/viewReservation?reservationNumber=${resNumber}`)
        .then(response => response.json())
        .then(data => {
            if (!data) {
                invoiceDiv.innerHTML = "<p style='color:red;'>Reservation not found!</p>";
                return;
            }

            // Calculate number of nights
            const checkIn = new Date(data.checkIn);
            const checkOut = new Date(data.checkOut);
            const timeDiff = checkOut - checkIn;
            const nights = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));

            // Define room rates (same as your JS rates object)
            const rates = {
                Single: 5000,
                Double: 8000,
                Suite: 12000
            };

            const roomRate = rates[data.roomType] || 0;
            const total = nights * roomRate;

            invoiceDiv.innerHTML = `
                <div class="invoice-item"><strong>Reservation Number:</strong> ${data.reservationNumber}</div>
                <div class="invoice-item"><strong>Guest Name:</strong> ${data.guestName}</div>
                <div class="invoice-item"><strong>Contact:</strong> ${data.contact}</div>
                <div class="invoice-item"><strong>Room Type:</strong> ${data.roomType}</div>
                <div class="invoice-item"><strong>Check-in:</strong> ${data.checkIn}</div>
                <div class="invoice-item"><strong>Check-out:</strong> ${data.checkOut}</div>
                <div class="invoice-item"><strong>Nights:</strong> ${nights}</div>
                <div class="invoice-item"><strong>Rate per Night:</strong> ${roomRate}</div>
                <div class="total">Total Amount: Rs ${total}</div>
            `;
        })
        .catch(err => {
            invoiceDiv.innerHTML = "<p style='color:red;'>Error fetching reservation!</p>";
            console.error(err);
        });
}

function goBack() {
    window.history.back();
}