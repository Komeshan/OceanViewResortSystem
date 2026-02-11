// Room rates (must match your roomRates.js defaults)
const roomRates = {
    Single: 5000,
    Double: 8000,
    Suite: 12000
};

document.getElementById("viewReservationForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const resNumber = document.getElementById("reservationNumber").value;
    const resultDiv = document.getElementById("reservationResult");

    if (!resNumber) {
        resultDiv.textContent = "Please enter a reservation number.";
        return;
    }

    fetch(`/OceanViewResort/viewReservation?reservationNumber=${resNumber}`)
        .then(response => response.text())
        .then(data => {
            if (data.includes("Reservation not found") || data.includes("Error")) {
                resultDiv.textContent = data;
                return;
            }

            // Display reservation info
            resultDiv.textContent = data;

            // Parse the check-in and check-out dates from the response
            const lines = data.split("\n");
            let roomType = "";
            let checkIn = "";
            let checkOut = "";

            lines.forEach(line => {
                if (line.startsWith("Room Type:")) roomType = line.split(":")[1].trim();
                if (line.startsWith("Check-In:")) checkIn = line.split(":")[1].trim();
                if (line.startsWith("Check-Out:")) checkOut = line.split(":")[1].trim();
            });

            if (roomType && checkIn && checkOut) {
                // Calculate number of nights
                const checkInDate = new Date(checkIn);
                const checkOutDate = new Date(checkOut);
                const diffTime = Math.abs(checkOutDate - checkInDate);
                const nights = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

                // Calculate total
                const rate = roomRates[roomType] || 0;
                const total = rate * nights;

                // Append total bill
                resultDiv.textContent += `\nNumber of Nights: ${nights}`;
                resultDiv.textContent += `\nTotal Bill: Rs. ${total}`;
            }
        })
        .catch(err => {
            resultDiv.textContent = "Error fetching reservation: " + err;
        });
});