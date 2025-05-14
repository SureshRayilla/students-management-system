
let form=document.forms[0]
let cname=document.getElementById("cname")
let duration=document.getElementById("duration")
let cost=document.getElementById("cost")

form.addEventListener("submit",(e)=>{
    let course={
        cname:cname.value,
        duration:duration.value,
        cost:cost.value
    }
    console.log(course);

    let x=fetch(`http://localhost:8080/savecourse`,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(course)
    })
    x.then((res)=>{
        return res.json()
    })
    .then((res)=>{
        console.log(res);
        window.location.href="./courses.html"
        
    })
    .catch((error)=>{
        alert(error.msg)
    })
    

})

