// Staff management functionality
const staffForm = document.getElementById('staffForm');
const staffList = document.getElementById('staffList');
const staffMessage = document.getElementById('staffMessage');

let staffArray = [];

staffForm.addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('staffName').value;
    const username = document.getElementById('staffUsername').value;
    const password = document.getElementById('staffPassword').value;

    // Basic validation
    if(!name || !username || !password){
        staffMessage.textContent = "Please fill all fields!";
        staffMessage.style.color = "red";
        return;
    }

    // Add to staff array
    const staff = { name, username, password };
    staffArray.push(staff);

    // Update list
    renderStaffList();

    staffMessage.textContent = "Staff added successfully!";
    staffMessage.style.color = "green";

    // Reset form
    staffForm.reset();
});

function renderStaffList(){
    staffList.innerHTML = "";
    staffArray.forEach((staff, index) => {
        const li = document.createElement('li');
        li.textContent = `${staff.name} (Username: ${staff.username})`;
        staffList.appendChild(li);
    });
}

// Back button function
function goBack(){
    window.history.back();
}
