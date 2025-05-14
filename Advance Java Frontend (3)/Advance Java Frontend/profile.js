let fname=localStorage.getItem("fname");
let id=localStorage.getItem("id");
let lname=localStorage.getItem("lname")
let email=localStorage.getItem("email")
let address=localStorage.getItem("address")
let mobileNumber=localStorage.getItem("mobileNumber")
let password=localStorage.getItem("password")
let role=localStorage.getItem("role")
let profile=document.getElementById("profile");
profile.innerHTML+=`  
    <tr>
    <td>Id:</td>
    <td>${id}</td>
    </tr>
    <tr>
    <td>first name:</td>
    <td>${fname}</td>
    </tr>
    <tr>
    <td>last name:</td>
    <td>${lname}</td>
    </tr>
    <tr>
    <td>email:</td>
    <td>${email}</td>
    </tr>
    <tr>
    <td>address:</td>
    <td>${address}</td>
    </tr>
    <tr>
    <td>mobile Number:</td>
    <td>${mobileNumber}</td>
    </tr>
    <tr>
    <td>password:</td>
    <td>${password}</td>
    </tr>
`
let deleteBtn=document.getElementById("deleteBtn")
deleteBtn.addEventListener("click",(e)=>{
    e.preventDefault()
    if(role==="Student"){
    let x=fetch(`http://localhost:8080/deletestudent/${id}`,{
        method: "DELETE",
        headers:{
            "Content-Type":"application/json"
        }
    })
    console.log(x);
    x.then((res)=>{
        return res.json()
    })
    .then((result)=>{
        alert("deleted successfully...")
        window.open("./index.html")

        
    })
}
else if(role==="Admin"){
    let x=fetch(`http://localhost:8080/deleteAdmin/${id}`,{
        method: "DELETE",
        headers:{
            "Content-Type":"application/json"
        }
    })
    console.log(x);
    x.then((res)=>{
        return res.json()
    })
    .then((result)=>{
        alert("deleted successfully...")
        window.open("./index.html")

        
    })
}
})
if(role==="Student"){
let x=fetch(`http://localhost:8080/fetchimg/${id}`)
console.log(x);
x.then(response=>{
    console.log(response);
    return response.blob();
    
})
.then(res=>{
    console.log(res);
    let y=URL.createObjectURL(res);
    console.log(y);
    document.getElementById("pic").src=y;
    
    
})
}else if(role==="Admin"){
    x=fetch(`http://localhost:8080/fetchadminimg/${id}`)
    x.then(response=>{
        console.log(response);
        return response.blob();
        
    })
    .then(res=>{
        console.log(res);
        let y=URL.createObjectURL(res);
        console.log(y);
        document.getElementById("pic").src=y;
        
        
    })
}

let fileInput=document.getElementById("fileInput")
let uploadImage=document.getElementById("uploadImgBtn")

uploadImage.addEventListener("click", ()=>{
    let file = fileInput.files[0];
    console.log(file);

    let formData = new FormData();
    formData.append("id", id);
    formData.append("file", file);
    if(role==="Student"){
    let x = fetch(`http://localhost:8080/uploadimage/${id}`, {
        method : "PUT",
        body : formData
    })
    console.log(x);
    x.then((response)=>{
        console.log(response);
        // console.log(response.json());
        return(response.json())
    }).then(res=>{
        console.log(res.msg);
        alert(res.msg);
        location.reload();
    })
}else if(role==="Admin"){
    let x = fetch(`http://localhost:8080/uploadadminimage/${id}`, {
        method : "PUT",
        body : formData
    })
    console.log(x);
    x.then((response)=>{
        console.log(response);
        // console.log(response.json());
        return(response.json())
    }).then(res=>{
        console.log(res.msg);
        alert(res.msg);
        location.reload();
    })
}
    
})

