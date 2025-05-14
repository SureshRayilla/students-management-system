let form=document.forms[0]
console.log(form)

form.addEventListener("submit",(e)=>
{
    e.preventDefault()
    let inputs=document.querySelectorAll("input")
    let fname=inputs[0].value
    let lname=inputs[1].value
    let email=inputs[2].value
    let password=inputs[3].value
    let number=inputs[4].value
    let address=inputs[5].value
    console.log(fname,lname,email,password,number,address);

    let admin={
        fname:fname,
        lname:lname,
        email:email,
        password:password,
        mobileNumber:number,
        address:address
    }
    let x=fetch("http://localhost:8080/saveAdmin",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(admin)

    });
    if(x.ok)
        {
            let result = x.json();
            console.log(result)
        }
        else{
            console.log("unable to get details")
        }
        window.open("./index.html")
    }
    
    


    

)

