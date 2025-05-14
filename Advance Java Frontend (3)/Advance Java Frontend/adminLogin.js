let form=document.forms[0]
console.log(form)

form.addEventListener("submit",(e)=>
{
    e.preventDefault()
    let inputs=document.querySelectorAll("input")
    let email=inputs[0].value
    let password=inputs[1].value
    console.log(email,password);

    let admin={
        email:email,
        password:password
    }

    let x=fetch("http://localhost:8080/loginAdmin",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(admin)

    })
    x.then(res=> {
        return res.json();
        
    })
    .then(res=>{
        if(typeof res.data == "string"){
            alert(res.data)
        }else{
            console.log(res.data);
            let{aid,fname,lname,email,password,mobileNumber,address}=res.data
            localStorage.setItem("id",aid)
            localStorage.setItem("fname",fname)
            localStorage.setItem("lname",lname)
            localStorage.setItem("email",email)
            localStorage.setItem("password",password)
            localStorage.setItem("mobileNumber",mobileNumber)
            localStorage.setItem("address",address)
            localStorage.setItem("role","Admin")
            window.open("./index.html")
            
        }
    })
    


    

}
)