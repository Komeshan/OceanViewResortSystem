document.getElementById('calculateBtn').addEventListener('click', function() {
    const resNumber = document.getElementById('resNumber').value;
    const resultDiv = document.getElementById('billResult');

    if (!resNumber) {
        resultDiv.textContent = "Please enter a reservation number!";
        resultDiv.style.color = "red";
        return;
    }

    fetch(`/OceanViewResort/viewReservation?id=${resNumber}`)
        .then(response => {
            if (!response.ok) throw new Error("Reservation not found");
            return response.json();
        })
        .then(data => {
            // Calculate number of nights
            const checkIn = new Date(data.checkIn);
            const checkOut = new Date(data.checkOut);
            const diffTime = Math.abs(checkOut - checkIn);
            const nights = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

            // Get rate from room type
            let roomRate = 0;
            switch(data.roomType) {
                case "Single": roomRate = rates.Single; break;
                case "Double": roomRate = rates.Double; break;
                case "Suite": roomRate = rates.Suite; break;
                default: roomRate = 0;
            }

            const total = nights * roomRate;

            resultDiv.innerHTML = `
                Guest: ${data.guestName}<br>
                Room Type: ${data.roomType}<br>
                Check-in: ${data.checkIn}<br>
                Check-out: ${data.checkOut}<br>
                Nights: ${nights}<br>
                Total Bill: Rs. ${total}
            `;
            resultDiv.style.color = "green";
        })
        .catch(err => {
            resultDiv.textContent = err.message;
            resultDiv.style.color = "red";
        });
});