let editCourse=document.getElementById("editCourse")
let cidInput=document.getElementById("cidInput")
let cnameInput=document.getElementById("cnameInput")
let durationInput=document.getElementById("durationInput")
let costInput=document.getElementById("costInput")

let form=document.forms[0];

let cid=localStorage.getItem("cid")

let x=fetch(`http://localhost:8080/fetchcourse/${cid}`)
console.log(x);
x.then((response)=>{
    return response.json();
})
.then((res)=>{
    console.log(res.data);
    console.log(res.data.cname);
    if(res.data!=null){
        cidInput.value=res.data.cid
        cnameInput.value=res.data.cname
        durationInput.value=res.data.duration
        costInput.value=res.data.cost
    }else{
        alert(res.data);
    }
})

form.addEventListener("submit",(e)=>{
    e.preventDefault();

    let updateCourse={
        cid:cidInput.value,
        cname:cnameInput.value,
        duration:durationInput.value,
        cost:costInput.value
    }
    console.log(updateCourse);

    let x=fetch(`http://localhost:8080/updateCourse`,{
        method:"PUT",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(updateCourse)

    })
    x.then((res)=>{
        return res.json();
    })
    .then((res)=>{
        alert(res.Msg);
        localStorage.removeItem("cid");
        window.location.href = "./courses.html";
    })
})

