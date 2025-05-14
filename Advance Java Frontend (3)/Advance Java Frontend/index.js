let loginbtn = document.getElementById("loginbtn")
let logoutbtn = document.getElementById("logoutbtn");
let mycoursesBtn = document.getElementById("mycoursesBtn");

let admreg = document.getElementById("admreg");
let studreg = document.getElementById("studreg");

let login=document.getElementById("login")
let loginOptions=document.getElementById("loginOptions")

let register = document.getElementById("register");
let registerOptions = document.getElementById("registerOptions");

let role = localStorage.getItem("role");

if(localStorage.getItem("id")==null)
{
    logoutbtn.style.display = "none"
}
else{
    login.style.display = "none"
}
register.addEventListener("mouseenter", () => {
    registerOptions.style.display = "block";
    
 });

register.addEventListener("mouseleave", () => {
    registerOptions.style.display = "none";
});

if (role === "Admin") {
    studreg.style.display = "none";
    admreg.style.display = "block";
    mycoursesBtn.style.display = "none";
} else if (role === "Student") {
    admreg.style.display = "none";
    studreg.style.display = "block";
    mycoursesBtn.style.display = "block";
}


logoutbtn.addEventListener("click",()=>{
    localStorage.clear();
    window.close()
})


let profilebtn = document.getElementById("profilebtn")
profilebtn.addEventListener("click",()=>{
    let id = localStorage.getItem("id");
    console.log("id is "+id);
    if(id==null)
    {
        alert("Please Login")
    }
    else{
        window.open("./profile.html")
    }
})


if(localStorage.getItem("id")==null)
{
    logoutbtn.style.display = "none"
    mycoursesBtn.style.display = "none";
}
else{
    loginbtn.style.display = "none"
}

logoutbtn.addEventListener("click",()=>{
    localStorage.clear();
    window.close()
})



login.addEventListener("mouseenter",()=>{
    loginOptions.style.display="block";
})
login.addEventListener("mouseleave",()=>{
    loginOptions.style.display="none"
})