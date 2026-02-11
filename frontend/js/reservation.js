// Add reservation
document.getElementById('reservationForm').addEventListener('submit', function(e){
    // let form submit normally to servlet
    const messageDiv = document.getElementById('reservationMessage');
    messageDiv.textContent = "Submitting...";
    messageDiv.style.color = "black";
});

// View reservation
document.getElementById('viewReservationBtn').addEventListener('click', function(){
    const id = document.getElementById('viewResNumber').value;
    const resultDiv = document.getElementById('viewReservationResult');

    if(!id){
        resultDiv.textContent = "Enter reservation number!";
        resultDiv.style.color = "red";
        return;
    }

    fetch(`/OceanViewResort/viewReservation?id=${id}`)
    .then(res => res.json())
    .then(data => {
        if(!data){
            resultDiv.textContent = "Reservation not found!";
            resultDiv.style.color = "red";
        } else {
            resultDiv.innerHTML = `
                <p><strong>Reservation Number:</strong> ${data.reservationNumber}</p>
                <p><strong>Name:</strong> ${data.guestName}</p>
                <p><strong>Address:</strong> ${data.address}</p>
                <p><strong>Contact:</strong> ${data.contact}</p>
                <p><strong>Room Type:</strong> ${data.roomType}</p>
                <p><strong>Check-in:</strong> ${data.checkIn}</p>
                <p><strong>Check-out:</strong> ${data.checkOut}</p>
            `;
        }
    })
    .catch(err => {
        resultDiv.textContent = "Error fetching reservation!";
        resultDiv.style.color = "red";
        console.error(err);
    });
});
