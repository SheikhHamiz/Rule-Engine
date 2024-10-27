
const elem  = document.getElementById("userForm");
elem.addEventListener("submit", validateUser);
const BASE_URL = "http://localhost:8080";
async function validateUser(e) {
    e.preventDefault();
    let response  = await fetch(`${BASE_URL}/checkUser`,{
        method:"POST",
        body:JSON.stringify({
            age:parseInt(document.getElementById("age").value),
            salary:parseInt(document.getElementById("salary").value),
            experience:parseInt(document.getElementById("experience").value),
            department:document.getElementById("department").value,
        }),
        headers: {
            "Content-Type": "application/json",
        },
    });
    if(response.body === false) {
        document.querySelector(".warning").textContent = "Invalid user";
    }  {
        document.querySelector(".warning").textContent = "valid user";
    }
}