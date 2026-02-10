let rates = {
    Single: 5000,
    Double: 8000,
    Suite: 12000
};

const currentRates = document.getElementById("currentRates");
const rateMessage = document.getElementById("rateMessage");

function displayRates() {
    currentRates.innerHTML = `
        <li>Single: ${rates.Single}</li>
        <li>Double: ${rates.Double}</li>
        <li>Suite: ${rates.Suite}</li>
    `;
}

displayRates();

document.getElementById("rateForm").addEventListener("submit", function(e){
    e.preventDefault();

    const single = document.getElementById("singleRate").value;
    const double = document.getElementById("doubleRate").value;
    const suite = document.getElementById("suiteRate").value;

    if(!single || !double || !suite){
        rateMessage.textContent = "Fill all fields!";
        rateMessage.style.color = "red";
        return;
    }

    rates = {
        Single: parseInt(single),
        Double: parseInt(double),
        Suite: parseInt(suite)
    };

    rateMessage.textContent = "Rates updated successfully!";
    rateMessage.style.color = "green";
    displayRates();
    this.reset();
});
