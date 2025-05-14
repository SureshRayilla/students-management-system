let id=localStorage.getItem("id");
let fname=localStorage.getItem("fname")
let lname=localStorage.getItem("lname")
let email=localStorage.getItem("email")
let password=localStorage.getItem("password")
let address=localStorage.getItem("address")
let mobileNumber=localStorage.getItem("mobileNumber")
let role=localStorage.getItem("role")

let fnameInput=document.getElementById("fnameInput");
let lnameInput=document.getElementById("lnameInput")
let idInput=document.getElementById("idInput")
let emailInput=document.getElementById("emailInput")
let passwordInput=document.getElementById("passwordInput")
let addressInput=document.getElementById("addressInput")
let mobileNumberInput=document.getElementById("mobileNumberInput")

fnameInput.value=fname
lnameInput.value=lname
idInput.value=id
emailInput.value=email
passwordInput.value=password
addressInput.value=address
mobileNumberInput.value=mobileNumber

let updateBtn=document.getElementById("updateBtn")
updateBtn.addEventListener('click',(e)=>{
    e.preventDefault()
    let student={
        sid: idInput.value,
        fname: fnameInput.value,
        lname: lnameInput.value,
        email: emailInput.value,
        password: passwordInput.value,
        mobileNumber: mobileNumberInput.value,
        address: addressInput.value

    }
    console.log(student);
    if(role==="Admin"){
        let admin={
        aid: idInput.value,
        fname: fnameInput.value,
        lname: lnameInput.value,
        email: emailInput.value,
        password: passwordInput.value,
        mobileNumber: mobileNumberInput.value,
        address: addressInput.value
        }
        let x=fetch(`http://localhost:8080/updateAdmin`,{
            method:"PUT",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(admin)
        })
        x.then((res)=>{
            return res.json();
        })
        .then(res=>{
        console.log(res.data);
        localStorage.setItem("id",res.data.aid)
        localStorage.setItem("fname",res.data.fname)
        localStorage.setItem("lname",res.data.lname)
        localStorage.setItem("email",res.data.email)
        localStorage.setItem("password",res.data.password)
        localStorage.setItem("address",res.data.address)
        localStorage.setItem("mobileNumber",res.data.mobileNumber)
        window.open("./profile.html")
        })
    }else if(role==="Student"){
    let x=fetch("http://localhost:8080/updatestudent",{
        method : "PUT",
        headers : {
            "Content-Type":"application/json"

        },
        body : JSON.stringify(student)
    })
    console.log(x);
    x.then(res=>res.json())
    .then(res=>{
        console.log(res.data);
        localStorage.setItem("id",res.data.sid)
        localStorage.setItem("fname",res.data.fname)
        localStorage.setItem("lname",res.data.lname)
        localStorage.setItem("email",res.data.email)
        localStorage.setItem("password",res.data.password)
        localStorage.setItem("address",res.data.address)
        localStorage.setItem("mobileNumber",res.data.mobileNumber)
        window.open("./profile.html")
        

        

        
    })
}
    
    
})