const elem  = document.getElementById("add-rule-form");
elem.addEventListener("submit", addRule);
const BASE_URL = "http://localhost:8080";
async function addRule(e) {
    e.preventDefault();
    let response  = await fetch(`${BASE_URL}/addRule`,{
        method:"POST",
        body:JSON.stringify({
            expression: document.getElementById("rule").value
        }),
        headers: {
            "Content-Type": "application/json",
        },
    });
    if(response.status !== 200) {
        document.querySelector(".warning").textContent = "Invalid syntax";
    }  {
        document.querySelector(".warning").textContent = "Rule Added";
    }
}
