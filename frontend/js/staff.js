const staffList = document.getElementById('staffList');
const staffMessage = document.getElementById('staffMessage');

// Fetch staff list from backend
function fetchStaff() {
    fetch('/OceanViewResort/viewStaff')
    .then(res => res.json())
    .then(data => {
        staffList.innerHTML = '';
        data.forEach(staff => {
            const li = document.createElement('li');
            li.textContent = `${staff.name} (Username: ${staff.username})`;
            staffList.appendChild(li);
        });
    })
    .catch(err => console.error(err));
}

// Initial load
fetchStaff();

// Back button function
function goBack(){
    window.history.back();
}