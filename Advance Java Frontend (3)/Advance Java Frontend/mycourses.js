let mycoursesContainer = document.getElementById("mycoursesContainer");
let sid = localStorage.getItem("id");
console.log(sid);
let x = fetch(`http://localhost:8080/fetchcourses/${sid}`);
console.log(x);
x.then(response=>{
    return response.json()
}).then(res=>{
    console.log(res.data);
    res.data.map((obj)=>{
        mycoursesContainer.innerHTML += `
        <div class="course">
            <h2><span>${obj.cid}</span>.${obj.cname}</h2>
            <p>Duration - ${obj.duration}</p>
            <p>Cost : <b>${obj.cost}</b> Rs/-</p>
        </div>
        `
    })
})